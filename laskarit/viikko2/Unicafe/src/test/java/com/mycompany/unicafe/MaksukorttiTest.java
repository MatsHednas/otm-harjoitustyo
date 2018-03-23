package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(100);
    }
    
    @Test
    public void checkaaSaldo() {
        int saldotesti = kortti.saldo();
        
        assertEquals(saldotesti, 100);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void saldoKasvaaOikein() {
        kortti.lataaRahaa(100);
        
        assertEquals("saldo: 2.0", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosTarpeeksiRahaa() {
        kortti.otaRahaa(10);
        
        assertEquals("saldo: 0.90", kortti.toString());
    }
    
    @Test
    public void saldoEiVaheneJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(101);
    
        assertEquals("saldo: 1.0", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaOikeanArvon() {
    
        assertFalse(kortti.otaRahaa(101));
        assertTrue(kortti.otaRahaa(100));
    }
}
