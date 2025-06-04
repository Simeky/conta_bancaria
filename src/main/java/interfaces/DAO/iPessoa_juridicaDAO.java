package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Pessoa_juridica;

public interface iPessoa_juridicaDAO {

    Pessoa_juridica find_pessoa_juridica(long id);
    Pessoa_juridica find_pessoa_juridica(String t);
    List<Pessoa_juridica> find_all(String condicao, String ordem);
    void insert(Pessoa_juridica pj);
    void update(Pessoa_juridica pj);
    void save(Pessoa_juridica pj);
    void delete(long id);
    void delete(Pessoa_juridica pj);

}
