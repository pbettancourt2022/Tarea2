package org.example;

class Super8 extends Dulces {
    public Super8(int numSerie) {
        super(numSerie);
    }

    @Override
    public String comer() {
        return "super 8";
    }

    @Override
    public String getTipo() {
        return "Super 8";
    }
}