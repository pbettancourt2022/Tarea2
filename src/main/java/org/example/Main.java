package org.example;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(0, 1000);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 4; i++) {
            m=new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        }


    }
}



