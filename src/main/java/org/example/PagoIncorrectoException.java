package org.example;

class PagoIncorrectoException {
    public PagoIncorrectoException(Moneda m, DepositoM monVu) {
        monVu.addMoneda(m);
    }
}
