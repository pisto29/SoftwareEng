package Entity;

import java.io.FileNotFoundException;
import java.util.*;

import Foundation.builder;


public class TipoFactorySingleton {
    //private HashMap<String, Tipo > tipi;
    private static TipoFactorySingleton istanza;
    
    private TipoFactorySingleton(){
        //this.tipi = new HashMap<>();
    }
    
    public static TipoFactorySingleton getIstanza() {

        if(istanza==null) {

            istanza=new TipoFactorySingleton();
        }
     return istanza;

    }
     
    public Tipo Create(String tipo) throws FileNotFoundException{
        //if(tipi.containsKey(tipo))
        //    return tipi.get(tipo);
        //else{
        //    HashMap <Tipo,Float> eff= new HashMap<>();
            Tipo t= builder.CreaTipo(tipo);
        //    tipi.put(tipo, t);
            return t;
       // }
    }

}
