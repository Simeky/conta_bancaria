package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Conta_especial;

public interface iConta_especialDAO {

    Conta_especial find_conta_especial(long id);
    Conta_especial find_conta_especial(String t);
    List<Conta_especial> find_all(String condicao, String ordem);
    void insert(Conta_especial ce);
    void update(Conta_especial ce);
    void save(Conta_especial ce);
    void delete(long id);
    void delete(Conta_especial ce);

}
