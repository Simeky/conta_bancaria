package controllers;

import br.unisenai.classes.Endereco;
import br.unisenai.classes.Pessoa_juridica;
import utilitarios.Utils;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class Pessoa_juridica_controllerTest {
    @Test
    public void testDesativar() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        
        testInsert();

        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        Pessoa_juridica pj = null;
        for (Pessoa_juridica p : pjs) {
            if ("25.701.044/0001-70".equals(p.getPj_cnpj()) && p.getPessoa_status() == true) {
                pj = p;
                break;
            }
        }
        assertNotNull(pj);

        controller.desativar(pj.getPessoa_id());
        Pessoa_juridica desativada = controller.find_pessoa_juridica(pj.getPessoa_id());
        assertNotNull(desativada);
        assertFalse(desativada.getPessoa_status());
    }

    @Test
    public void testFind_all() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        assertNotNull(pjs);
        assertTrue(pjs.size() > 0);
        for (Pessoa_juridica pj : pjs) {
            assertNotNull(pj.getPj_cnpj());
            assertNotNull(pj.getPj_razao_social());
            assertNotNull(pj.getNome_fantasia());
            assertNotNull(pj.getPessoa_end());
        }
    }

    @Test
    public void testFind_pessoa_juridica() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        // Garante que existe pelo menos uma pessoa jurídica
        testInsert();
        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        Pessoa_juridica pj = null;
        for (Pessoa_juridica p : pjs) {
            if ("25.701.044/0001-70".equals(p.getPj_cnpj())) {
                pj = p;
                break;
            }
        }
        assertNotNull(pj);
        Pessoa_juridica found = controller.find_pessoa_juridica(pj.getPessoa_id());
        assertNotNull(found);
        assertEquals(pj.getPj_cnpj(), found.getPj_cnpj());
        assertEquals(pj.getPj_razao_social(), found.getPj_razao_social());
        assertEquals(pj.getNome_fantasia(), found.getNome_fantasia());
    }

    @Test
    public void testFind_pessoa_juridica_cnpj() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        Pessoa_juridica pj = controller.find_pessoa_juridica("25.701.044/0001-70");
        assertNotNull(pj);
        assertEquals("25.701.044/0001-70", pj.getPj_cnpj());
        assertEquals("Razão Social Teste Insert", pj.getPj_razao_social());
        assertEquals("Nome Fantasia Teste Insert", pj.getNome_fantasia());
    }

    @Test
    public void testInsert() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        Pessoa_juridica pj = new Pessoa_juridica();
        pj.setPessoa_end(new Endereco_controller().find_endereco(1));
        pj.setPessoa_num_end(123);
        pj.setPessoa_compl("Sala Teste Insert");
        pj.setPessoa_fone("1234567890");
        pj.setPessoa_cliente_desde(new Date(System.currentTimeMillis()));
        pj.setPessoa_status(true);
        pj.setPessoa_id(pj.getPessoa_id());
        pj.setPj_cnpj("25.701.044/0001-70");
        pj.setPj_razao_social("Razão Social Teste Insert");
        pj.setNome_fantasia("Nome Fantasia Teste Insert");
        pj.setPj_data_abertura(new Date(System.currentTimeMillis()));
        pj.setPj_capital_social(100000.00);

        assertEquals(true, Utils.validar_cnpj(pj.getPj_cnpj()));
        controller.insert(pj);


        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        boolean found = false;
        for (Pessoa_juridica p : pjs) {
            if ("25.701.044/0001-70".equals(p.getPj_cnpj())) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSave() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        Endereco end = new Endereco_controller().find_endereco(2);
        Pessoa_juridica pj = new Pessoa_juridica();
        pj.setPessoa_end(end);
        pj.setPessoa_num_end(321);
        pj.setPessoa_compl("Sala Save");
        pj.setPessoa_fone("9876543210");
        pj.setPessoa_cliente_desde(new Date(System.currentTimeMillis()));
        pj.setPessoa_status(true);
        pj.setPj_cnpj("81.016.882/0001-85");
        pj.setPj_razao_social("Razão Social Save");
        pj.setNome_fantasia("Nome Fantasia Save");
        pj.setPj_data_abertura(new Date(System.currentTimeMillis()));
        pj.setPj_capital_social(200000.00);

        assertEquals(true, Utils.validar_cnpj(pj.getPj_cnpj()));
        controller.save(pj);

        // Busca e atualiza
        Pessoa_juridica found = controller.find_pessoa_juridica("81.016.882/0001-85");
        assertNotNull(found);
        found.setNome_fantasia("Nome Fantasia Save Atualizada");

        assertEquals(true, Utils.validar_cnpj(pj.getPj_cnpj()));
        controller.save(found);
        Pessoa_juridica atualizado = controller.find_pessoa_juridica("81.016.882/0001-85");
        assertEquals("Nome Fantasia Save Atualizada", atualizado.getNome_fantasia());
    }

    @Test
    public void testUpdate() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();

        testInsert();

        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        Pessoa_juridica pj = null;
        for (Pessoa_juridica p : pjs) {
            if ("25.701.044/0001-70".equals(p.getPj_cnpj())) {
                pj = p;
                break;
            }
        }
        assertNotNull(pj);

        pj.setPj_cnpj("99.134.213/0001-73");

        assertEquals(true, Utils.validar_cnpj(pj.getPj_cnpj()));
        controller.update(pj);
        Pessoa_juridica atualizado = controller.find_pessoa_juridica(pj.getPessoa_id());
        assertEquals("99.134.213/0001-73", atualizado.getPj_cnpj());
    }
}
