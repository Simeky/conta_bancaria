package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Pessoa_fisica;

public interface iPessoa_fisicaDAO {

    Pessoa_fisica find_pessoa_fisica(long id);
    Pessoa_fisica find_pessoa_fisica(String t);
    List<Pessoa_fisica> find_all(String condicao, String ordem);
    void insert(Pessoa_fisica pf);
    void update(Pessoa_fisica pf);
    void save(Pessoa_fisica pf);
    void delete(long id);
    void delete(Pessoa_fisica pf);

}
