package blackjack;

import javafx.scene.shape.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.layout.StackPane;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 * Each card has a name, suit and value. An BufferedImage can also be added
 * to give the card an image representation.
 */
public class Card extends Parent {
    
    private String cardName, suit;
    private int cardValue;
    private BufferedImage cardImage;
    
    /**
     * The constructor for the Card class
     * @param name = 2,3,4,...,Jack,Queen,King,Ace
     * @param suit "spades","clubs","hearts","diamonds"
     * @param value = 1,2,3,...8,9,10,11
     * cardImage An image representation of the card
     */
    public Card(String name, String suit, int value) {
        
        this.cardName = name;
        this.suit = suit;
        this.cardValue = value;
        this.cardImage = null;
        
    }
    
    /**
     * @return a string representation of the card
     */
    public String toString() {
        return cardName + "_of_" + suit;
    }
    
    /**
     * @return the value of the card as an integer
     */
    public int getCardValue() {
        return cardValue;
    }
    
    /**
     * @return an image representation of the card as a BufferedImage
     */
    public BufferedImage getCardImage() {
        return cardImage;
    }
    
    /**
     * @param image sets a BufferedImage as the cards image
     */
    public void setCardImage(BufferedImage image) {
        this.cardImage = image;
    }
    
    /**
     * Makes a "slot" for the card by creating a StackPane with the cards image
     * which can then later be added to the main game-interface.
     */
    public void setCardSlot() {
        
        Rectangle cardSlot = new Rectangle(72,96);
        WritableImage cardFXImage = SwingFXUtils.toFXImage(cardImage, null);
        ImageView cardView = new ImageView(cardFXImage);
     
        getChildren().add(new StackPane(cardSlot, cardView));
    }
    
    /**
     * "Hides" the card by changing the image of the card to an image of the backside
     * of a playing card
     * @throws IOException if the image file isn't found
     */
    public void hideCard() throws IOException {
        BufferedImage backside = ImageIO.read(new File("Cards/Backside.png"));
        this.cardImage = backside;
    }
    
    
    
}
