package br.unisenai;

import br.unisenai.classes.UF;
import br.unisenai.enums.E_regiao;
import controllers.UF_controller;

public class App 
{
    public static void main( String[] args )
    {

    UF uf = new UF();
    UF_controller uf_control = new UF_controller();

    uf.setUf_nome("null");    
    uf.setUf_sigla("null");
    uf.setUf_regiao(E_regiao.Sul);
    
    uf_control.insert(uf);

    }
}
