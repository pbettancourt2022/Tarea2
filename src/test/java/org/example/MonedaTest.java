package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonedaTest {
    private Moneda moneda100;
    private Moneda moneda500;
    private Moneda moneda1000;

    @BeforeEach
    public void setUp() {
        moneda100 = new Moneda100();
        moneda500 = new Moneda500();
        moneda1000 = new Moneda1000();
    }

    @Test
    public void obtenerValorDeMoneda() {
        assertEquals(100, moneda100.getValor());
        assertEquals(500, moneda500.getValor());
        assertEquals(1000, moneda1000.getValor());
    }

    @Test
    public void compararMonedas() {
        assertTrue(moneda100.compareTo(moneda500) < 0);
        assertTrue(moneda500.compareTo(moneda1000) < 0);
        assertTrue(moneda100.compareTo(moneda1000) < 0);
        assertTrue(moneda1000.compareTo(moneda100) > 0);
    }

    @Test
    public void toStringMoneda() {
        assertEquals("Moneda{serie = Moneda1000, valor = null}", moneda1000.toString());
    }
}
