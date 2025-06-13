package controllers;

import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;
import br.unisenai.classes.Pessoa_fisica;
import br.unisenai.enums.eSexo;
import utilitarios.Utils;

public class Pessoa_fisica_controllerTest {
    @Test
    public void testDesativar() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        
        testInsert();
 
        Pessoa_fisica pf = null;
        for (Pessoa_fisica p : controller.find_all(null, null)) {
            if ("658.205.550-07".equals(p.getPf_cpf()) && p.getPessoa_status() == true) {
                pf = p;
                break;
            }
        }
        assertNotNull(pf);

        controller.desativar(pf.getPessoa_id());
        Pessoa_fisica desativada = controller.find_pessoa_fisica(pf.getPessoa_id());
        assertNotNull(desativada);
        assertFalse(desativada.getPessoa_status());

    }

    @Test
    public void testFind_all() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        List<Pessoa_fisica> pfs = controller.find_all(null, null);
        assertNotNull(pfs);
        assertTrue(pfs.size() > 0);

        for (Pessoa_fisica pf : pfs) {
            assertNotEquals(0, pf.getPessoa_id());
            assertNotNull(pf.getPf_cpf());
            assertNotNull(pf.getPf_nome_registro());
            assertNotNull(pf.getPf_nome_social());
            assertNotNull(pf.getPessoa_end());
            assertNotNull(pf.getPessoa_status());
        }
    }

    @Test
    public void testFind_pessoa_fisica() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        
        Pessoa_fisica pf = null;
        for (Pessoa_fisica p : controller.find_all(null, null)) {
            if ("658.205.550-07".equals(p.getPf_cpf())) {
                pf = p;
                break;
            }
        }
        assertNotNull(pf);
        assertEquals("658.205.550-07", pf.getPf_cpf());
        assertNotEquals(0, pf.getPessoa_id());
        assertNotNull(pf.getPessoa_end());

    }

    @Test
    public void testFind_pessoa_fisica_cpf() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        Pessoa_fisica pf = controller.find_pessoa_fisica("658.205.550-07");
        assertNotNull(pf);
        assertEquals("658.205.550-07", pf.getPf_cpf());
        assertNotEquals(0, pf.getPessoa_id());
        assertNotNull(pf.getPessoa_end());

    }

    @Test
    public void testInsert() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        Pessoa_fisica pf = new Pessoa_fisica();
        pf.setPessoa_end(new Endereco_controller().find_endereco(1));
        pf.setPessoa_num_end(123);
        pf.setPessoa_compl("Sala Teste Insert");
        pf.setPessoa_fone("(11) 1234-5678");
        pf.setPessoa_cliente_desde(Date.valueOf("2023-10-01"));
        pf.setPessoa_status(true);
        pf.setPessoa_id(pf.getPessoa_id());
        pf.setPf_cpf("658.205.550-07");
        pf.setPf_nome_registro("Jefferson da Silva");
        pf.setPf_nome_social("Jefferson Caminhões");
        pf.setPf_data_nasc(Date.valueOf("1990-01-01"));
        pf.setPf_sexo(eSexo.Masculino_cis);
        pf.setPf_renda_mes(1000.00);

        assertEquals(true, Utils.validar_cpf(pf.getPf_cpf()));
        controller.insert(pf);

        boolean found = false;
        for (Pessoa_fisica p : controller.find_all(null, null)) {
            if ("658.205.550-07".equals(p.getPf_cpf())) {
                found = true;
                break;
            }
        }
        assertTrue(found);

    }

    @Test
    public void testSave() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        Pessoa_fisica pf = new Pessoa_fisica();
        pf.setPessoa_end(new Endereco_controller().find_endereco(1));
        pf.setPessoa_num_end(456);
        pf.setPessoa_compl(null);
        pf.setPessoa_fone("(11) 9876-5432");
        pf.setPessoa_cliente_desde(Date.valueOf("2023-10-01"));
        pf.setPessoa_status(true);
        pf.setPessoa_id(pf.getPessoa_id());
        pf.setPf_cpf("884.699.070-69");
        pf.setPf_nome_registro("Marcelo Castro");
        pf.setPf_nome_social("Marcinho");
        pf.setPf_data_nasc(Date.valueOf("1990-01-01"));
        pf.setPf_sexo(eSexo.Masculino_cis);
        pf.setPf_renda_mes(1500.00);

        assertEquals(true, Utils.validar_cpf(pf.getPf_cpf()));
        controller.save(pf);

        assertNotNull(controller.find_pessoa_fisica(pf.getPessoa_id()));
        pf.setPf_nome_social("Marcia");
        pf.setPf_sexo(eSexo.Feminino_trans);
        controller.save(pf);
        assertEquals("Marcia", controller.find_pessoa_fisica(pf.getPessoa_id()).getPf_nome_social());
    }

    @Test
    public void testUpdate() {
        Pessoa_fisica_controller controller = new Pessoa_fisica_controller();
        
        testInsert();

        Pessoa_fisica pf = null;
        for (Pessoa_fisica p : controller.find_all(null, null)) {
            if ("658.205.550-07".equals(p.getPf_cpf())) {
                pf = p;
                break;
            }
        }
        assertNotNull(pf);
        
        pf.setPf_nome_social("Jefferson Atualizado");
        controller.update(pf);
        
        Pessoa_fisica atualizado = controller.find_pessoa_fisica(pf.getPessoa_id());
        assertNotNull(atualizado);
        assertEquals("Jefferson Atualizado", atualizado.getPf_nome_social());

    }
}
