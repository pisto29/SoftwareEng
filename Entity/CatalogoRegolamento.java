package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Foundation.builder;

public class CatalogoRegolamento {
    private HashMap<String,Regolamento> Regolamenti;

    public CatalogoRegolamento() throws FileNotFoundException {Regolamenti= new HashMap<String,Regolamento>();
        this.LoadRegolamenti();
       
        
    }
    public Regolamento GetRegolamento(String id){
return this.Regolamenti.get(id);
    }
    private void LoadRegolamenti() throws FileNotFoundException{
        ArrayList<String> id_regole= builder.Id_Regolamenti();
        Regolamento E=null;
        for(String s:id_regole){
            String classe = s.split("_")[0];
            switch(classe){
                case "RegolaLimitazioneNPersonaggi":
                E = builder.creaRegolaLimitazionenLimitazioneNPersonaggi(s);
               
                break;

                case "RegolaLimitazioneNStrumento":
                E = builder.creaRegolaLimitazionenLimitazioneNStrumento(s);
                
                break;

                case "RegolaLimitazioneTipo":
                E = builder.creaRegolaLimitazioneTipo(s);
                
                break;


                case "NoRegole":
                //E = gson.fromJson(br2, NoRegole.class);
                E= new NoRegole();
               
                break;
        }
        Regolamenti.put(s, E);
    }
    
}

}