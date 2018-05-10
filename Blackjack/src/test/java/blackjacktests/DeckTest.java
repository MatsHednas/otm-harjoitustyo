/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjacktests;

import blackjack.Deck;
import java.io.IOException;
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
public class DeckTest {
    
    public DeckTest() {
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
    public void buildsADeckOf52Cards() throws IOException {
        Deck deck = new Deck();
        deck.buildDeck();
        assertEquals(Integer.toString(deck.deckSize()), "52");
    }
    
    @Test
    public void drawingACardRemovesItFromTheDeck() throws IOException {
        Deck deck = new Deck();
        deck.buildDeck();
        deck.drawCard();
        assertEquals(Integer.toString(deck.deckSize()), "51");
    }
}
