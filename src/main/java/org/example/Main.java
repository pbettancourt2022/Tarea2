package org.example;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(3, 500);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 4; i++) {

            m = new Moneda1000();
            c = new Comprador(m, Expendedor.FANTA, exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        }


    }
}



