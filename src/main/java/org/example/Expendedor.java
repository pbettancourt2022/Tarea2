package org.example;

class Expendedor {
    private final Deposito coca;
    private final Deposito sprite;
    private final DepositoM monVu;
    public static final int COCA = 1;
    public static final int SPRITE = 2;

    private static int precio;

    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new DepositoM();
        precio = precioBebidas;
        for (int i = 0; i < numBebidas; i++) {
            coca.addBebida(new CocaCola(i + 100));
            sprite.addBebida(new Sprite(i + 200));
        }

    }

    public Bebida comprarBebida(Moneda m, int cual) {
        Bebida bebida = null;

        if (m == null) {
            new PagoIncorrectoException(m,monVu);
            return bebida;
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            if (cual == COCA) {
                bebida = coca.getBebida();
                if (bebida == null) {
                    new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return bebida;
                }
            } else if (cual == SPRITE) {
                bebida = sprite.getBebida();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return bebida;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return bebida;

                }
            } else {
                while (valorMoneda != 0) {
                    monVu.addMoneda(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                return null;
            }
        } else if (m.getValor() < precio) {
            new PagoInsuficienteException(m, monVu);
            return null;
        } else if (m.getValor() == precio) {
            int valorMoneda = m.getValor();
            if (cual == COCA) {
                bebida = coca.getBebida();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == SPRITE) {
                bebida = sprite.getBebida();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else {
                while (valorMoneda != 0) {
                    monVu.addMoneda(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                return null;
            }
        }

        return bebida;
    }

    public Moneda getVuelto() {
        return monVu.getMoneda();
    }
}
