package org.example;

public class Main {
    public static void main(String[] args) {
        // Expendedor 1, se prueba que la compra sea exitosa en todos los productos, además se prueba qué ocurre cuando no hay productos.
        Expendedor exp = new Expendedor(2);
        Moneda m = null;
        Comprador c = null;
        Moneda moneda;

        for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.COCACOLA.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SPRITE.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } for (int i = 0; i < 3; i++) {
            moneda = null;
            try {
                m= moneda;
                c = new Comprador(m, Productos.FANTA.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } for (int i = 0; i < 3; i++) {
            moneda = new Moneda1000();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SNICKERS.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } for (int i = 0; i < 3; i++) {
            moneda = new Moneda100();
            try {
                m= moneda;
                c = new Comprador(m, Productos.SUPER8.getNumero(), exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage()+" Vuelto: $"+ moneda.getValor());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}



