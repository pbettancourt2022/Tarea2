package org.example;

public class Main {
    public static void main(String[] args) {
        // Expendedor 1, se prueba que la compra sea exitosa en todos los productos, además se prueba qué ocurre cuando no hay productos.
        Expendedor exp = new Expendedor(2, 500);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 3; i++) {
            m = new Moneda1000();
            c = new Comprador(m, Productos.COCACOLA.getNumero(), exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        } for (int i = 0; i < 3; i++) {
            m = new Moneda1000();
            c = new Comprador(m, Productos.SPRITE.getNumero(), exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        } for (int i = 0; i < 3; i++) {
            m = new Moneda1000();
            c = new Comprador(m, Productos.FANTA.getNumero(), exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        } for (int i = 0; i < 3; i++) {
            m = new Moneda1000();
            c = new Comprador(m, Productos.SNICKERS.getNumero(), exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        } for (int i = 0; i < 3; i++) {
            m = new Moneda1000();
            c = new Comprador(m, Productos.SUPER8.getNumero(), exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        }





    }
}



