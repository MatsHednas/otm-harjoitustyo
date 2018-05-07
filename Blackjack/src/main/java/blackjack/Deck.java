/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import static blackjack.Deck.RandomRange;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mazz
 */
public class Deck {
    
    private ArrayList<Card> Cards;
    
    public Deck() {
        
        this.Cards = new ArrayList<>();
        
    }
    
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
                
                this.Cards.add(card);             
            }
            
            int currentFaceCard;
            String currentFace = null;
            
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
                this.Cards.add(faceCard);
            }
            
            Card aceCard = new Card("Ace", suit, 11);
            String nameOfAce = aceCard.toString();
            aceCard.setCardImage(ImageIO.read(new File("Cards/" + aceCard +".png")));
            this.Cards.add(aceCard);
        }
    }
    
    public Card drawCard() {
        int random = RandomRange(0, this.Cards.size() - 1);
        Card card = this.Cards.get(random);
        this.Cards.remove(card);
        return card;
    }
    
    public int listSize() {
        int list = this.Cards.size();
        return list;
    }
    
    public static int RandomRange(int min, int max) {
        int range = (max - min) + 1;
        return (int)(Math.random()*range) + min;
    }
    
}
