package org.example;

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }

    @Override
    public int getValor() {
        return 500;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 500}";
    }
}
