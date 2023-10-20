package org.example;

class Snickers extends Dulce {
    public Snickers(int numSerie) {
        super(numSerie);
    }

    @Override
    public String consumir() {
        return "snickers";
    }

    @Override
    public String getTipo() {
        return "Snickers";
    }
}