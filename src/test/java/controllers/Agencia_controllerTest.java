package controllers;

import br.unisenai.classes.Agencia;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Agencia_controllerTest {

    //Garanta que o Banco e Endereco já existem no banco de dados antes de executar os testes

    @Test
    public void testDelete() {
        Agencia_controller controller = new Agencia_controller();

        testInsert();

        List<Agencia> agencias = controller.find_all(null, null);
        Agencia ag = null;
        for (Agencia age : agencias) {
            if (age.getAgencia_compl().equals("Sala Teste Insert")){
                ag = age;
                break;
            }
        }
        assertNotNull(ag);
        
        controller.delete(ag.getAgencia_id());
        Agencia agDeletada = controller.find_agencia(ag.getAgencia_id());
        assertNull(agDeletada);
    }

    @Test
    public void testFind_agencia() {
        Agencia_controller controller = new Agencia_controller();
        Agencia ag = controller.find_agencia(1);
        assertNotNull(ag);
        assertEquals(1, ag.getAgencia_id());
        assertNotNull(ag.getAgencia_banco());
        assertNotNull(ag.getAgencia_end());
    }

    @Test
    public void testFind_all() {
        Agencia_controller controller = new Agencia_controller();
        List<Agencia> agencias = controller.find_all(null, null);

        assertNotNull(agencias);
        for (Agencia ag : agencias) {
            assertNotEquals(0, ag.getAgencia_id());
            assertNotNull(ag.getAgencia_banco().getBanco_id());
            assertNotNull(ag.getAgencia_end().getEnd_id());
            assertNotEquals(0, ag.getAgencia_num_end());
            assertNotNull(ag.getAgencia_compl());
            assertNotNull(ag.getAgencia_fone());
            assertNotNull(ag.getAgencia_status());        
        }
    }

    @Test
    public void testInsert() {
        Agencia_controller controller = new Agencia_controller();
        Agencia agencia = new Agencia();
        agencia.setAgencia_banco(new Banco_controller().find_banco(1));
        agencia.setAgencia_end(new Endereco_controller().find_endereco(2));
        agencia.setAgencia_num_end(123);
        agencia.setAgencia_compl("Sala Teste Insert");
        agencia.setAgencia_fone("(11) 99999-9999");
        agencia.setAgencia_status(true);

        controller.insert(agencia);

        List<Agencia> agencias = controller.find_all(null, null);
        boolean found = false;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_compl().equals("Sala Teste Insert")) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSave() {
        Agencia_controller controller = new Agencia_controller();
        Agencia agencia = new Agencia();
        agencia.setAgencia_banco(new Banco_controller().find_banco(1));
        agencia.setAgencia_end(new Endereco_controller().find_endereco(1));
        agencia.setAgencia_num_end(456);
        agencia.setAgencia_compl("Sala 2");
        agencia.setAgencia_fone("(11) 98888-8888");
        agencia.setAgencia_status(true);
        controller.save(agencia);

        List<Agencia> agencias = controller.find_all(null, null);
        Agencia age = null;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_num_end() == 456 &&
                "Sala 2".equals(ag.getAgencia_compl()) &&
                "(11) 98888-8888".equals(ag.getAgencia_fone())) {
                age = ag;
                break;
            }
        }
        assertNotNull(age);

        age.setAgencia_fone("(11) texto-5555");
        controller.save(age);
        Agencia agAtualizada = controller.find_agencia(age.getAgencia_id());
        assertEquals("(11) texto-5555", agAtualizada.getAgencia_fone());
        
    }

    @Test
    public void testUpdate() {
        Agencia_controller controller = new Agencia_controller();

        testInsert();

        List<Agencia> agencias = controller.find_all(null, null);
        Agencia age = null;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_compl().equals("Sala Teste Insert")) {
                age = ag;
                break;
            }
        }
        assertNotNull(age);
        age.setAgencia_compl("Sala Teste Atualizada");
        controller.update(age);
        Agencia agAtualizada = controller.find_agencia(age.getAgencia_id());
        assertEquals("Sala Teste Atualizada", agAtualizada.getAgencia_compl());
    }
}
