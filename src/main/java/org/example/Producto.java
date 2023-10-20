package org.example;

abstract class Producto{
    private int serie;

    public Producto(int numSerie) {
        this.serie = numSerie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String consumir();

    public abstract String getTipo();
}
