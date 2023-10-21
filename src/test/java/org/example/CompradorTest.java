package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Expendedor expendedor;
    private Expendedor exp;

    @BeforeEach
    public void setUp() {
        expendedor = new Expendedor(3);
        exp = new Expendedor(0);// Crear un Expendedor con 3 productos de cada tipo
    }

    @Test
    public void compraExitosa() {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        try {
            Comprador comprador = new Comprador(moneda1000, Productos.COCACOLA.getNumero(), expendedor);
            assertEquals("cocacola", comprador.queBebiste());
            assertEquals(500, comprador.cuantoVuelto());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void compraConPagoInsuficiente() {
        Moneda moneda500 = new Moneda500(); // Moneda de 500 pesos
        assertThrows(PagoInsuficienteException.class, () -> {
            Comprador comprador = new Comprador(moneda500, Productos.SPRITE.getNumero(), expendedor);
        });
    }


    @Test
    public void compraSinProducto() {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        try {
            Comprador comprador = new Comprador(moneda1000, Productos.COCACOLA.getNumero(), exp);
            assertNull(comprador.queBebiste());
            assertEquals(1000, comprador.cuantoVuelto());
            fail("Se esperaba una NoHayProductoException pero no se lanzó.");
        } catch (NoHayProductoException e) {
            // Se espera que lance una NoHayProductoException, por lo que esta parte es exitosa.
        } catch (Exception e) {
            fail("Se esperaba una NoHayProductoException, pero se lanzó una excepción diferente: " + e.getClass().getName());
        }
    }


    @Test
    public void compraConPagoIncorrecto() {
        try {
            Comprador comprador = new Comprador(null, Productos.FANTA.getNumero(), expendedor);
            fail("Se esperaba una PagoIncorrectoException pero no se lanzó.");
        } catch (PagoIncorrectoException e) {
            // Se espera que lance una PagoIncorrectoException, por lo que esta parte es exitosa.
        } catch (Exception e) {
            fail("Se esperaba una PagoIncorrectoException, pero se lanzó una excepción diferente: " + e.getClass().getName());
        }

    }
}
