package org.example;

class Expendedor {
    private final Deposito coca;
    private final Deposito sprite;
    private final Deposito fanta;
    private final Deposito monVu;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA =3;

    private static int precio;

    public Expendedor(int numBebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        monVu = new Deposito();
        precio = precioBebidas;
        for (int i = 0; i < numBebidas; i++) {
            coca.addElemento(new CocaCola(i + 100));
            sprite.addElemento(new Sprite(i + 200));
            fanta.addElemento(new Fanta(i+300));
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
                bebida = (Bebida) coca.getElemento();
                if (bebida == null) {
                    new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return bebida;
                }
            } else if (cual == SPRITE) {
                bebida = (Bebida) sprite.getElemento();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return bebida;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return bebida;

                }
            } else {
                new NoHayProductoException(m, monVu);
                return null;
            }
        } else if (m.getValor() < precio) {
            new PagoInsuficienteException(m, monVu);
            return null;
        } else if (m.getValor() == precio) {
            int valorMoneda = m.getValor();
            if (cual == COCA) {
                bebida = (Bebida) coca.getElemento();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == SPRITE) {
                bebida = (Bebida) sprite.getElemento();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else {
                while (valorMoneda != 0) {
                    monVu.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                return null;
            }
        }

        return bebida;
    }

    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
}
