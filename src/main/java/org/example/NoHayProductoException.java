package org.example;
class NoHayProductoException extends Exception {
    public NoHayProductoException(Moneda m, Deposito monVu) {
        super("No hay productos disponibles en el depósito.");
        monVu.addElemento(m);
    }
}


