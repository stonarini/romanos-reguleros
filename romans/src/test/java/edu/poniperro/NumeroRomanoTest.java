
package edu.poniperro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import edu.poniperro.NumeroRomano;
import org.junit.BeforeClass;
import org.junit.Test;

public class NumeroRomanoTest {

    /**
     * Grupos sumatorios M, C, X, I
     */

    @Test
    public void grupo_M_test() {

        String testCase = "M";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(1000, numeroRomano.toDecimal(), 0);

        testCase = "UMMU";
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(2000, numeroRomano.toDecimal(), 0);

        testCase = "UMMMU";
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(3000, numeroRomano.toDecimal(), 0);

        testCase = "UCMU";
        numeroRomano = new NumeroRomano(testCase);
        assertNotEquals(1000, numeroRomano.toDecimal(), 0);

        /**
         * El caso MMMM es control de errores
         * y no puede estas en el test de la logica
         * Asumimos que la entrada es correcta.
         * Sino, hay que programar la gestion de errores
         */
    }

    @Test
    public void tres_repeticiones_C_test() {

        String testCase = "UMMMUCCCU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(3300, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void tres_repeticiones_X_test() {

        String testCase = "UMMMUXXXU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);

        assertEquals(3030, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void tres_repeticiones_I_test() {

        String testCase = "UMMMUIIIU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);

        assertEquals(3003, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void una_D_test() {

        String testCase = "UMMMUDUIIIU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(3503, numeroRomano.toDecimal(), 0);

        testCase = "MMMUCDUIIIU";
        numeroRomano = new NumeroRomano(testCase);
        assertNotEquals(3503, numeroRomano.toDecimal(), 0);
    }

    /**
     * Grupos substractivos
     * IV(4), IX(9),
     * XL(40), XC(90),
     * CD(400), CM(900)
     */

    @Test
    public void grupo_C_DM_test() {

        String testCase = "UCDU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(400, numeroRomano.toDecimal(), 0);

        testCase = "UCMU";
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(900, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void grupo_X_LC_test() {

        String testCase = "UXLU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(40, numeroRomano.toDecimal(), 0);

        testCase = "UXCU";
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(90, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void grupo_I_VX_test() {

        String testCase = "UIVU";
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(4, numeroRomano.toDecimal(), 0);

        testCase = "UIXU";
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(9, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void grupos_sumatorios_tres_digitos_test() {
        String testCase = "MMMDCCCLXXXVIII"; // 3888
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(3888, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void grupos_sumatorios_test() {
        String testCase = "MMDCCLXXVII"; // 2777
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(2777, numeroRomano.toDecimal(), 0);
    }

    @Test
    public void grupos_substractivos_test() {
        String testCase = "CDXLIV"; // 444
        NumeroRomano numeroRomano = new NumeroRomano(testCase);
        assertEquals(444, numeroRomano.toDecimal(), 0);

        testCase = "CDXXXIX"; // 439
        numeroRomano = new NumeroRomano(testCase);
        assertEquals(439, numeroRomano.toDecimal(), 0);
    }

    // @Test
    // public void initArrayRegex_test() {
    // String test = "V";
    // numeroRomano.setNumeroRomano(test);
    // assertEquals(2, numeroRomano.getRegexDiccionario().longitud());
    // assertEquals(5, numeroRomano.valorDecimal(test));
    // assertEquals("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])",
    // numeroRomano.getRegexDiccionario().getRegexValue("grupoSumatorio"));
    // assertEquals("(C[DM])|(X[LC])|(I[VX])",
    // numeroRomano.getRegexDiccionario().getRegexValue("grupoSustractivo"));
    // }

    // @Test
    // public void toDecimal() {
    // String test = "V";
    // numeroRomano.setNumeroRomano(test);
    // assertEquals(2, numeroRomano.getExpresionesRegulares().size());
    // assertTrue(numeroRomano.getRegexDiccionario().getValues()
    // .contains("(?<!C)[DM]|(?<!X)[LC](?![DM])|(?<!I)[VX](?![LC])|I(?![VX])"));
    // assertTrue(numeroRomano.getRegexDiccionario().getValues().contains("(C[DM])|(X[LC])|(I[VX])"));
    // }

    // @Test
    // public void valorDecimal_test() {
    // String test = "V";
    // numeroRomano.setNumeroRomano(test);
    // assertEquals(2, numeroRomano.getRegexDiccionario().getRegex().size());
    // assertEquals(5, numeroRomano.valorDecimal(test));

    // test = "IV";
    // numeroRomano.setNumeroRomano(test);
    // assertEquals(4, numeroRomano.valorDecimal(test));

    // test = "CM";
    // numeroRomano.setNumeroRomano(test);
    // assertEquals(900, numeroRomano.valorDecimal(test));

    /**
     * test = "U";
     * numeroRomano.setNumeroRomano("U");
     * assertEquals(900, numeroRomano.valorDecimal(test));
     */
    // }
}