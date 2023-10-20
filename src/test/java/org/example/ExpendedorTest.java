package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpendedorTest {
    private Expendedor expendedor;

    @BeforeEach
    public void setUp() {
        expendedor = new Expendedor(3); // Crear un Expendedor con 3 productos de cada tipo
    }

    @Test
    public void comprarProductoExitoso() {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        try {
            Producto producto = expendedor.comprarProducto(moneda1000, Productos.COCACOLA.getNumero());
            assertNotNull(producto);
        } catch (Exception e) {
            fail("No se esperaba una excepción: " + e.getMessage());
        }
    }

    @Test
    public void comprarProductoConPagoInsuficiente() {
        Moneda moneda500 = new Moneda500(); // Moneda de 500 pesos
        try {
            expendedor.comprarProducto(moneda500, Productos.SPRITE.getNumero());
            fail("Se esperaba PagoInsuficienteException");
        } catch (PagoInsuficienteException e) {
            // Éxito: Se esperaba esta excepción
        } catch (Exception e) {
            fail("Excepción incorrecta: " + e.getMessage());
        }
    }

    @Test
    public void comprarProductoConPagoIncorrecto() {
        Moneda moneda100 = new Moneda100(); // Moneda de 100 pesos
        try {
            expendedor.comprarProducto(moneda100, Productos.FANTA.getNumero());
            fail("Se esperaba PagoIncorrectoException");
        } catch (PagoIncorrectoException e) {
            // Éxito: Se esperaba esta excepción
        } catch (Exception e) {
            fail("Excepción incorrecta: " + e.getMessage());
        }
    }

    @Test
    public void comprarProductoSinProducto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        expendedor.comprarProducto(moneda1000, Productos.COCACOLA.getNumero()); // Compra un producto
        try {
            expendedor.comprarProducto(moneda1000, Productos.COCACOLA.getNumero()); // Intenta comprar otro producto
            fail("Se esperaba NoHayProductoException");
        } catch (NoHayProductoException e) {
            // Éxito: Se esperaba esta excepción
        } catch (Exception e) {
            fail("Excepción incorrecta: " + e.getMessage());
        }
    }

    @Test
    public void obtenerVuelto() throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        Moneda moneda1000 = new Moneda1000(); // Moneda de 1000 pesos
        expendedor.comprarProducto(moneda1000, Productos.COCACOLA.getNumero()); // Compra un producto
        Moneda vuelto = expendedor.getVuelto();
        assertNotNull(vuelto);
        assertEquals(1000, vuelto.getValor());
    }
}