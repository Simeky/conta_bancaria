package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

import br.unisenai.classes.Endereco;

public class Endereco_controllerTest {
    @Test
    public void testDelete() {
        Endereco_controller controller = new Endereco_controller();
        
        testInsert();     

        List<Endereco> enderecos = controller.find_all(null, null);
        Endereco end = null;
        for (Endereco e : enderecos) {
            if ("1234567-8".equals(e.getEnd_cep())){
                end = e;
                break;
            }
        }
        assertNotNull(end);

        controller.delete(end.getEnd_id());
        Endereco endDeletado = controller.find_endereco(end.getEnd_id());
        assertNull(endDeletado);
    }

    @Test
    public void testFind_all() {
        Endereco_controller controller = new Endereco_controller();
        List<Endereco> enderecos = controller.find_all(null, null);
        assertNotNull(enderecos);
        for (Endereco endereco : enderecos) {
            assertNotEquals(0, endereco.getEnd_id());
            assertNotNull(endereco.getEnd_cep());
            assertNotNull(endereco.getEnd_logradouro());
            assertNotNull(endereco.getEnd_bairro());
            assertNotNull(endereco.getEnd_municipio());
            assertNotNull(endereco.getEnd_uf());
        }
        
    }

    @Test
    public void testFind_endereco() {
        Endereco_controller controller = new Endereco_controller();
        Endereco endereco = controller.find_endereco(1);
        assertNotNull(endereco);
        assertEquals(1, endereco.getEnd_id());
        assertNotNull(endereco.getEnd_cep());
        assertNotNull(endereco.getEnd_logradouro());
        assertNotNull(endereco.getEnd_bairro());
        assertNotNull(endereco.getEnd_municipio());
        assertNotNull(endereco.getEnd_uf());
    }

    @Test
    public void testInsert() {
        Endereco_controller controller = new Endereco_controller();
        Endereco endereco = new Endereco();
        endereco.setEnd_cep("1234567-8");
        endereco.setEnd_logradouro("Rua Teste Insert");
        endereco.setEnd_bairro("Bairro Teste");
        endereco.setEnd_municipio("Cidade Teste");
        endereco.setEnd_uf("UF");
        controller.insert(endereco);

        List<Endereco> enderecos = controller.find_all(null, null);   
        boolean found = false;
        for (Endereco e : enderecos) {
            if ("1234567-8".equals(e.getEnd_cep())){
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSave() {
        Endereco_controller controller = new Endereco_controller();
        Endereco endereco = new Endereco();
        endereco.setEnd_cep("55555555");
        endereco.setEnd_logradouro("Rua Teste Save");
        endereco.setEnd_bairro("Bairro Save");
        endereco.setEnd_municipio("Cidade Save");
        endereco.setEnd_uf("UF");
        controller.save(endereco);

        List<Endereco> enderecos = controller.find_all(null, null);
        Endereco end = null;
        for (Endereco e : enderecos) {
            if ("55555555".equals(e.getEnd_cep())) {
                end = e;
                break;
            }
        }
        assertNotNull(end);

        end.setEnd_logradouro("Rua Save Atualizada");
        controller.save(end);
        Endereco atualizado = controller.find_endereco(end.getEnd_id());
        assertEquals("Rua Save Atualizada", atualizado.getEnd_logradouro());
    }

    @Test
    public void testUpdate() {
        Endereco_controller controller = new Endereco_controller();
        
        testInsert();

        List<Endereco> enderecos = controller.find_all(null, null);
        Endereco end = null;
        for (Endereco e : enderecos) {
            if (e.getEnd_cep().equals("1234567-8")) {
                end = e;
                break;
            }
        }
        assertNotNull(end);

        end.setEnd_logradouro("Rua Update Atualizada");
        controller.update(end);
        Endereco atualizado = controller.find_endereco(end.getEnd_id());
        assertEquals("Rua Update Atualizada", atualizado.getEnd_logradouro());
    }
}
