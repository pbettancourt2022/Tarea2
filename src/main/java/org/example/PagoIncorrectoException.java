package org.example;

class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(Moneda m, Deposito monVu) {
        super("El pago es incorrecto.");
        monVu.addElemento(m);
    }
}
