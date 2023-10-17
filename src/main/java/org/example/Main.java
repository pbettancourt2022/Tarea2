package org.example;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1, 1000);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 4; i++) {

            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        }


    }
}



