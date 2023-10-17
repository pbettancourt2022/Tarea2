package org.example;

abstract class Dulces {
    private int serie;

    public Dulces(int numSerie) {
        this.serie = numSerie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String comer();

    public abstract String getTipo();
}
