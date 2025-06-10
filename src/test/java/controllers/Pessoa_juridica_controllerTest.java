package controllers;

import br.unisenai.classes.Endereco;
import br.unisenai.classes.Pessoa_juridica;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class Pessoa_juridica_controllerTest {
    @Test
    public void testDesativar() {

    }

    @Test
    public void testFind_all() {

    }

    @Test
    public void testFind_pessoa_juridica() {

    }

    @Test
    public void testFind_pessoa_juridica2() {

    }

    @Test
    public void testInsert() {
        Pessoa_juridica_controller controller = new Pessoa_juridica_controller();
        Pessoa_juridica pj = new Pessoa_juridica();
        pj.setPessoa_end(new Endereco_controller().find_endereco(2));
        pj.setPessoa_num_end(123);
        pj.setPessoa_compl("Sala Teste Insert");
        pj.setPessoa_fone("1234567890");
        pj.setPessoa_cliente_desde(new Date(System.currentTimeMillis()));
        pj.setPessoa_status(true);
        pj.setPessoa_id(pj.getPessoa_id());
        pj.setPj_cnpj("12345678000195");
        pj.setPj_razao_social("Razão Social Teste Insert");
        pj.setNome_fantasia("Nome Fantasia Teste Insert");
        pj.setPj_data_abertura(new Date(System.currentTimeMillis()));
        pj.setPj_capital_social(100000.00);
        controller.insert(pj);

        List<Pessoa_juridica> pjs = controller.find_all(null, null);
        boolean found = false;
        for (Pessoa_juridica p : pjs) {
            if ("12345678000195".equals(p.getPj_cnpj())) {
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
