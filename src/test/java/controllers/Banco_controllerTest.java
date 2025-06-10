package controllers;

import static org.junit.Assert.*;
import java.util.List;
import br.unisenai.classes.Banco;
import org.junit.Test;

public class Banco_controllerTest {
    @Test
    public void testDelete() {
        Banco_controller controller = new Banco_controller();
        Banco banco = new Banco();
        banco.setBanco_cod_inst("88888");
        banco.setBanco_nome("Banco Teste Delete");
        banco.setBanco_mascara_cb("3333-3");
        controller.insert(banco);

        List<Banco> bancos = controller.find_all(null, null);
        Banco ban = null;
        for (Banco b : bancos) {
            if ("Banco Teste Delete".equals(b.getBanco_nome())) {
                ban = b;
                break;
            }
        }
        assertNotNull(ban);
        
        controller.delete(ban.getBanco_id());
        Banco bDeletado = controller.find_banco(ban.getBanco_id());
        assertNull(bDeletado);
    }

    @Test
    public void testFind_all() {
        Banco_controller controller = new Banco_controller();
        List<Banco> bancos = controller.find_all(null, null);
        assertNotNull(bancos);
        for (Banco banco : bancos) {
            assertNotEquals(0, banco.getBanco_id());
            assertNotNull(banco.getBanco_cod_inst());
            assertNotNull(banco.getBanco_nome());
            assertNotNull(banco.getBanco_mascara_cb());
        }
    }

    @Test
    public void testFind_banco() {
        Banco_controller controller = new Banco_controller();
        Banco banco = controller.find_banco(1);
        assertNotNull(banco);
        assertEquals(1, banco.getBanco_id());
        assertNotNull(banco.getBanco_cod_inst());
        assertNotNull(banco.getBanco_nome());
        assertNotNull(banco.getBanco_mascara_cb());
    }

    @Test
    public void testFind_banco_nome() {
        Banco_controller controller = new Banco_controller();
        Banco banco = controller.find_banco("Banco Teste Insert");
        assertNotNull(banco);
        assertEquals("Banco Teste Insert", banco.getBanco_nome());
        assertNotNull(banco.getBanco_cod_inst());
        assertNotNull(banco.getBanco_mascara_cb());
    }

    @Test
    public void testInsert() {
        Banco_controller controller = new Banco_controller();
        Banco banco = new Banco();
        banco.setBanco_cod_inst("12345");
        banco.setBanco_nome("Banco Teste Insert");
        banco.setBanco_mascara_cb("0000-0");
        controller.insert(banco);
        List<Banco> bancos = controller.find_all(null, null);
        boolean found = false;
        for (Banco b : bancos) {
            if ("Banco Teste Insert".equals(b.getBanco_nome()) && "12345".equals(b.getBanco_cod_inst())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSave() {
        Banco_controller controller = new Banco_controller();
        Banco banco = new Banco();
        banco.setBanco_cod_inst("77777");
        banco.setBanco_nome("Banco Teste Save");
        banco.setBanco_mascara_cb("7777-7");
        controller.save(banco);

        List<Banco> bancos = controller.find_all(null, null);
        Banco ban = null;
        for (Banco b : bancos) {
            if ("Banco Teste Save".equals(b.getBanco_nome())) {
                ban = b;
                break;
            }
        }
        assertNotNull(ban);

        ban.setBanco_nome("Banco Save Atualizado");
        controller.save(ban);

        Banco bAtualizado = controller.find_banco(ban.getBanco_id());
        assertEquals("Banco Save Atualizado", bAtualizado.getBanco_nome());
    }

    @Test
    public void testUpdate() {
        Banco_controller controller = new Banco_controller();
        Banco banco = new Banco();
        banco.setBanco_cod_inst("99999");
        banco.setBanco_nome("Banco Teste Update");
        banco.setBanco_mascara_cb("2222-2");
        controller.insert(banco);

        List<Banco> bancos = controller.find_all(null, null);
        Banco ban = null;
        for (Banco b : bancos) {
            if ("Banco Teste Update".equals(b.getBanco_nome())) {
                ban = b;
                break;
            }
        }
        assertNotNull(ban);

        ban.setBanco_nome("Banco Atualizado");
        controller.update(ban);
        Banco bAtualizado = controller.find_banco(ban.getBanco_id());
        assertEquals("Banco Atualizado", bAtualizado.getBanco_nome());
    }
}
