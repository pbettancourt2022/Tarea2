package org.example;
import java.lang.Comparable;
abstract class Moneda implements Comparable<Moneda>{
    public Moneda() {}

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = " + null + '}';
    }
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}

