
package edu.poniperro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.Test;

public class NumeroRomanoTest {

    /**
     * Grupos sumatorios M, C, X, I
     */

    @ParameterizedTest
    @CsvSource({
            "1000,  M",
            "2000,  UMMU",
            "3000,  UMMMU"
    })
    public void grupo_M_test(int decimal, String roman) {

        // String testCase = "M";
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());

        /**
         * El caso MMMM es control de errores
         * y no puede estas en el test de la logica
         * Asumimos que la entrada es correcta.
         * Sino, hay que programar la gestion de errores
         */
    }

    @ParameterizedTest
    @CsvSource({
            "3300, UMMMUCCCU",
            "3030, UMMMUXXXU",
            "3003,UMMMUIIIU"
    })
    public void tres_repeticiones_C_X_I_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @Test
    public void una_D_test() {

        String testCase = "UMMMUDUIIIU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(3503, numeroRomano.toDecimal());

        testCase = "MMMUCDUIIIU";
        numeroRomano = new NumeroRomano(testCase);
        assertNotEquals(3503, numeroRomano.toDecimal());
    }

    /**
     * Grupos substractivos
     * IV(4), IX(9),
     * XL(40), XC(90),
     * CD(400), CM(900)
     */

    @ParameterizedTest
    @CsvSource({
            "400, UCDU",
            "900, UCMU"
    })
    public void grupo_C_DM_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());

    }

    @ParameterizedTest
    @CsvSource({
            "40, UXLU",
            "90, UXCU"
    })
    public void grupo_X_LC_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "4, UIVU",
            "9, UIXU"
    })
    public void grupo_I_VX_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());

    }

    @ParameterizedTest
    @CsvSource({
            "3888, MMMDCCCLXXXVIII"
    })
    public void grupos_sumatorios_tres_digitos_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "2777, MMDCCLXXVII"
    })
    public void grupos_sumatorios_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

    @ParameterizedTest
    @CsvSource({
            "444, CDXLIV",
            "439, CDXXXIX"
    })
    public void grupos_substractivos_test(int decimal, String roman) {
        NumeroRomano numeroRomano = new NumeroRomano(roman);
        assertEquals(decimal, numeroRomano.toDecimal());
    }

}