package edu.poniperro;

import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private String simboloAnterior() {
        return SimbolosRomanos.values()[this.ordinal() - 1 < 0 ? SimbolosRomanos.values().length - 1
                : this.ordinal() - 1]
                .name();
    }

    public boolean validacion(String numeroRomano) {
        String regex = String.format("(?<!%s)%s{1,3}", simboloAnterior(), this.name());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numeroRomano);
        return matcher.find();
    }

}
