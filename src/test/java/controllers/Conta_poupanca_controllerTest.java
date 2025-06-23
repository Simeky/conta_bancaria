package controllers;

import org.junit.Test;
import static org.junit.Assert.*;

import br.unisenai.classes.Conta_poupanca;
import br.unisenai.enums.eStatus;
import java.sql.Date;

public class Conta_poupanca_controllerTest {
    @Test
    public void testCancela_id() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();

        testInsert();

        Conta_poupanca cp = null;
        for (Conta_poupanca c : controller.find_all(null, null)) {
            if ("1234567890123456".equals(c.getCb_num_card()) && c.getCb_status() != eStatus.Cancelada) {
                cp = c;
                break;
            }
        }
        assertNotNull(cp);

        controller.cancela(cp.getCb_id());
        Conta_poupanca cancelada = controller.find_conta_poupanca(cp.getCb_id());
        assertNotNull(cancelada);
        assertEquals(eStatus.Cancelada, cancelada.getCb_status());  
    }

    @Test
    public void testCancela_cb() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();

        testInsert();

        Conta_poupanca cp = null;
        for (Conta_poupanca c : controller.find_all(null, null)) {
            if ("1234567890123456".equals(c.getCb_num_card()) && c.getCb_status() == eStatus.Ativa) {
                cp = c;
                break;
            }
        }
        assertNotNull(cp);

        controller.cancela(cp);
        Conta_poupanca cancelada = controller.find_conta_poupanca(cp.getCb_id());
        assertNotNull(cancelada);
        assertEquals(eStatus.Cancelada, cancelada.getCb_status());
    }

    @Test
    public void testDesativa_id() {

    }

    @Test
    public void testDesativa_cb() {

    }

    @Test
    public void testFind_all() {

    }

    @Test
    public void testFind_conta_poupanca() {

    }

    @Test
    public void testInsert() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();
        Conta_poupanca cp = new Conta_poupanca();
        cp.setCb_agencia(new Agencia_controller().find_agencia(1));
        cp.setCb_titular1(new Pessoa_fisica_controller().find_pessoa_fisica(1));
        cp.setCb_titular2(new Pessoa_fisica_controller().find_pessoa_fisica(2));
        cp.setCb_abertura(Date.valueOf("2023-10-01"));
        cp.setCb_saldo(1000.00);
        cp.setCb_pswrd("1234");
        cp.setCb_bandeira_card("Visa");
        cp.setCb_num_card("1234567890123456");
        cp.setCb_val_card(Date.valueOf("2025-10-01"));
        cp.setCb_cvv_card((short) 123);
        cp.setCb_status(eStatus.Ativa);
        cp.setCb_id(cp.getCb_id());
        cp.setCp_reajuste(0.05);
        controller.insert(cp);

        boolean found = false;
        for (Conta_poupanca c : controller.find_all(null, null)) {
            if ("1234567890123456".equals(c.getCb_num_card())) {
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
