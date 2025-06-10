package controllers;

import static org.junit.Assert.*;
import java.util.List;
import br.unisenai.classes.Banco;
import org.junit.Test;

public class Banco_controllerTest {
    @Test
    public void testDelete() {
        Banco_controller controller = new Banco_controller();
        // Insere um banco para deletar
        Banco banco = new Banco();
        banco.setBanco_cod_inst("88888");
        banco.setBanco_nome("Banco Teste Delete");
        banco.setBanco_mascara_cb("3333-3");
        controller.insert(banco);

        List<Banco> bancos = controller.find_all(null, null);
        Banco bToDelete = null;
        for (Banco b : bancos) {
            if ("Banco Teste Delete".equals(b.getBanco_nome())) {
                bToDelete = b;
                break;
            }
        }
        assertNotNull(bToDelete);
        
        controller.delete(bToDelete.getBanco_id());
        Banco bDeletado = controller.find_banco(bToDelete.getBanco_id());
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
        // Supondo que exista um banco com ID 1
        Banco banco = controller.find_banco(1);
        assertNotNull(banco);
        assertEquals(1, banco.getBanco_id());
        assertNotNull(banco.getBanco_cod_inst());
        assertNotNull(banco.getBanco_nome());
        assertNotNull(banco.getBanco_mascara_cb());
    }

    @Test
    public void testFind_banco2() {
        Banco_controller controller = new Banco_controller();
        Banco banco = controller.find_banco("Banco Teste");
        assertNotNull(banco);
        assertEquals("Banco Teste", banco.getBanco_nome());
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
        banco.setBanco_cod_inst("54321");
        banco.setBanco_nome("Banco Teste Save");
        banco.setBanco_mascara_cb("1111-1");
        controller.save(banco);
        List<Banco> bancos = controller.find_all(null, null);
        boolean found = false;
        for (Banco b : bancos) {
            if ("Banco Teste Save".equals(b.getBanco_nome()) && "54321".equals(b.getBanco_cod_inst())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
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
        Banco bToUpdate = null;
        for (Banco b : bancos) {
            if ("Banco Teste Update".equals(b.getBanco_nome())) {
                bToUpdate = b;
                break;
            }
        }
        assertNotNull(bToUpdate);

        bToUpdate.setBanco_nome("Banco Atualizado");
        controller.update(bToUpdate);
        Banco bAtualizado = controller.find_banco(bToUpdate.getBanco_id());
        assertEquals("Banco Atualizado", bAtualizado.getBanco_nome());
    }
}
