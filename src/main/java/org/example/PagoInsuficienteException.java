package org.example;

class PagoInsuficienteException extends Exception {
    public PagoInsuficienteException(Moneda m, Deposito monVu) {
        super("El pago es insuficiente para comprar el producto.");

    }

}
