package org.example;

import java.util.ArrayList;

class Deposito {
    private ArrayList<Bebida> almacen;

    public Deposito() {
        this.almacen = new ArrayList<Bebida>();
    }

    public void addBebida(Bebida bebida) {
        almacen.add(bebida);
    }

    public Bebida getBebida() {
        if (almacen.size() != 0) {
            return almacen.remove(0);
        } else if (almacen.size() == 0) {
            return null;
        }
        return null;
    }
}
