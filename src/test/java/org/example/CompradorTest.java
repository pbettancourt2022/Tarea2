package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompradorTest {
    private Expendedor expendedor;

    @BeforeEach
    public void setUp() {
        expendedor = new Expendedor(3); // Crear un Expendedor con 3 productos de cada tipo
    }

    @Test
    public void compraExitosa() {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        try {
            Comprador comprador = new Comprador(moneda1000, Productos.COCACOLA.getNumero(), expendedor);
            assertEquals("cocacola", comprador.queBebiste());
            assertEquals(0, comprador.cuantoVuelto());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void compraConPagoInsuficiente() {
        Moneda moneda500 = new Moneda500(); // Moneda de 500 pesos
        try {
            Comprador comprador = new Comprador(moneda500, Productos.SPRITE.getNumero(), expendedor);
            assertNull(comprador.queBebiste());
            assertEquals(500, comprador.cuantoVuelto());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void compraSinProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        expendedor.comprarProducto(moneda1000, Productos.COCACOLA.getNumero()); // Compra un producto
        try {
            Comprador comprador = new Comprador(moneda1000, Productos.COCACOLA.getNumero(), expendedor);
            assertNull(comprador.queBebiste());
            assertEquals(1000, comprador.cuantoVuelto());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void compraConPagoIncorrecto() {
        Moneda moneda100 = new Moneda100(); // Moneda de 100 pesos
        try {
            Comprador comprador = new Comprador(moneda100, Productos.FANTA.getNumero(), expendedor);
            assertNull(comprador.queBebiste());
            assertEquals(100, comprador.cuantoVuelto());
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }
}
