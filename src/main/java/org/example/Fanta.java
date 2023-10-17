package org.example;

class Fanta extends Bebida {
    public Fanta(int numSerie) {
        super(numSerie);
    }

    @Override
    public String beber() {
        return "fanta";
    }

    @Override
    public String getTipo() {
        return "Fanta";
    }
}