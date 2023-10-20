package org.example;

abstract class Dulce extends Producto{
    private int serie;

    public Dulce(int numSerie) {
        super(numSerie);
        this.serie = numSerie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String consumir();

    public abstract String getTipo();
}
