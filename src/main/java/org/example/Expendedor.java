package org.example;

class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;
    private int precio;
    public Expendedor(int numProductos, int precio) {
        coca = new Deposito(); sprite = new Deposito();
        fanta = new Deposito(); snickers = new Deposito();
        super8 = new Deposito(); monVu = new Deposito();
        this.precio = precio;
        for (int i = 0; i < numProductos; i++) {
            coca.addElemento(new CocaCola(i + 100));
            sprite.addElemento(new Sprite(i + 200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i+400));
            super8.addElemento(new Super8(i+500));
        }

    }


    public Producto comprarProducto(Moneda m, int cual) {
        Producto producto = null;
/*
        if(cual == Productos.COCACOLA.getNumero()){
            if (m == null){
                new PagoIncorrectoException(m, monVu);
                return producto;
            }
            else if(m.getValor() > Productos.COCACOLA.getPrecio()){
                int valorMoneda = m.getValor();
                int valorVuelto = m.getValor() - Productos.COCACOLA.getPrecio();
                if (cual == Productos.COCACOLA.getNumero()) {
                    producto = (Producto) coca.getElemento();
                    if (producto == null) {
                        new NoHayProductoException(m, monVu);
                        return null;
                    } else {
                        while (valorVuelto != 0) {
                            monVu.addElemento(new Moneda100());
                            valorVuelto = valorVuelto - 100;
                        }
                        return producto;
                    }
                }
            } else if (m.getValor() < Productos.COCACOLA.getPrecio()) {
                    new PagoInsuficienteException(m, monVu);
                    return null;
            } else if (m.getValor() == Productos.COCACOLA.getPrecio()) {
                int valorMoneda = m.getValor();
                producto = (Producto) coca.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
        } else if(cual == Productos.SPRITE.getNumero()) {
            if (m == null) {
                new PagoIncorrectoException(m, monVu);
                return producto;
            } else if (m.getValor() > Productos.SPRITE.getPrecio()) {
                int valorMoneda = m.getValor();
                int valorVuelto = m.getValor() - Productos.SPRITE.getPrecio();
                if (cual == Productos.SPRITE.getNumero()) {
                    producto = (Producto) sprite.getElemento();
                    if (producto == null) {
                        while(valorMoneda != 0){
                            monVu.addElemento(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return producto;
                    } else {
                        while (valorVuelto != 0) {
                            monVu.addElemento(new Moneda100());
                            valorVuelto = valorVuelto - 100;
                        }
                        return producto;
                    }
                }
            } else if (m.getValor() < Productos.SPRITE.getPrecio()) {
                new PagoInsuficienteException(m, monVu);
                return null;
            } else if (m.getValor() == Productos.SPRITE.getPrecio()) {
                int valorMoneda = m.getValor();
                producto = (Producto) sprite.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            }
        } else if(cual == Productos.FANTA.getNumero()) {
            if (m == null) {
                new PagoIncorrectoException(m, monVu);
                return producto;
            } else if (m.getValor() > Productos.FANTA.getPrecio()) {
                int valorMoneda = m.getValor();
                int valorVuelto = m.getValor() - Productos.FANTA.getPrecio();
                if (cual == Productos.FANTA.getNumero()) {
                    producto = (Producto) fanta.getElemento();
                    if (producto == null) {
                        while(valorMoneda != 0){
                            monVu.addElemento(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return producto;
                    } else {
                        while (valorVuelto != 0) {
                            monVu.addElemento(new Moneda100());
                            valorVuelto = valorVuelto - 100;
                        }
                        return producto;
                    }
                }
            } else if (m.getValor() < Productos.FANTA.getPrecio()) {
                new PagoInsuficienteException(m, monVu);
                return null;
            } else if (m.getValor() == Productos.FANTA.getPrecio()) {
                int valorMoneda = m.getValor();
                producto = (Producto) fanta.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            }
        } else if(cual == Productos.SNICKERS.getNumero()) {
            if (m == null) {
                new PagoIncorrectoException(m, monVu);
                return producto;
            } else if (m.getValor() > Productos.SNICKERS.getPrecio()) {
                int valorMoneda = m.getValor();
                int valorVuelto = m.getValor() - Productos.SNICKERS.getPrecio();
                if (cual == Productos.SNICKERS.getNumero()) {
                    producto = (Producto) snickers.getElemento();
                    if (producto == null) {
                        while(valorMoneda != 0){
                            monVu.addElemento(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return producto;
                    } else {
                        while (valorVuelto != 0) {
                            monVu.addElemento(new Moneda100());
                            valorVuelto = valorVuelto - 100;
                        }
                        return producto;
                    }
                }
            } else if (m.getValor() < Productos.SNICKERS.getPrecio()) {
                new PagoInsuficienteException(m, monVu);
                return null;
            } else if (m.getValor() == Productos.SNICKERS.getPrecio()) {
                int valorMoneda = m.getValor();
                producto = (Producto) snickers.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            }
        } if(cual == Productos.SUPER8.getNumero()) {
            if (m == null) {
                new PagoIncorrectoException(m, monVu);
                return producto;
            } else if (m.getValor() > Productos.SUPER8.getPrecio()) {
                int valorMoneda = m.getValor();
                int valorVuelto = m.getValor() - Productos.SUPER8.getPrecio();
                if (cual == Productos.SUPER8.getNumero()) {
                    producto = (Producto) super8.getElemento();
                    if (producto == null) {
                        while(valorMoneda != 0){
                            monVu.addElemento(new Moneda100());
                            valorMoneda = valorMoneda - 100;
                        }
                        return producto;
                    } else {
                        while (valorVuelto != 0) {
                            monVu.addElemento(new Moneda100());
                            valorVuelto = valorVuelto - 100;
                        }
                        return producto;
                    }
                }
            } else if (m.getValor() < Productos.SUPER8.getPrecio()) {
                new PagoInsuficienteException(m, monVu);
                return null;
            } else if (m.getValor() == Productos.SUPER8.getPrecio()) {
                int valorMoneda = m.getValor();
                producto = (Producto) super8.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            }
        }
*/

        if (m == null) {
            new PagoIncorrectoException(m,monVu);
            return producto;
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            if (cual == Productos.COCACOLA.getNumero()) {
                producto = (Producto) coca.getElemento();
                if (producto == null) {
                    new NoHayProductoException(m, monVu);
                    return null;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == Productos.SPRITE.getNumero()) {
                producto = (Producto) sprite.getElemento();
                if (producto == null) {
                    while(valorMoneda != 0){
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return producto;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == Productos.FANTA.getNumero()) {
                producto = (Producto) fanta.getElemento();
                if (producto == null) {
                    while(valorMoneda != 0){
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return producto;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            }else if (cual == Productos.SNICKERS.getNumero()) {
                producto = (Producto) snickers.getElemento();
                if (producto == null) {
                    while(valorMoneda != 0){
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return producto;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            } else if (cual == Productos.SUPER8.getNumero()) {
                producto = (Producto) super8.getElemento();
                if (producto == null) {
                    while(valorMoneda != 0){
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return producto;
                } else {
                    while (valorVuelto != 0) {
                        monVu.addElemento(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return producto;
                }
            }
            else {
                return null;
            }
        } else if (m.getValor() < precio) {
            new PagoInsuficienteException(m, monVu);
            return null;
        } else if (m.getValor() == precio) {
            int valorMoneda = m.getValor();
            if (cual == 1) {
                producto = (Producto) coca.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == 2) {
                producto = (Producto) sprite.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == 3) {
                producto = (Producto) fanta.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == 4) {
                producto = (Producto) snickers.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            } else if (cual == 5) {
                producto = (Producto) super8.getElemento();
                if (producto == null) {
                    while (valorMoneda != 0) {
                        monVu.addElemento(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                }
            }
            else {
                while (valorMoneda != 0) {
                    monVu.addElemento(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                return null;
            }
        }
        return producto;
    }

    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
}
