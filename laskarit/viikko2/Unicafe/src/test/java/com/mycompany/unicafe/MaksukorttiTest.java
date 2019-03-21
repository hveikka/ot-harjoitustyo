package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldoLisayksenJalkeenOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }

    @Test
    public void Otetaan() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }

    @Test
    public void eiOtetaTyhjasta() {
        kortti.otaRahaa(5);
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.5", kortti.toString());
    }

    @Test
    public void trueJosRahaa() {
        kortti.otaRahaa(5);

        assertTrue(kortti.otaRahaa(3));
    }

    @Test
    public void falseJosEiRahaa() {
        kortti.otaRahaa(5);

        assertFalse(kortti.otaRahaa(10));
    }

    @Test
    public void korttiPrinttaaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());

    }
}
