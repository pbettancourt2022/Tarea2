package org.example;
enum Productos {
    COCACOLA(1, 500),
    SPRITE(2, 600),
    FANTA(3, 600),
    SNICKERS(4, 800),
    SUPER8(5, 500);

    private int numero; private int precio;

    Productos(int numero, int precio){
        this.numero = numero;
        this.precio = precio;
    }

    public int getNumero(){return this.numero;}
    public int getPrecio(){return this.precio;}
    public String toString(){
        return "Productos{" +
                "COCACOLA: numero = " + COCACOLA.numero + ", precio = " + COCACOLA.precio +
                "SPRITE: numero = " + SPRITE.numero + ", precio = " + SPRITE.precio +
                "FANTA: numero = " + FANTA.numero + ", precio = " + FANTA.precio +
                "SNICKERS: numero = " + SNICKERS.numero + ", precio = " + SNICKERS.precio +
                "SUPER8: numero = " + SUPER8.numero + ", precio = " + SUPER8.precio + '}';
    }
}

