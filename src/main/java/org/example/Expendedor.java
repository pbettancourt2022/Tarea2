package org.example;

class Expendedor {
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private Deposito snickers;
    private Deposito super8;
    private Deposito monVu;
    private static int precio; //
    public Expendedor(int numProductos) {
        coca = new Deposito(); sprite = new Deposito();
        fanta = new Deposito(); snickers = new Deposito();
        super8 = new Deposito(); monVu = new Deposito();
        for (int i = 0; i < numProductos; i++) {
            coca.addElemento(new CocaCola(i + 100));
            sprite.addElemento(new Sprite(i + 200));
            fanta.addElemento(new Fanta(i+300));
            snickers.addElemento(new Snickers(i+400));
            super8.addElemento(new Super8(i+500));
        }

    }

    public Producto comprarProducto(Moneda m, int cual)throws PagoIncorrectoException, NoHayProductoException, PagoInsuficienteException  {
        Producto producto = null;
        Deposito temp = null;
        int precio = 0;

        if (cual == Productos.COCACOLA.getNumero()) {
            temp = coca;
            precio = Productos.COCACOLA.getPrecio();
        } else if (cual == Productos.SPRITE.getNumero()) {
            temp = sprite;
            precio = Productos.SPRITE.getPrecio();
        } else if (cual == Productos.FANTA.getNumero()) {
            temp = fanta;
            precio = Productos.FANTA.getPrecio();
        } else if (cual == Productos.SNICKERS.getNumero()) {
            temp = snickers;
            precio = Productos.SNICKERS.getPrecio();
        } else if (cual == Productos.SUPER8.getNumero()) {
            temp = super8;
            precio = Productos.SUPER8.getPrecio();
        }

        if (m == null) {
            throw new PagoIncorrectoException(m, monVu); // la idea es poner el exception funcional aqui
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            producto = (Producto) temp.getElemento();
            if (producto == null) { // se deberia agregar en este punto la excepcion de que no hay producto
                throw new NoHayProductoException(m, monVu);
            } else {
                while (valorVuelto != 0) {
                    monVu.addElemento(new Moneda100());
                    valorVuelto -= 100;
                }
            }
        } else if (m.getValor() < precio) {
            throw new PagoInsuficienteException(m, monVu); //otro exception a actualizar
        } else if (m.getValor() == precio) {
            producto = (Producto) temp.getElemento();
            if (producto == null) {
                int valorMoneda = m.getValor();
                while (valorMoneda != 0) {
                    monVu.addElemento(new Moneda100());
                    valorMoneda -= 100;
                }
            }
        }
        return producto;
    }

    public Moneda getVuelto() {
        return (Moneda) monVu.getElemento();
    }
}
