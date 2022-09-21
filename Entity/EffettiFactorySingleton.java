package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Foundation.builder;

public class EffettiFactorySingleton {
    private static EffettiFactorySingleton istanza;

    private EffettiFactorySingleton() {
    }
    public static EffettiFactorySingleton getIstanza(){
        if(istanza==null)
        istanza=new EffettiFactorySingleton();
        return istanza;
    }
    public EffettoStrumento creEffettoStrumento(String id){
       EffettoStrumento E = null;
        try {
         
            String classe = id.split("_")[0];
           // String effetto = id.split("_")[0];
        
            
            switch(classe){
                case "EffettoCura" :
                
                    E = builder.creaEffettoCura(id);
                    break;
                case "EffettoRimozioneStatus" :
                    E =builder.creaEffettoRimozioneStatus(id);
                    break;
                case "EffettoRevitalizzante" :
                    E =builder.creaEffettoRevitalizzante(id);
                    break;
    
            }
          
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  return E;
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
