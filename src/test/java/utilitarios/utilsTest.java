package utilitarios;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class utilsTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test()
    {

        String cpf = "364.733.009-45";

        assertEquals("36473300945", utils.so_numeros(cpf));
        assertEquals(true, utils.validar_cpf(cpf));

    }
}
