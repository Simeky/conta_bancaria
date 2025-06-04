package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_corrente;

public interface iConta_correnteDAO {

    Conta_corrente find_conta_corrente(long id);
    Conta_corrente find_conta_corrente(String t);
    List<Conta_corrente> find_all(String condicao, String ordem);
    void insert(Conta_corrente cc);
    void update(Conta_corrente cc);
    void save(Conta_corrente cc);
    void delete(long id);
    void delete(Conta_corrente cc);

}
