package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Agencia;

public interface iAgenciaDAO {

    Agencia find_agencia(long id);
    Agencia find_agencia(String t);
    List<Agencia> find_all(String condicao, String ordem);
    void insert(Agencia age);
    void update(Agencia age);
    void save(Agencia age);
    void delete(long id);
    void delete(Agencia age);

}
