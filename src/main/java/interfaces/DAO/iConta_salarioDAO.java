package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_salario;

public interface iConta_salarioDAO {

    Conta_salario find_conta_salario(long id);
    Conta_salario find_conta_salario(String t);
    List<Conta_salario> find_all(String condicao, String ordem);
    void insert(Conta_salario cs);
    void update(Conta_salario cs);
    void save(Conta_salario cs);
    void delete(long id);
    void delete(Conta_salario cs);

}
