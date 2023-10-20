package org.example;

class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA =3;
    public static final int SNICKERS = 4;
    public static final int SUPER8 = 5;

    private static int precio;

    public Expendedor(int numProductos, int precioProductos) {
        coca = new Deposito(); sprite = new Deposito();
        fanta = new Deposito(); snickers = new Deposito();
        super8 = new Deposito(); monVu = new Deposito();
        precio = precioProductos;
        for (int i = 0; i < numProductos; i++) {
            coca.addElemento(new CocaCola(i + 100));
            sprite.addElemento(new Sprite(i + 200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i+400));
            super8.addElemento(new Super8(i+500));
        }

    }

    public Producto comprarProducto(Moneda m, int cual)throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException  {
        Producto producto= null;

        if (m == null) {
            throw new PagoIncorrectoException(m,monVu);
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            if (cual == COCA) {
                producto = (Producto) coca.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);

                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == SPRITE) {
                producto = (Producto) sprite.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == FANTA) {
                producto = (Producto) fanta.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            }else if (cual == SNICKERS) {
                producto = (Producto) snickers.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == SUPER8) {
                producto = (Producto) super8.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            }
            else {
                throw new NoHayProductoException(m, monVu);
            }
        } else if (m.getValor() < precio) {
            throw new PagoInsuficienteException(m, monVu);
        } else if (m.getValor() == precio) {
            int valorMoneda = m.getValor();
            if (cual == COCA) {
                producto = (Producto) coca.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                }
            } else if (cual == SPRITE) {
                producto = (Producto) sprite.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                }
            } else if (cual == FANTA) {
                producto = (Producto) fanta.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                }
            } else if (cual == SNICKERS) {
                producto = (Producto) snickers.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                }
            } else if (cual == SUPER8) {
                producto = (Producto) super8.getElemento();
                if (producto == null) {
                    throw new NoHayProductoException(m, monVu);
                }
            }
            else {
                throw new NoHayProductoException(m, monVu);
            }
        }

        return producto;
    }

    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
}
