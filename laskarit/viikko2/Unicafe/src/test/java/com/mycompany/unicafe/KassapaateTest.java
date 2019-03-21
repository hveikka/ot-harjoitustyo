package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }

    @Test
    public void kassapaateToimii() {
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }

    @Test
    public void kateinenToimii() {
        paate.syoEdullisesti(240);
        assertEquals(100240, paate.kassassaRahaa());
        assertEquals(260, paate.syoEdullisesti(500));
        assertEquals(2, paate.edullisiaLounaitaMyyty());

    }

    @Test
    public void kateinenEiRiita() {
        assertEquals(50, paate.syoEdullisesti(50));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());

    }

    @Test
    public void korttiToimii() {
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());

    }
    @Test
    public void eirahaaEiruokaa() {
        kortti.otaRahaa(900);
        assertFalse(paate.syoEdullisesti(kortti));
        assertFalse(paate.syoMaukkaasti(kortti));
        assertEquals(0,paate.edullisiaLounaitaMyyty());
        assertEquals(0,paate.maukkaitaLounaitaMyyty());
        assertEquals(100, kortti.saldo());

    }

    @Test
    public void korttiEiVieRahoja() {
        paate.syoEdullisesti(kortti);
        assertEquals(100000, paate.kassassaRahaa());

    }

}
