/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacktests;

import blackjack.Card;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
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
public class CardTest {
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void theConstructorWorksProperly() {
        Card card = new Card("Ace", "spades", 11);
        assertEquals("Ace_of_spades", card.toString());
    }
    
    @Test
    public void returnsTheRightValue() {
        Card card = new Card("Ace", "spades", 11);
        assertEquals(Integer.toString(card.getCardValue()), "11");
    }
    
    @Test
    public void setsAndReturnCorrectImage() throws IOException {
        Card card = new Card("Ace", "spades", 11);
        BufferedImage image = ImageIO.read(new File("Cards/Ace_of_spades.png"));
        
        card.setCardImage(image);
        
        byte[] byteArrayTest = ((DataBufferByte) image.getData().getDataBuffer()).getData();
        byte[] byteArrayCard = ((DataBufferByte) card.getCardImage().getData().getDataBuffer()).getData();
        
        assertArrayEquals(byteArrayTest, byteArrayCard);
    }
    
    @Test
    public void hidesCardCorreclty() throws IOException {
        Card card = new Card("Ace", "spades", 11);
        BufferedImage image = ImageIO.read(new File("Cards/Ace_of_spades.png"));
        
        card.setCardImage(image);
        
        card.hideCard();
        BufferedImage backside = ImageIO.read(new File("Cards/Backside.png"));
        
        byte[] byteArrayTest = ((DataBufferByte) backside.getData().getDataBuffer()).getData();
        byte[] byteArrayCard = ((DataBufferByte) card.getCardImage().getData().getDataBuffer()).getData();
        
        assertArrayEquals(byteArrayTest, byteArrayCard);
        
    }
    
}
