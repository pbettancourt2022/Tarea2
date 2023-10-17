package org.example;

import java.util.ArrayList;

class DepositoM {
    private ArrayList<Moneda> almacen;

    public DepositoM() {
        this.almacen = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda moneda) {
        almacen.add(moneda);
    }

    public Moneda getMoneda() {
        if (almacen.size() != 0) {
            Moneda aux = almacen.get(0);
            almacen.remove(0);
            return aux;
        } else {
            return null;
        }
    }
}
