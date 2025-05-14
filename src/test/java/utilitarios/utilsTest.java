package utilitarios;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for utils functions.
 */
public class UtilsTest {

    @Test
    public void test_so_numeros() {

        String cpf = "364.733.009-45";
        String cpf_erro = "1a2cadQRE3a.,65=4";

        assertEquals("36473300945", Utils.so_numeros(cpf));
        assertNotEquals("12a3654", Utils.so_numeros(cpf_erro));

    }

    @Test
    public void test_validar_cpf() {

        String cpf = "364.733.009-45";
        String cpf_erro = "1a2cadQRE3a.,65=4";

        assertEquals(true, Utils.validar_cpf(cpf));
        assertNotEquals(true, Utils.validar_cpf(cpf_erro));

    }
}
