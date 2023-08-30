package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RelogioTest {

    @Test
    void testaConstrutor() {
        Relogio relogio = new Relogio();
        assertEquals(0, relogio.getHora());
        assertEquals(0, relogio.getMinuto());
        assertEquals(0, relogio.getSegundo());
    }

    @Test
    void testaSetHora() {
        Relogio relogio = new Relogio();
        relogio.setHora(12);
        assertEquals(12, relogio.getHora());

        relogio.setHora(-1);
        assertEquals(0, relogio.getHora());

        relogio.setHora(24);
        assertEquals(0, relogio.getHora());
    }

    @Test
    void testaSetMinuto() {
        Relogio relogio = new Relogio();
        relogio.setMinuto(10);
        assertEquals(10, relogio.getMinuto());

        relogio.setMinuto(-1);
        assertEquals(0, relogio.getMinuto());

        relogio.setMinuto(60);
        assertEquals(0, relogio.getMinuto());
    }

    @Test
    void testaSetSegundo() {
        Relogio relogio = new Relogio();
        relogio.setSegundo(59);
        assertEquals(59, relogio.getSegundo());

        relogio.setSegundo(-1);
        assertEquals(0, relogio.getSegundo());

        relogio.setSegundo(60);
        assertEquals(0, relogio.getSegundo());
    }

    @Test
    void testaToString() {
        Relogio relogio = new Relogio();
        assertEquals("00:00:00", relogio.toString());

        relogio.setHora(12);
        relogio.setMinuto(10);
        relogio.setSegundo(59);
        assertEquals("12:10:59", relogio.toString());
    }
}