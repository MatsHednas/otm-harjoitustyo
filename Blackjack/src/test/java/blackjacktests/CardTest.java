/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacktests;

import blackjack.Card;
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
    
}
