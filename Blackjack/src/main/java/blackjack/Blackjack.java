package blackjack;

import java.awt.image.BufferedImage;
import javafx.geometry.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * This is the main game class. The game utilizes a deck, two hands(one for the player
 * and one for the dealer) as well as several other variables to build up the interface
 * and make the background logic work.
 * Some comments are added for clarification
 */
public class Blackjack extends Application {
    
    private Deck deck = new Deck();
    private Hand dealer;
    private Hand player;
    private Text situationMessage = new Text();
    
    private HBox playersCards = new HBox(20);
    private HBox dealersCards = new HBox(20);
    
    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty gameOver = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty betTooBig = new SimpleBooleanProperty(false);
    
    Text dealersHandValue = new Text("Dealer: ");
    
    SimpleIntegerProperty cash = new SimpleIntegerProperty(1001);
    int cashAsInt = cash.intValue();
    String cahAsString = Integer.toString(cashAsInt);
    SimpleIntegerProperty betValue = new SimpleIntegerProperty(0);
    int betAsInt = betValue.intValue();
    String betAsString = Integer.toString(betAsInt);
    
    /**
     * This method creates the actual interface of the game as well as sets up all the variables
     * @return the root Pane of the game
     */
    private Parent createGame() {
        
      dealer = new Hand(dealersCards.getChildren());
      player = new Hand(playersCards.getChildren());
      
      Pane root = new Pane();
      root.setPrefSize(800, 600);
      
      Region base =  new Region();
      base.setPrefSize(800, 600);
      base.setStyle("-fx-background-color: black");
      
      HBox rootLayout = new HBox(30);
      rootLayout.setPadding(new Insets(5, 5, 5, 5));
      
      
      
      Rectangle playmat = new Rectangle(550, 560);
      playmat.setArcHeight(50);
      playmat.setArcWidth(50);
      playmat.setFill(Color.GREEN);
      
      Rectangle betmat = new Rectangle(230, 640);
      betmat.setArcHeight(50);
      betmat.setWidth(50);
      
      
      //Here we set up the playmat where the cards are displayed etc
      
      StackPane playmatStack = new StackPane();
      
      VBox playmatVBox = new VBox(50);
      playmatVBox.setAlignment(Pos.CENTER);
      
      
      Text playersHandValue = new Text("Player: ");
      
      playmatVBox.getChildren().addAll(dealersHandValue, dealersCards, situationMessage, playersCards, playersHandValue);
      playmatStack.getChildren().addAll(playmat, playmatVBox);
      
      //Here we set up the betmat where the player controls the game
      
      StackPane betmatStack = new StackPane();
      
      VBox betmatVBox = new VBox(20);
      betmatVBox.setAlignment(Pos.CENTER);
      
      Text betAmount = new Text("");
      betAmount.setText("");
      betAmount.setFill(Color.WHITE);
      Text saldo = new Text("");
      saldo.setFill(Color.WHITE);
      Text filler1 = new Text("");
      Text filler2 = new Text("");
      
      Button bet1 = new Button("1$");
      Button bet10 = new Button("10$");
      Button bet25 = new Button("25$");
      Button bet50 = new Button("50$");
      Button bet100 = new Button("100$");
      Button bet500 = new Button("500$");
      
      Button play = new Button("PLAY");
      Button hit = new Button("HIT");
      Button stand = new Button("STAND");
      Button reset = new Button("RESET GAME");
      
      HBox hitAndStandHBox = new HBox(20);
      HBox bet1And10HBox = new HBox(20);
      HBox bet25And50HBox = new HBox(20);
      HBox bet100And500HBox = new HBox(20);
      
      hitAndStandHBox.setAlignment(Pos.CENTER);
      bet1And10HBox.setAlignment(Pos.CENTER);
      bet25And50HBox.setAlignment(Pos.CENTER);
      bet100And500HBox.setAlignment(Pos.CENTER);
      hit.setDisable(true);
      stand.setDisable(true);
      hitAndStandHBox.getChildren().addAll(hit, stand);
      bet1And10HBox.getChildren().addAll(bet1, bet10);
      bet25And50HBox.getChildren().addAll(bet25, bet50);
      bet100And500HBox.getChildren().addAll(bet100, bet500);
      betmatVBox.getChildren().addAll(bet1And10HBox, bet25And50HBox, 
              bet100And500HBox, betAmount, play, saldo, hitAndStandHBox,
              filler1, filler2, reset);
      betmatStack.getChildren().addAll(betmat, betmatVBox);
      
      // Here we add both stacks to the root layout
      
      rootLayout.getChildren().addAll(playmatStack, betmatStack);
      root.getChildren().addAll(base, rootLayout);
      
      // Here we bind our various properties to follow the situation of the game
      
      BooleanBinding playBond = playable.or(gameOver).or(betTooBig);
      play.disableProperty().bind(playBond);
      hit.disableProperty().bind(playable.not());
      stand.disableProperty().bind(playable.not());
      bet1.disableProperty().bind(playable);
      bet10.disableProperty().bind(playable);
      bet25.disableProperty().bind(playable);
      bet50.disableProperty().bind(playable);
      bet100.disableProperty().bind(playable);
      bet500.disableProperty().bind(playable);
      reset.disableProperty().bind(gameOver.not());
      
      playersHandValue.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
      saldo.textProperty().bind(new SimpleStringProperty("Money: ").concat(cash.asString()).concat("$"));
      betAmount.textProperty().bind(new SimpleStringProperty("Bet: ").concat(betValue.asString()).concat("$"));
      
      // Here we add the listeners that are needed to keep the game interface up-to-date
      
      player.valueProperty().addListener((obs, old, newValue) -> {
          if (newValue.intValue() >= 21) {
              try {
                  endGame();
              } catch (IOException ex) {
                  Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      });
      
      dealer.valueProperty().addListener((obs, old, newValue) -> {
          if (newValue.intValue() == 21) {
              try {
                  endGame();
              } catch (IOException ex) {
                  Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
      });
      
      cash.addListener((obs, old, newValue) -> {
          cashAsInt = newValue.intValue();
          cahAsString = Integer.toString(cashAsInt);
      });
      
      betValue.addListener((obs, old, newValue) -> {
          betAsInt = newValue.intValue();
          betAsString = Integer.toString(betAsInt);
      }
      );
      
      // Here we determine what our various buttons do
      
      play.setOnAction(event -> {
          try {
              if(cash.intValue() - betValue.intValue() < 0) {
                  situationMessage.setText("INSUFFICIENT FUNDS");
              } else {
              cash.set(cash.intValue() - betValue.intValue());
              newGame();
              }
          } catch (IOException ex) {
              Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      hit.setOnAction(event -> { 
          player.addCard(deck.drawCard());
      });
      
      stand.setOnAction(event -> {
        
          
          try {
              dealer.showHidden();
          } catch (IOException ex) {
              Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
          }
          while (dealer.valueProperty().get() < 17) {
              dealer.addCard(deck.drawCard());
          }
          
          try {
              endGame();
          } catch (IOException ex) {
              Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      bet1.setOnAction(event -> {
          if(cash.intValue() >= 1) {
          betValue.set(1);
          situationMessage.setText("");
          betTooBig.set(false);
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      bet10.setOnAction(event -> {
          if(cash.intValue() >= 10) {
          betValue.set(10);
          situationMessage.setText("");
          betTooBig.set(false);
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      bet25.setOnAction(event -> {
          if(cash.intValue() >= 25) {
          betValue.set(25);
          situationMessage.setText("");
          betTooBig.set(false);
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      bet50.setOnAction(event -> {
          if(cash.intValue() >= 50) {
          betValue.set(50);
          situationMessage.setText("");
          betTooBig.set(false);
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      bet100.setOnAction(event -> {
          if(cash.intValue() >= 100) {
          betValue.set(100);
          situationMessage.setText("");
          betTooBig.set(false);
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      bet500.setOnAction(event -> {
          if(cash.intValue() >= 500) {
          betValue.set(500);
          situationMessage.setText("");
          betTooBig.set(false);
            
          
          } else {
              situationMessage.setText("INSUFFICIENT FUNDS");
          }
      });
      
      reset.setOnAction(event -> {
          cash.set(10000);
          gameOver.set(false);
          betTooBig.set(false);
          situationMessage.setText("");
      });
      
      return root;
      
    }
    
    /**
     * This method gets called whenever we press the "PLAY" button, it rebuilds the deck
     * clears the hands and deals new cards
     * @throws IOException if an image isn't found
     */
    private void newGame() throws IOException {
        playable.set(true);
        situationMessage.setText("");
        dealersHandValue.textProperty().setValue("Dealer: ");
        deck.buildDeck();
        
        dealer.clear();
        player.clear();
        
        dealer.addCard(deck.drawCard());
        Card hiddenCard = deck.drawCard();
        BufferedImage hiddenCardsFace = hiddenCard.getCardImage();
        hiddenCard.hideCard();
        hiddenCard.setCardSlot();
        dealer.addCard(hiddenCard);
        player.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        
    }
    
    /**
     * This method is called whenever requirements of ending the game has been met. The method determines
     * the winner of the game and checks if the game is over.
     * @throws IOException if the hidden card cannot be shown because the image file isn't found
     */
    private void endGame() throws IOException {
        playable.set(false);
        dealersHandValue.textProperty().bind(new SimpleStringProperty("Dealer: ").concat(dealer.valueProperty().asString()));
        
        int dealerValue = dealer.valueProperty().get();
        int playerValue = player.valueProperty().get();
        
        if(dealerValue == 21 || playerValue > 21 || dealerValue < 21 && 
             dealerValue > playerValue) {
            dealer.showHidden();
            situationMessage.setText("THE DEALER WINS");
            
        } else if (dealerValue == playerValue) {
            dealer.showHidden();
            situationMessage.setText("IT'S A PUSH");
            cash.set(cash.intValue() + betValue.intValue());
        
        } else if (playerValue == 21 && player.getSize() == 2) {
            dealer.showHidden();
            situationMessage.setText("BLACKJACK! THE PLAYER WINS");
            cash.set(cash.intValue() + 3 * betValue.intValue());    
            
        } else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue){
            dealer.showHidden();
            situationMessage.setText("THE PLAYER WINS");
            cash.set(cash.intValue() + 2 * betValue.intValue());
        
            
        } else {
            dealer.showHidden();
            situationMessage.setText("Unexpected outcome, bets returned. Sorry about that!");
        }
        dealersHandValue.textProperty().unbind();
        if(cash.intValue() < 1) {
            gameOver.set(true);
            situationMessage.setText("GAME OVER");
        }
        
        if(cash.intValue() < betValue.intValue()) {
            betTooBig.set(true);
        }
        
    }
   
    
    /**
     * The start method creates the game window and launches the application within it
     * @param primaryStage the actual game window
     * @throws Exception if the game cannot be created
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setScene(new Scene(createGame()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Blackjack");
        primaryStage.setResizable(false);
        primaryStage.show();
    } 
    

    /**
     * The main method that launches the application
     * @param args the arguments of the application
     * @throws IOException if the game cannot be started
     */
    public static void main(String[] args) throws IOException {
        launch(args);
    }

    
    
}
