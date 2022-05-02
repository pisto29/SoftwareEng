package Entity;

import java.util.*;


public class TipoFactorySingleton {
    private HashMap<String, Tipo > tipi;
    private static TipoFactorySingleton istanza;
    
    public static TipoFactorySingleton getIstanza() {

        if(istanza==null) {

            istanza=new TipoFactorySingleton();
        }
     return istanza;

    }
     
    public Tipo Create(String tipo){
        if(tipi.containsKey(tipo))
            return tipi.get(tipo);
        else{
            HashMap <Tipo,Float> eff= new HashMap<>();
            Tipo t=new Tipo(tipo, eff);
            tipi.put(tipo, t);
            return t;
        }
    }

}
