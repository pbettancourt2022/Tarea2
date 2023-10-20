package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) throws NoHayProductoException, PagoInsuficienteException, PagoIncorrectoException {
        vuelto = 0;
            Producto producto = exp.comprarProducto(m, cualBebida);

            if (producto != null) {
                sonido = producto.consumir();
                while ((m = exp.getVuelto()) != null) {
                    vuelto = vuelto + m.getValor();
                }
            } else {
                sonido = null;
                while ((m = exp.getVuelto()) != null) {
                    vuelto = vuelto + m.getValor();
                }

            }

    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }
}
