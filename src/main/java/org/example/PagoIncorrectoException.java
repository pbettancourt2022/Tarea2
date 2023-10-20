package org.example;

class PagoIncorrectoException {
    public PagoIncorrectoException(Moneda m, Deposito monVu) {
        monVu.addElemento(m);
    }
}
