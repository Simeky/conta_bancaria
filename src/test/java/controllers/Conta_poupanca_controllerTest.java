package controllers;

import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.Assert.*;

import br.unisenai.classes.Conta_poupanca;
import br.unisenai.enums.eStatus;
import java.sql.Date;
import java.util.List;

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

        controller.desativa(cp.getCb_id());
        Conta_poupanca desativada = controller.find_conta_poupanca(cp.getCb_id());
        assertNotNull(desativada);
        assertEquals(eStatus.Inativa, desativada.getCb_status());
    }

    @Test
    public void testDesativa_cb() {
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

        controller.desativa(cp);
        Conta_poupanca desativada = controller.find_conta_poupanca(cp.getCb_id());
        assertNotNull(desativada);
        assertEquals(eStatus.Inativa, desativada.getCb_status());
    }

    @Test
    public void testFind_all() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();
        List<Conta_poupanca> contas = controller.find_all(null, null);
        assertNotNull(contas);
        assertTrue(contas.size() > 0);

        for (Conta_poupanca cp : contas) {
            assertNotEquals(0, cp.getCb_id());
            assertNotNull(cp.getCb_agencia());
            assertNotNull(cp.getCb_titular1());
        }
    }

    @Test
    public void testFind_conta_poupanca() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();
        Conta_poupanca cp = null;

        for (Conta_poupanca c : controller.find_all(null, null)) {
            if ("1234567890123456".equals(c.getCb_num_card())) {
                cp = c;
                break;
            }
        }
        assertNotNull(cp);
        assertNotEquals(0, cp.getCb_id());
        assertNotNull(cp.getCb_agencia());
        assertTrue(BCrypt.checkpw("1234", cp.getCb_pswrd()));
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
        Conta_poupanca_controller controller = new Conta_poupanca_controller();
        Conta_poupanca cp = new Conta_poupanca();
        cp.setCb_agencia(new Agencia_controller().find_agencia(1));
        cp.setCb_titular1(new Pessoa_fisica_controller().find_pessoa_fisica(1));
        cp.setCb_titular2(new Pessoa_fisica_controller().find_pessoa_fisica(2));
        cp.setCb_abertura(Date.valueOf("2023-10-01"));
        cp.setCb_saldo(1000.00);
        cp.setCb_pswrd("Save");
        cp.setCb_bandeira_card("Visa");
        cp.setCb_num_card("1234567890123456");
        cp.setCb_val_card(Date.valueOf("2025-10-01"));
        cp.setCb_cvv_card((short) 123);
        cp.setCb_status(eStatus.Ativa);
        cp.setCb_id(cp.getCb_id());
        cp.setCp_reajuste(0.05);
        controller.save(cp);

        assertNotNull(cp.getCb_id());
        cp.setCb_bandeira_card("MasterCard");
        cp.setCp_reajuste(0.07);
        controller.save(cp);
        assertEquals("MasterCard", cp.getCb_bandeira_card());
        assertEquals(0.07, cp.getCp_reajuste(), 0.001);
    }

    @Test
    public void testUpdate() {
        Conta_poupanca_controller controller = new Conta_poupanca_controller();
        Conta_poupanca cp = null;

        testInsert();

        for (Conta_poupanca c : controller.find_all(null, null)) {
            if ("1234567890123456".equals(c.getCb_num_card())) {
                cp = c;
                break;
            }
        }
        assertNotNull(cp);

        cp.setCb_bandeira_card("Elo");
        cp.setCp_reajuste(0.10);
        controller.update(cp);

        Conta_poupanca atualizado = controller.find_conta_poupanca(cp.getCb_id());
        assertNotNull(atualizado);
        assertEquals(0.10, atualizado.getCp_reajuste(), 0.001);
    }
}
