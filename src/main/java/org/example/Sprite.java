package org.example;

class Sprite extends Bebida {
    public Sprite(int numSerie) {
        super(numSerie);
    }

    @Override
    public String beber() {
        return "sprite";
    }

    @Override
    public String getTipo() {
        return "Sprite";
    }
}