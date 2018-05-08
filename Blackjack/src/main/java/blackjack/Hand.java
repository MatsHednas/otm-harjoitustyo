/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;


import java.io.File;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javax.imageio.ImageIO;


/**
 *
 * @author mazz
 */
public class Hand {
        
    private ObservableList<Node> cardsInHand;
    private SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);
    private int numberOfAces = 0;
    
    public Hand(ObservableList<Node> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }
    
    public void addCard(Card card) {
        cardsInHand.add(card);
        
        if(card.getCardValue() == 11) {
            numberOfAces++;
        }
        
        if(valueOfHand.get() + card.getCardValue() > 21 && numberOfAces > 0) {
            valueOfHand.set(valueOfHand.get() + card.getCardValue() - 10);
            numberOfAces--;
        } else {
            valueOfHand.set(valueOfHand.get() + card.getCardValue());
        }
    }
    
    public void clear() {
        cardsInHand.clear();
        valueOfHand.set(0);
        numberOfAces = 0;
    }
    
    public SimpleIntegerProperty valueProperty() {
        return valueOfHand;
    }
    
    public SimpleIntegerProperty getValue() {
        return valueOfHand;
    }
    
    public void showHidden() throws IOException {
        Card toBeShown = (Card) cardsInHand.get(1);
        String name = toBeShown.toString();
        toBeShown.setCardImage(ImageIO.read(new File("Cards/" + name +".png")));
        toBeShown.setCardSlot();
        
    }
    
    public int getSize() {
        return this.cardsInHand.size();
    }
    
}
