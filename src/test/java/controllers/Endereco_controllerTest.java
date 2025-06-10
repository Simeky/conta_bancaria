package controllers;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

import br.unisenai.classes.Endereco;

public class Endereco_controllerTest {
    @Test
    public void testDelete() {
        Endereco_controller controller = new Endereco_controller();
        Endereco endereco = new Endereco();
        endereco.setEnd_cep("87654321");
        endereco.setEnd_logradouro("Rua Teste Delete");
        endereco.setEnd_bairro("Bairro Delete");
        endereco.setEnd_municipio("Cidade Delete");
        endereco.setEnd_uf("DF");
        controller.insert(endereco);

        List<Endereco> enderecos = controller.find_all(null, null);
        Endereco end = null;
        for (Endereco e : enderecos) {
            if ("Rua Teste Delete".equals(e.getEnd_logradouro())) {
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

    }

    @Test
    public void testFind_endereco() {

    }

    @Test
    public void testInsert() {
        Endereco_controller controller = new Endereco_controller();
        Endereco endereco = new Endereco();
        endereco.setEnd_cep("12345678");
        endereco.setEnd_logradouro("Rua Teste Insert");
        endereco.setEnd_bairro("Bairro Teste");
        endereco.setEnd_municipio("Cidade Teste");
        endereco.setEnd_uf("UF");
        controller.insert(endereco);
   
        boolean found = false;
        for (Endereco e : controller.find_all(null, null)) {
            if ("12345678".equals(e.getEnd_cep())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSave() {

    }

    @Test
    public void testUpdate() {

    }
}
