package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Banco;

public interface iBancoDAO {

    Banco find_banco(long id);
    Banco find_banco(String nome);
    List<Banco> find_all(String condicao, String ordem);
    void insert(Banco ban);
    void update(Banco ban);
    void save(Banco ban);
    void delete(long id);

}
