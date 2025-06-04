package interfaces.DAO;

import java.util.List;

import br.unisenai.classes.Quadro_societario;

public interface iQuadro_societarioDAO {

    Quadro_societario find_banco(long id);
    Quadro_societario find_banco(String t);
    List<Quadro_societario> find_all(String condicao, String ordem);
    void insert(Quadro_societario qs);
    void update(Quadro_societario qs);
    void save(Quadro_societario qs);
    void delete(long id);
    void delete(Quadro_societario qs);

}
