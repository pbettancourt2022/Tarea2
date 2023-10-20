package org.example;

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }

    @Override
    public int getValor() {
        return 1000;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 1000";
    }

}
