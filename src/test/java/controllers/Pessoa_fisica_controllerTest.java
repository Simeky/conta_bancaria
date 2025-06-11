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

    }

    @Test
    public void testFind_all() {

    }

    @Test
    public void testFind_pessoa_fisica() {

    }

    @Test
    public void testFind_pessoa_fisica2() {

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

        List<Pessoa_fisica> pfs = controller.find_all(null, null);
        boolean found = false;
        for (Pessoa_fisica p : pfs) {
            if ("658.205.550-07".equals(p.getPf_cpf())) {
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
