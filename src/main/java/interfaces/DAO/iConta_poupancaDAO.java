package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_poupanca;

public interface iConta_poupancaDAO {

    Conta_poupanca find_conta_poupanca(long id);
    List<Conta_poupanca> find_all(String condicao, String ordem);
    void insert(Conta_poupanca cp);
    void update(Conta_poupanca cp);
    void save(Conta_poupanca cp);
    void desativa(long id);
    void desativa(Conta_poupanca cp);
    void cancela(long id);
    void cancela(Conta_poupanca cp);

}
