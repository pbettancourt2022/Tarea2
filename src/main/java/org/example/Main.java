package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(4, 1000);
        Moneda m = null;
        Comprador c = null;

        for (int i = 0; i < 4; i++) {
            m=new Moneda1500();
            c = new Comprador(m, Expendedor.SPRITE, exp);
            System.out.println(c.queBebiste() + " $" + c.cuantoVuelto());
        }


    }
}

abstract class Bebida {
    private int serie;

    public Bebida(int numSerie) {
        this.serie = numSerie;
    }

    public int getSerie() {
        return serie;
    }

    public abstract String beber();

    public abstract String getTipo();
}

class Sprite extends Bebida {
    public Sprite(int numSerie) {
        super(numSerie);
    }

    @Override
    public String beber() {
        return "sprite";
    }

    @Override
    public String getTipo() {
        return "Sprite";
    }
}

class CocaCola extends Bebida {
    public CocaCola(int numSerie) {
        super(numSerie);
    }

    @Override
    public String beber() {
        return "cocacola";
    }

    @Override
    public String getTipo() {
        return "CocaCola";
    }
}

class Deposito {
    private ArrayList<Bebida> almacen;

    public Deposito() {
        this.almacen = new ArrayList<Bebida>();
    }
    public void addBebida(Bebida bebida) {
        almacen.add(bebida);
    }

    public Bebida getBebida() {
        if (almacen.size() != 0) {
            return almacen.remove(0);
        } else if (almacen.size() == 0) {
            return null;
        }
        return null;
    }
}

abstract class Moneda {

    public Moneda() {

    }

    public Moneda getSerie() {
        return this;
    }

    public abstract int getValor();
}

class Moneda1500 extends Moneda {
    public Moneda1500() {
        super();
    }

    @Override
    public int getValor() {
        return 1500;
    }
}

class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
    }

    @Override
    public int getValor() {
        return 1000;
    }
}

class Moneda500 extends Moneda {
    public Moneda500() {
        super();
    }

    @Override
    public int getValor() {
        return 500;
    }
}

class Moneda100 extends Moneda {
    public Moneda100() {
        super();
    }

    @Override
    public int getValor() {
        return 100;
    }
}

class DepositoM {
    private ArrayList<Moneda> almacen;

    public DepositoM() {
        this.almacen = new ArrayList<Moneda>();
    }

    public void addMoneda(Moneda moneda) {
        almacen.add(moneda);
    }

    public Moneda getMoneda() {
        if (almacen.size() != 0) {
            Moneda aux = almacen.get(0);
            almacen.remove(0);
            return aux;
        } else  {
            return null;
        }
    }
}

class Expendedor {
    private final Deposito coca;
    private final Deposito sprite;
    private final DepositoM monVu;
    public static final int  COCA=1;
    public static final int  SPRITE=2;

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
            return bebida;
        } else if (m.getValor() > precio) {
            int valorMoneda = m.getValor();
            int valorVuelto = m.getValor() - precio;
            if (cual == COCA) {
                bebida = coca.getBebida();
                if (bebida == null) {
                    while (valorMoneda != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorMoneda = valorMoneda - 100;
                    }
                    return bebida;
                }else {
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
                }else {
                    while (valorVuelto != 0) {
                        monVu.addMoneda(new Moneda100());
                        valorVuelto = valorVuelto - 100;
                    }
                    return bebida;

                }
            }else {
                while (valorMoneda != 0) {
                    monVu.addMoneda(new Moneda100());
                    valorMoneda = valorMoneda - 100;
                }
                return null;
            }
        }else if (m.getValor() < precio){
            int valorMoneda = m.getValor();
            while (valorMoneda != 0) {
                monVu.addMoneda(new Moneda100());
                valorMoneda = valorMoneda - 100;
            }
            return null;
        }else if (m.getValor() == precio){
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
            }else {
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

class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {
        vuelto = 0;

        if (m == null) {
            sonido = null;
        } else {
            Bebida bebida = exp.comprarBebida(m, cualBebida);

            if (bebida != null) {
                sonido = bebida.beber();
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

