package org.example;
import java.lang.Comparable;

class Moneda100 extends Moneda implements Comparable<Moneda> {
    public Moneda100() {
        super();
    }

    @Override
    public int getValor() {
        return 100;
    }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 100}";
    }
    public int compareTo(Moneda100 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
