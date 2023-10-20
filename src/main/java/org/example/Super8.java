package org.example;

class Super8 extends Dulce {
    public Super8(int numSerie) {
        super(numSerie);
    }

    @Override
    public String consumir() {
        return "super 8";
    }

    @Override
    public String getTipo() {
        return "Super 8";
    }
}