package org.example;

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }

    @Override
    public int getValor() {
        return 100;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 100";
    }
}
