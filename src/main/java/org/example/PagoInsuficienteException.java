package org.example;

class PagoInsuficienteException {
    public PagoInsuficienteException(Moneda m, Deposito monVu) {
        monVu.addElemento(m);
    }

}
