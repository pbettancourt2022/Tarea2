package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositoTest {
    private Deposito<Moneda> depositoMonedas;
    private Deposito<Bebida> depositoBebidas;

    @BeforeEach
    public void setUp() {
        depositoMonedas = new Deposito<>();
        depositoBebidas = new Deposito<>();
    }

    @Test
    public void agregarYObtenerElemento() {
        Moneda moneda100 = new Moneda100();
        Bebida cocaCola = new CocaCola(1);

        depositoMonedas.addElemento(moneda100);
        depositoBebidas.addElemento(cocaCola);

        Moneda monedaRecuperada = depositoMonedas.getElemento();
        Bebida bebidaRecuperada = depositoBebidas.getElemento();

        assertNotNull(monedaRecuperada);
        assertNotNull(bebidaRecuperada);
        assertEquals(moneda100, monedaRecuperada);
        assertEquals(cocaCola, bebidaRecuperada);
    }

    @Test
    public void obtenerElementoDesdeDepositoVacio() {
        Moneda monedaRecuperada = depositoMonedas.getElemento();
        Bebida bebidaRecuperada = depositoBebidas.getElemento();

        assertNull(monedaRecuperada);
        assertNull(bebidaRecuperada);
    }
}
