package org.example;

class Moneda1500 extends Moneda implements Comparable<Moneda>{
    public Moneda1500() {
            super();
        }
    @Override
    public int getValor() {
            return 1500;
        }
    public String toString(){
        return "Moneda{" +
                "serie = " + this +
                "valor = 1500}";
    }
    public int compareTo(Moneda1500 o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
