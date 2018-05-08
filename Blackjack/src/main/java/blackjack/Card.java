
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
 *
 * @author mazz
 */
public class Card extends Parent {
    
    private String cardName, suit;
    private int cardValue;
    private BufferedImage cardImage;
    
    /**
     * The Card class constructor
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
    
    public void setCardSlot() {
        
        Rectangle cardSlot = new Rectangle(72,96);
        WritableImage cardFXImage = SwingFXUtils.toFXImage(cardImage, null);
        ImageView cardView = new ImageView(cardFXImage);
     
        getChildren().add(new StackPane(cardSlot, cardView));
    }
    
    public void hideCard() throws IOException {
        BufferedImage backside = ImageIO.read(new File("Cards/Backside.png"));
        this.cardImage = backside;
    }
    
    
    
}
