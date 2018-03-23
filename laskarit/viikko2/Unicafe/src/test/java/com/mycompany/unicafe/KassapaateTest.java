/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

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
public class KassapaateTest {
    
    Kassapaate kassa;
    Maksukortti kortti;
    Maksukortti kortti1;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        kortti = new Maksukortti(1000);
        kortti1 = new Maksukortti(200);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void rahanJaLounaidenMaaraOikea() {
        
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0,kassa.edullisiaLounaitaMyyty());
        assertEquals(0,kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateiOstoMaksuRiittavaEdullisilla() {
        kassa.syoEdullisesti(300);
        
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateiOstoMaksuRiittavaMaukkailla() {
        kassa.syoMaukkaasti(500);
        
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateiOstoMaksuEiRiittavaEdullisilla() {
        kassa.syoEdullisesti(200);
        
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateiOstoMaksuEiRiittavaMaukkailla() {
        kassa.syoMaukkaasti(300);
        
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoMaksuRiittavaEdullisilla() {
                
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoMaksuRiittavaMaukkailla() {
                
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoMaksuEiRiittavaEdullisilla() {
                
        assertFalse(kassa.syoEdullisesti(kortti1));
        assertEquals(200, kortti1.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiOstoMaksuEiRiittavaMaukkailla() {
                
        assertFalse(kassa.syoMaukkaasti(kortti1));
        assertEquals(200, kortti1.saldo());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiLatausToimiiOikein1() {
        kassa.lataaRahaaKortille(kortti, 100);
        
        assertEquals(1100, kortti.saldo());
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void korttiLatausEiTeeMitaanJosNegattivinenSumma() {
        kassa.lataaRahaaKortille(kortti, -100);
        
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
}
