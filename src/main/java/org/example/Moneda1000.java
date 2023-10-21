package org.example;

class Moneda1000 extends Moneda implements Comparable<Moneda> {
    public Moneda1000() {
        super();
    }

    @Override
    public int getValor() {
        return 1000;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + getClass().getSimpleName() +
                ", valor = 1000}";
    }
    public int compareTo(Moneda1000 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }

}
