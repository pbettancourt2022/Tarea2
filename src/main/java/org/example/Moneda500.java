package org.example;

class Moneda500 extends Moneda implements Comparable<Moneda> {
    public Moneda500() {
        super();
    }

    @Override
    public int getValor() {
        return 500;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 500}";
    }
    public int compareTo(Moneda500 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
