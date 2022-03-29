package edu.poniperro;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumeroRomano {

    private final String numeroRomano;
    private Optional<Integer> valorDecimal;
    private RegexNumeroRomanos regex;

    public NumeroRomano(String numeroRomano) {
        this.valorDecimal = Optional.empty();
        this.numeroRomano = numeroRomano;
        this.regex = new RegexNumeroRomanos();
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }

    private void setValorDecimal(Optional<Integer> valorDecimal) {
        this.valorDecimal = valorDecimal;
    }

    public Integer toDecimal() {
        if (valorDecimal.isEmpty()) {
            setValorDecimal(Optional.of(calcularValorDecimal()));
        }
        return valorDecimal.get();
    }

    private Integer calcularValorDecimal() {
        Integer valor = 0;
        Matcher matcher = crearMatcher();
        while (matcher.find()) {
            valor += decimalValor(matcher.group());
        }
        return valor;
    }

    private Integer decimalValor(String simbolo) {
        return SimbolosRomanos.valorNumerico(simbolo);
    }

    private Matcher crearMatcher() {
        Pattern pattern = Pattern.compile(regex.getRegex());
        return pattern.matcher(getNumeroRomano());
    }

}
