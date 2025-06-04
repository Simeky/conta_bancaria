package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_bancaria;

public interface iConta_bancariaDAO {

    Conta_bancaria find_conta_bancaria(long id);
    Conta_bancaria find_conta_bancaria(String t);
    List<Conta_bancaria> find_all(String condicao, String ordem);
    void insert(Conta_bancaria cb);
    void update(Conta_bancaria cb);
    void save(Conta_bancaria cb);
    void delete(long id);
    void delete(Conta_bancaria cb);

}
