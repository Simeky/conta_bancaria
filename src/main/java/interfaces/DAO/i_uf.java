package interfaces.DAO;

import java.util.List;
import br.unisenai.classes.UF;
public interface I_uf {

    UF find_UF(int id);
    UF find_UF(String sigla);
    List<UF> find_all();
    void insert(UF uf);
    void update(UF uf);
    void save(UF uf);
    void delete(int id);
    void delete(UF uf);

}
