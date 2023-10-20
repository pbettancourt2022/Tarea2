package org.example;

import java.util.ArrayList;

class Deposito<T> {
    private ArrayList<T> almacen;

    public Deposito() {
        this.almacen = new ArrayList<>();
    }

    public void addElemento(T elemento) {
        almacen.add(elemento);
    }

    public T getElemento() {
        if (!almacen.isEmpty()) {
            return almacen.remove(0);
        } else if (almacen.isEmpty()) {
            return null;
        }
        return null;
    }
}
