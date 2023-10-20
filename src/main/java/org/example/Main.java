package org.example;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(3, 500);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 5; i++) {
            m = new Moneda1000();
            try {
                c = new Comprador(m, Expendedor.FANTA, exp);
                System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
            } catch (NoHayProductoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (PagoIncorrectoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}



