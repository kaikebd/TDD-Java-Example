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
    
    @Test
    void testReiniciarMeiaNoite() {
        Relogio relogio = new Relogio();
        relogio.setHora(10);
        relogio.setMinuto(30);
        relogio.setSegundo(45);
        
        relogio.reiniciarMeiaNoite();
        
        assertEquals(0, relogio.getHora());
        assertEquals(0, relogio.getMinuto());
        assertEquals(0, relogio.getSegundo());
    }

    @Test
    void testMarcarIntervalo() {
        Relogio relogio = new Relogio();
        
        String intervalo = relogio.marcarIntervalo(10, 30, 0, 11, 15, 30);
        
        assertEquals("00:45:30", intervalo);
    }

    @Test
    void testImprimeFormato24h() {
        Relogio relogio = new Relogio();
        relogio.setHora(15);
        relogio.setMinuto(40);
        relogio.setSegundo(5);
        
        String formato24h = relogio.imprimeFormato24h();
        
        assertEquals("15:40:05", formato24h);
    }

    @Test
    void testImprimeFormatoAMPM() {
        Relogio relogioAM = new Relogio();
        relogioAM.setHora(10);
        relogioAM.setMinuto(30);
        relogioAM.setSegundo(0);
        
        String formatoAM = relogioAM.imprimeFormatoAMPM();
        
        assertEquals("10:30:00 AM", formatoAM);
        
        Relogio relogioPM = new Relogio();
        relogioPM.setHora(20);
        relogioPM.setMinuto(45);
        relogioPM.setSegundo(30);
        
        String formatoPM = relogioPM.imprimeFormatoAMPM();
        
        assertEquals("08:45:30 PM", formatoPM);
    }

    @Test
    void testAtualizaTempo() {
        Relogio relogio = new Relogio();
        
        relogio.atualizaTempo(8, 15, 30);
        
        assertEquals(8, relogio.getHora());
        assertEquals(15, relogio.getMinuto());
        assertEquals(30, relogio.getSegundo());
    }
}