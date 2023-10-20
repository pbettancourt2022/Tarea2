package org.example;
class NoHayProductoException {
    public NoHayProductoException(Moneda m, Deposito monVu) {
        monVu.addElemento(m);
    }
}


