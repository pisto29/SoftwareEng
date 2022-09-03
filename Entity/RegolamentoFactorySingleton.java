package Entity;

import java.io.FileNotFoundException;

import Foundation.builder;

public class RegolamentoFactorySingleton {
    private static RegolamentoFactorySingleton istanza;
    public static RegolamentoFactorySingleton getIstanza(){
        if(istanza==null){
            istanza=new RegolamentoFactorySingleton();
        }
        return istanza;
    }
    public static RegolamentoComponent CreaRegolamento(String id) throws FileNotFoundException{
        return builder.creaRegolamentoComposite(id);
    }
    
}
