package edu.poniperro;

public enum SimbolosRomanos {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500),
    CM(900),
    M(1000);

    private final Integer valor;

    private SimbolosRomanos(Integer valor) {
        this.valor = valor;
    };

    public Integer getValor() {
        return this.valor;
    }

    public static Integer valorNumerico(String simbolo) {
        return Enum.valueOf(SimbolosRomanos.class, simbolo).getValor();
    }
}
