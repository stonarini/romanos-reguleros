package edu.poniperro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class NumeroRomano {

    private String numeroRomano;
    private HashMap regexDiccionario;

    public NumeroRomano() {
    }

    public String getNumeroRomano() {
        return this.numeroRomano;
    }

    public void setNumeroRomano(String numeroRomano) {
        this.numeroRomano = numeroRomano;
    }

    public int toDecimal() {
        Optional<Integer> suma = Arrays.stream(SimbolosRomanos.values())
                .filter(s -> s.validacion(getNumeroRomano()))
                .map(s -> s.getValor())
                .reduce(Integer::sum);
        return suma.isPresent() ? suma.get() : 0;
    }

    public void initRegexDicionario() {
        this.regexDiccionario = new HashMap<>();
    }

}
