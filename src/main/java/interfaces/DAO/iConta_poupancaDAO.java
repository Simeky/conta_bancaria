package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_poupanca;

public interface iConta_poupancaDAO {

    Conta_poupanca find_conta_poupanca(long id);
    Conta_poupanca find_conta_poupanca(String t);
    List<Conta_poupanca> find_all(String condicao, String ordem);
    void insert(Conta_poupanca cp);
    void update(Conta_poupanca cp);
    void save(Conta_poupanca cp);
    void delete(long id);
    void delete(Conta_poupanca cp);

}
