package blackjack;


import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javax.imageio.ImageIO;

/**
 * The hand contains an ObservableList of cards.
 */
public class Hand {
        
    private ObservableList<Node> cardsInHand;
    private SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);
    private int numberOfAces = 0;
    
    /**
     * The constructor of the Hand class.
     * @param cardsInHand the ObservableList that contains the cards in the hand
     */
    public Hand(ObservableList<Node> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
    
    /**
     * Adds a card to the hand and increments the value of the hand by
     * the value of the added card.
     * @param card is the card is to be added
     */
    public void addCard(Card card) {
        cardsInHand.add(card);
        
        if (card.getCardValue() == 11) {
            numberOfAces++;
        }
        
        if (valueOfHand.get() + card.getCardValue() > 21 && numberOfAces > 0) {
            valueOfHand.set(valueOfHand.get() + card.getCardValue() - 10);
            numberOfAces--;
        } else {
            valueOfHand.set(valueOfHand.get() + card.getCardValue());
        }
    }
    
    /**
     * Clears the hand, removing all cards and resetting the value of the hand
     * as well as the number of aces.
     */
    public void clear() {
        cardsInHand.clear();
        valueOfHand.set(0);
        numberOfAces = 0;
    }
    
    /**
     * The added value of the cards in the hand.
     * @return the value of the hand
     */
    public SimpleIntegerProperty valueProperty() {
        return valueOfHand;
    }
  
    /**
     * Shows the face of the dealers second card.
     * @throws IOException if the image file isn't found
     */
    public void showHidden() throws IOException {
        Card toBeShown = (Card) cardsInHand.get(1);
        String name = toBeShown.toString();
        toBeShown.setCardImage(ImageIO.read(new File("Cards/" + name + ".png")));
        toBeShown.setCardSlot();
        
    }
    
    
    /**
     * The amount of cards in the hand.
     * @return the amount of cards in the hand
     */
    public int getSize() {
        return this.cardsInHand.size();
    }
    
    /**
     * The number of aces in the hand.
     * @return the amount of aces in the hand
     */
    public int getNumberOfAces() {
        return this.numberOfAces;
    }
    
}
