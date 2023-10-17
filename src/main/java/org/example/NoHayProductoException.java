package org.example;
class NoHayProductoException {
    public NoHayProductoException(Moneda m, DepositoM monVu) {
        monVu.addMoneda(m);
    }
}


