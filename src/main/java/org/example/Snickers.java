package org.example;

class Snickers extends Dulces {
    public Snickers(int numSerie) {
        super(numSerie);
    }

    @Override
    public String comer() {
        return "snicker";
    }

    @Override
    public String getTipo() {
        return "Snicker";
    }
}