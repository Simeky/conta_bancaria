package br.unisenai;

import br.unisenai.classes.UF;
import br.unisenai.enums.E_regiao;
import controllers.UF_controller;

public class App 
{
    public static void main( String[] args )
    {

    UF uf = new UF();
    UF uf2 = new UF();
    UF_controller uf_control = new UF_controller();

    //uf2.setUf_nome("Santa Catarina");    
    //uf2.setUf_sigla("SC");
    //uf2.setUf_regiao(E_regiao.Sul);

    uf.setUf_nome("São Paulo");    
    uf.setUf_sigla("SP");
    uf.setUf_regiao(E_regiao.Sudeste);
    
    //uf_control.insert(uf2);
    uf_control.update(uf);

    }
}
