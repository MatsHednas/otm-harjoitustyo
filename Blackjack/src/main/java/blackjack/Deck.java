package blackjack;

import static blackjack.Deck.RandomRange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * The Deck consists of and ArrayList of cards.
 */
public class Deck {
    
    private ArrayList<Card> Cards;
    
    /**
     * The constructor for the Deck class
     */
    public Deck() {
        
        this.Cards = new ArrayList<>();
        
    }
    
    /**
     * Builds the deck by creating all the cards and adding them to the deck
     * @throws IOException if an image file isn't found
     */
    public void buildDeck() throws IOException {
        
        this.Cards.clear();
        
        int currentSuit;
        String suit;
        
        for(currentSuit = 0; currentSuit < 4; currentSuit++) {
            
            switch (currentSuit) {
                case 0:
                    suit = "spades";
                    break;
                case 1:
                    suit = "clubs";
                    break;
                case 2:
                    suit = "hearts";
                    break;
                default:
                    suit = "diamonds";
                    break;
            }
            
            int currentCard;
            
            for(currentCard = 2; currentCard < 11; currentCard++) {
                
                String cardName = Integer.toString(currentCard);
                
                Card card = new Card(cardName, suit, currentCard);
                
                String nameofCard = card.toString();
                card.setCardImage(ImageIO.read(new File("Cards/" + nameofCard +".png")));
                card.setCardSlot();
                
                this.Cards.add(card);             
            }
            
            int currentFaceCard;
            String currentFace;
            
            for(currentFaceCard = 0; currentFaceCard < 3; currentFaceCard++) {
                
                switch (currentFaceCard){
                case 0:
                    currentFace = "Jack";
                    break;
                case 1:
                    currentFace = "Queen";
                    break;
                default:
                    currentFace = "King";
                    break;
            }
                Card faceCard = new Card(currentFace, suit, 10);
                
                String nameOfFaceCard = faceCard.toString();
                faceCard.setCardImage(ImageIO.read(new File("Cards/" + nameOfFaceCard +".png")));
                faceCard.setCardSlot();
                this.Cards.add(faceCard);
            }
            
            Card aceCard = new Card("Ace", suit, 11);
            String nameOfAce = aceCard.toString();
            aceCard.setCardImage(ImageIO.read(new File("Cards/" + aceCard +".png")));
            aceCard.setCardSlot();
            this.Cards.add(aceCard);
        }
    }
    
    /**
     * Draws a random card from the deck
     * @return the card that is drawn
     */
    public Card drawCard() {
        int random = RandomRange(0, this.Cards.size() - 1);
        Card card = this.Cards.get(random);
        this.Cards.remove(card);
        return card;
    }
    
    /**
     * @return the amount of cards in the deck
     */
    public int deckSize() {
        int sizeOfDeck = this.Cards.size();
        return sizeOfDeck;
    }
    
    /**
     * 
     * @param min the minimum value that can be returned
     * @param max the maximum value that can be returned
     * @return a random value between the min and max value
     */
    public static int RandomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random()*range) + min;
    }
    
}
