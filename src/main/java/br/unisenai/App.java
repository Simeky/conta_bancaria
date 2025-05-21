package br.unisenai;

import br.unisenai.classes.UF;
import br.unisenai.enums.E_regiao;
import controllers.UF_controller;

public class App 
{
    public static void main( String[] args )    {    

        UF uf = new UF();
        UF uf2 = new UF();
        UF uf3 = new UF();
        UF uf4 = new UF();
        UF uf5 = new UF();
        UF_controller ufc = new UF_controller();

        uf.setUf_nome("Santa Cataria");
        uf.setUf_sigla("SC");
        uf.setUf_regiao(E_regiao.Sul);

        uf2.setUf_nome("São Paulo");
        uf2.setUf_sigla("SP");
        uf2.setUf_regiao(E_regiao.Sudeste);

        uf3.setUf_nome("Pernambuco");
        uf3.setUf_sigla("PE");
        uf3.setUf_regiao(E_regiao.Nordeste);

        uf4.setUf_nome("Rio de Janeiro");
        uf4.setUf_sigla("RJ");
        uf4.setUf_regiao(E_regiao.Sudeste);

        uf5.setUf_nome("Pará");
        uf5.setUf_sigla("PA");
        uf5.setUf_regiao(E_regiao.Norte);
        
        ufc.insert(uf);
        ufc.insert(uf2);
        ufc.insert(uf3);
        ufc.insert(uf4);
        ufc.insert(uf5);

        uf.setUf_nome("Teste");
        uf.setUf_sigla("TE");
        uf.setUf_regiao(E_regiao.Sul);

        ufc.update(uf);
        ufc.delete(uf5.getUf_id());

        System.out.println(uf.getUf_id() + " | " + uf2.getUf_id());

    }
}
