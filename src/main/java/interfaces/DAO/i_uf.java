package interfaces.DAO;

import java.util.List;
import br.unisenai.classes.UF;
public interface I_uf {

    UF find_UF(long id);
    UF find_UF(String sigla);
    List<UF> find_all(String condicao, String ordem);
    void insert(UF uf);
    void update(UF uf);
    void save(UF uf);
    void delete(long id);
    void delete(UF uf);

}
