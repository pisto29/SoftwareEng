package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Foundation.builder;

public class EffettoFactorySingleton {
    private static EffettoFactorySingleton istanza;

    private EffettoFactorySingleton() {
    }
    public static EffettoFactorySingleton getIstanza(){
        if(istanza==null)
        istanza=new EffettoFactorySingleton();
        return istanza;
    }
    public Effetto CreaEffetto(String id) throws FileNotFoundException {
        Effetto E=null;
        String classe=id.split("_")[0];
       
        switch(classe){
            case "EffettoAnnullaMossa":
            E =builder.creaEffettoAnnullaMossa(id);
           
            break;

            case "EffettoModificaAttacco":
            E =builder.creaEffettoModificaAttacco(id);
           
            break;

            case "EffettoModificaAttaccoSpeciale":
            E =builder.creaEffettoModificaAttaccoSpeciale(id);
         
            break;

            case "EffettoModificaDifesa":
            E = builder.creaEffettoModificaDifesa(id);
            
            break;

            case "EffettoModificaDifesaSpeciale":
            E =builder.creaEffettoModificaDifesaSpeciale(id);
            
            break;

            case "EffettoModificaVelocita":
            E =builder.creaEffettoModificaVelocita(id);
           
            break;

            case "EffettoStatus":
            E =builder.creaEffettoStatus(id);
            
           
            break;
            case "NoEffetto":
            E =new NoEffetto();
            
            break;
        }
        

    
    return E;
        
        
    }
}
