package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Foundation.builder;

public class EffettoFactorySingleton {
    private static EffettoFactorySingleton istanza;

    protected EffettoFactorySingleton() {
    }
    public static EffettoFactorySingleton getIstanza(){
        if(istanza==null)
        istanza=new EffettoFactorySingleton();
        return istanza;
    }
    public EffettoComposite CreaEffetto(String id) throws FileNotFoundException {
        EffettoComposite E=null;
        String classe=id.split("_")[0];
        if(id.contains("Multiplo")){
            ArrayList <EffettoComposite> effetti = new ArrayList<>();
        

            EffettoMultiploComposite A =builder.creaEffettoMultiploComposite(id);
            A.setEffetti(effetti);
            for (String nomeEffetto : A.getIdEffetti()) {
               
                String effetto = nomeEffetto.split("_")[0];
                switch(effetto){
                    case "EffettoAnnullaMossa":
                    E =builder.creaEffettoAnnullaMossa(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoModificaAttacco":
                    E =builder.creaEffettoModificaAttacco(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoModificaAttaccoSpeciale":
                    E =builder.creaEffettoModificaAttaccoSpeciale(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoModificaDifesa":
                    E = builder.creaEffettoModificaDifesa(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoModificaDifesaSpeciale":
                    E =builder.creaEffettoModificaDifesaSpeciale(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoModificaVelocita":
                    E =builder.creaEffettoModificaVelocita(nomeEffetto);
                    A.Add(E);
                    break;

                    case "EffettoStatus":
                    E =builder.creaEffettoStatus(nomeEffetto);
                    
                    A.Add(E);
                    break;
                    case "NoEffetto":
                    E =new NoEffetto();
                    A.Add(E);
                    break;
                }
                
            }
         E = A;
    }
    else{
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
        

    }
    return E;
        
        
    }
}
