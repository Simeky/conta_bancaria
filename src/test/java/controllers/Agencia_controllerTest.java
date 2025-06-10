package controllers;

import br.unisenai.classes.Agencia;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Agencia_controllerTest {
    @Test
    public void testDelete() {
        Agencia_controller controller = new Agencia_controller();
        // Insere uma agência para deletar
        Agencia agencia = new Agencia();
        agencia.setAgencia_banco(new Banco_controller().find_banco(1));
        agencia.setAgencia_end(new Endereco_controller().find_endereco(1));
        agencia.setAgencia_num_end(999);
        agencia.setAgencia_compl("Sala 99");
        agencia.setAgencia_fone("(11) 96666-6666");
        agencia.setAgencia_status(true);
        controller.insert(agencia);
        // Busca a agência inserida
        List<Agencia> agencias = controller.find_all(null, null);
        Agencia ag = null;
        for (Agencia age : agencias) {
            if (age.getAgencia_num_end() == 999 && "Sala 99".equals(ag.getAgencia_compl())) {
                ag = age;
                break;
            }
        }
        assertNotNull(ag);
        // Deleta
        controller.delete(ag.getAgencia_id());
        Agencia agDeletada = controller.find_agencia(ag.getAgencia_id());
        assertNull(agDeletada);
    }

    @Test
    public void testFind_agencia() {
        Agencia_controller controller = new Agencia_controller();
        // Supondo que exista uma agência com ID 1
        Agencia ag = controller.find_agencia(1);
        assertNotNull(ag);
        assertEquals(1, ag.getAgencia_id());
        assertNotNull(ag.getAgencia_banco());
        assertNotNull(ag.getAgencia_end());
    }

    @Test
    public void testFind_all() {
        Agencia_controller controller = new Agencia_controller();
        // Busca todas as agências sem filtro
        List<Agencia> agencias = controller.find_all(null, null);

        assertNotNull(agencias);
        for (Agencia ag : agencias) {
            
            // Verifica se os campos estão preenchidos
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
        agencia.setAgencia_end(new Endereco_controller().find_endereco(1));
        agencia.setAgencia_num_end(123);
        agencia.setAgencia_compl("Sala 1");
        agencia.setAgencia_fone("(11) 99999-9999");
        agencia.setAgencia_status(true);

        controller.insert(agencia);

        List<Agencia> agencias = controller.find_all(null, null);
        boolean found = false;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_num_end() == 123 &&
                "Sala 1".equals(ag.getAgencia_compl()) &&
                "(11) 99999-9999".equals(ag.getAgencia_fone())) {
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

        // Testa inserção
        controller.save(agencia);
        List<Agencia> agencias = controller.find_all(null, null);
        boolean found = false;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_num_end() == 456 &&
                "Sala 2".equals(ag.getAgencia_compl()) &&
                "(11) 98888-8888".equals(ag.getAgencia_fone())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testUpdate() {
        Agencia_controller controller = new Agencia_controller();
        // Insere uma agência para atualizar
        Agencia agencia = new Agencia();
        agencia.setAgencia_banco(new Banco_controller().find_banco(1));
        agencia.setAgencia_end(new Endereco_controller().find_endereco(1));
        agencia.setAgencia_num_end(789);
        agencia.setAgencia_compl("Sala 3");
        agencia.setAgencia_fone("(11) 97777-7777");
        agencia.setAgencia_status(true);
        controller.insert(agencia);
        // Busca a agência inserida
        List<Agencia> agencias = controller.find_all(null, null);
        Agencia agToUpdate = null;
        for (Agencia ag : agencias) {
            if (ag.getAgencia_num_end() == 789 && "Sala 3".equals(ag.getAgencia_compl())) {
                agToUpdate = ag;
                break;
            }
        }
        assertNotNull(agToUpdate);
        // Atualiza
        agToUpdate.setAgencia_fone("(11) 90000-0000");
        controller.update(agToUpdate);
        // Busca novamente e verifica
        Agencia agAtualizada = controller.find_agencia(agToUpdate.getAgencia_id());
        assertEquals("(11) 90000-0000", agAtualizada.getAgencia_fone());
    }
}
