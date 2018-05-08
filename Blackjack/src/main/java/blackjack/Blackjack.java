/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.image.BufferedImage;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
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
 *
 * @author mazz
 */
public class Blackjack extends Application {
    
    private Deck deck = new Deck();
    private Hand dealer;
    private Hand player;
    private Text situationMessage = new Text();
    
    private HBox playersCards = new HBox(20);
    private HBox dealersCards = new HBox(20);
    
    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);
    
    Text dealersHandValue = new Text("Dealer: ");
    
    SimpleIntegerProperty cash = new SimpleIntegerProperty(10000);
    int money = cash.intValue();
    String bank = Integer.toString(money);
    int betValue = 10;
    String betString = null;
    
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
      //betmat.setFill(Color.RED);
      
      
      //PLAYMAT
      
      StackPane playmatStack = new StackPane();
      
      VBox playmatVBox = new VBox(50);
      playmatVBox.setAlignment(Pos.CENTER);
      
      
      Text playersHandValue = new Text("Player: ");
      
      playmatVBox.getChildren().addAll(dealersHandValue, dealersCards, situationMessage, playersCards, playersHandValue);
      playmatStack.getChildren().addAll(playmat, playmatVBox);
      
      //BETMAT
      
      StackPane betmatStack = new StackPane();
      
      VBox betmatVBox = new VBox(20);
      betmatVBox.setAlignment(Pos.CENTER);
      
      final TextField bet = new TextField("BET");
      //bet.setDisable(true);
      bet.setMaxWidth(60);
      Text saldo = new Text("");
      saldo.setFill(Color.WHITE);
      
      Button btnPlay = new Button("PLAY");
      Button btnHit = new Button("HIT");
      Button btnStand = new Button("STAND");
      
      HBox buttonHBox = new HBox(20);
      buttonHBox.setAlignment(Pos.CENTER);
      btnHit.setDisable(true);
      btnStand.setDisable(true);
      buttonHBox.getChildren().addAll(btnHit, btnStand);
      betmatVBox.getChildren().addAll(bet, btnPlay, saldo, buttonHBox);
      betmatStack.getChildren().addAll(betmat, betmatVBox);
      
      // ADD BOTH SIDES STACKPANES TO THE ROOT LAYOUT
      
      rootLayout.getChildren().addAll(playmatStack, betmatStack);
      root.getChildren().addAll(base, rootLayout);
      
      // BIND THE PROPERTIES
      
      btnPlay.disableProperty().bind(playable);
      btnHit.disableProperty().bind(playable.not());
      btnStand.disableProperty().bind(playable.not());
      
      playersHandValue.textProperty().bind(new SimpleStringProperty("Player: ").concat(player.valueProperty().asString()));
      saldo.textProperty().bind(new SimpleStringProperty("Money: ").concat(cash.asString()).concat("$"));
      
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
          money = newValue.intValue();
          bank = Integer.toString(money);
      }
      );
      
      
      
      
      //INIT BUTTONS
      
      btnPlay.setOnAction(event -> {
          try {
              cash.set(cash.intValue() - betValue);
              newGame();
          } catch (IOException ex) {
              Logger.getLogger(Blackjack.class.getName()).log(Level.SEVERE, null, ex);
          }
      });
      
      btnHit.setOnAction(event -> { 
          player.addCard(deck.drawCard());
      });
      
      btnStand.setOnAction(event -> {
        
          
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
      
      return root;
      
    }
    
    private void newGame() throws IOException {
        playable.set(true);
        situationMessage.setText("");
        dealersHandValue.textProperty().setValue("Dealer: ");
        deck.buildDeck();
        //cash.set(cash.intValue() - betValue);
        
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
            cash.set(cash.intValue() + betValue);
        
        } else if (playerValue == 21 && player.getSize() == 2) {
            dealer.showHidden();
            situationMessage.setText("BLACKJACK! THE PLAYER WINS");
            cash.set(cash.intValue() + 3 * betValue);    
            
        } else if (playerValue == 21 || dealerValue > 21 || playerValue > dealerValue){
            dealer.showHidden();
            situationMessage.setText("THE PLAYER WINS");
            cash.set(cash.intValue() + 2 * betValue);
        
            
        } else {
            dealer.showHidden();
            situationMessage.setText("Unexpected outcome, bets returned. Sorry about that!");
        }
        dealersHandValue.textProperty().unbind();
        
    }
   
    
    
     
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        primaryStage.setScene(new Scene(createGame()));
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Blackjack");
        primaryStage.setResizable(false);
        primaryStage.show();
    } 
    

    
    public static void main(String[] args) throws IOException {
        launch(args);
       /**
        Deck deck = new Deck();
        deck.buildDeck();
        Card card = deck.drawCard();
        String plzwork = card.toString();
        System.out.println(plzwork);
        String sizeoflist = Integer.toString(deck.listSize());
        System.out.println(sizeoflist);
        
        JFrame window = new JFrame("Card Image");
        window.setSize(400, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
        JPanel content = new JPanel(new BorderLayout());
        
        JLabel cardcontent = new JLabel(new ImageIcon(card.getCardImage()));
        cardcontent.setSize(300, 400);
        
        content.add(cardcontent);
        window.add(content);
        
        deck.buildDeck();
        sizeoflist = Integer.toString(deck.listSize());
        System.out.println(sizeoflist); 
        */
        
    }

    
    
}
