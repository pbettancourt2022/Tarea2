package org.example;

class PagoInsuficienteException {
    public PagoInsuficienteException(Moneda m, DepositoM monVu) {
        monVu.addMoneda(m);
    }

}
