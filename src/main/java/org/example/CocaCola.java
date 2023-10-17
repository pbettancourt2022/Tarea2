package org.example;

class CocaCola extends Bebida {
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    @Override
    public String beber() {
        return "cocacola";
    }

    @Override
    public String getTipo() {
        return "CocaCola";
    }
}
