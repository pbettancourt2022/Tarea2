package org.example;

abstract class Moneda {

    public Moneda() {

    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = " + null;
    }
}

