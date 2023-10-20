package org.example;

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        vuelto = 0;

        if (m == null) {
            sonido = null;
        } else {
            Producto bebida = exp.comprarProducto(m, cualBebida);

            if (bebida != null) {
                sonido = bebida.consumir();
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
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste() {
        return sonido;
    }
}
