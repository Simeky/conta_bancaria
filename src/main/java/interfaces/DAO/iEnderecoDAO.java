package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Endereco;

public interface iEnderecoDAO {

    Endereco find_endereco(long id);
    List<Endereco> find_all(String condicao, String ordem);
    void insert(Endereco end);
    void update(Endereco end);
    void save(Endereco end);
    void delete(long id);
}
