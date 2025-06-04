package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Enderecamento;

public interface iEnderecamentoDAO {

    Enderecamento find_enderecamento(long id);
    Enderecamento find_enderecamento(String t);
    List<Enderecamento> find_all(String condicao, String ordem);
    void insert(Enderecamento end);
    void update(Enderecamento end);
    void save(Enderecamento end);
    void delete(long id);
    void delete(Enderecamento end);

}
