
package blackjack;

import java.awt.image.BufferedImage;

/**
 *
 * @author mazz
 */
public class Card {
    
    private String cardName, suit;
    private int cardValue;
    private BufferedImage cardImage;
    
    /**
     * The Card class constructor
     * @param name = 2,3,4,...,Jack,Queen,King,Ace
     * @param suit "spades","clubs","hearts","diamonds"
     * @param value = 1,2,3,...8,9,10,11
     * @param cardImage An image of the card
     */
    public Card(String name, String suit, int value) {
        
        this.cardName = name;
        this.suit = suit;
        this.cardValue = value;
        this.cardImage = null;
        
    }
    
    /**
     * This returns the name and suit of the card in String form
     * @return 
     */
    public String toString() {
        return cardName + "_of_" + suit;
    }
    
    /**
     * Returns the value of the card as an integer
     * @return 
     */
    public int getCardValue() {
        return cardValue;
    }
    
    /**
     * Returns the image of the card as a BufferedImage
     * @return 
     */
    public BufferedImage getCardImage() {
        return cardImage;
    }
    
    /**
     * 
     * @param image Sets a BuffereImage as the cards image
     */
    public void setCardImage(BufferedImage image) {
        this.cardImage = image;
    }
            
    
    
    
}
