package br.unisenai;

import utilitarios.utils;

public class App 
{
    public static void main( String[] args )
    {

        if (utils.validar_cpf("")) {
          
            System.out.println("Sim");
            
        }   else {

                System.out.println("Não");

            }
        
    }
}
