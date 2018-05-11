/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacktests;

import blackjack.Card;
import blackjack.Hand;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javax.imageio.ImageIO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mazz
 */
public class HandTest {
    
    public HandTest() {
    }
  
    /**
     * Checks that the card is added correctly if the value of the hand is under 21 
     * and also that the valueProperty, getNumberOfAces and getSize methods work properly
     */
    @Test
    public void cardIsAddedCorrectlyIfSumUnder21() {
        HBox testCards = new HBox(20);;
        SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);

        
        Hand hand = new Hand(testCards.getChildren());
        Card card = new Card("Ace", "spades", 11);
        hand.addCard(card);
        
        assertEquals(Integer.toString(hand.valueProperty().intValue()), "11");
        assertEquals(Integer.toString(hand.getNumberOfAces()), "1");
        assertEquals(Integer.toString(hand.getSize()), "1");
        
    }
    
    @Test
    public void cardIsAddedCorrectlyIfSumOver21() {
        HBox testCards = new HBox(20);
        SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);

        
        Hand hand = new Hand(testCards.getChildren());
        Card card1 = new Card("Ace", "spades", 11);
        Card card2 = new Card("Ace", "clubs", 11);
        Card card3 = new Card("9", "spades", 9);

        
        hand.addCard(card1);
        hand.addCard(card2);
        hand.addCard(card3);

        
        assertEquals(Integer.toString(hand.valueProperty().intValue()), "21");
        assertEquals(Integer.toString(hand.getNumberOfAces()), "1");
        assertEquals(Integer.toString(hand.getSize()), "3");
        
    }
    
    @Test
    public void handIsClearedCorrectly() {
        HBox testCards = new HBox(20);;
        SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);

        
        Hand hand = new Hand(testCards.getChildren());
        Card card = new Card("Ace", "spades", 11);
        hand.addCard(card);
        
        hand.clear();
        
        assertEquals(Integer.toString(hand.valueProperty().intValue()), "0");
        assertEquals(Integer.toString(hand.getNumberOfAces()), "0");
        assertEquals(Integer.toString(hand.getSize()), "0");
    }
    
    @Test
    public void showsHiddenCardCorrectly() throws IOException {
        HBox testCards = new HBox(20);
        SimpleIntegerProperty valueOfHand = new SimpleIntegerProperty(0);

        
        Hand hand = new Hand(testCards.getChildren());
        
        Card card1 = new Card("Ace", "spades", 11);
        Card card2 = new Card("Ace", "hearts", 11);
        BufferedImage image1 = ImageIO.read(new File("Cards/Ace_of_spades.png"));
        BufferedImage image2 = ImageIO.read(new File("Cards/Ace_of_hearts.png"));
        
        card1.setCardImage(image1);
        card2.setCardImage(image2);
        hand.addCard(card1);
        card2.hideCard();
        hand.addCard(card2);
        
        hand.showHidden();
        Card toBeShown = (Card) testCards.getChildren().get(1);
        
        
        byte[] byteArrayTest = ((DataBufferByte) image2.getData().getDataBuffer()).getData();
        byte[] byteArrayCard = ((DataBufferByte) toBeShown.getCardImage().getData().getDataBuffer()).getData();
        
        assertArrayEquals(byteArrayTest, byteArrayCard);
      
    }

}
