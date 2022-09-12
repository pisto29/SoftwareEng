package Entity;

import java.io.FileNotFoundException;

import Foundation.builder;

public class EffettoStrumentoFactorySingleton {
    public static EffettoStrumentoFactorySingleton istanza;
    public static EffettoStrumentoFactorySingleton getIstanza(){
        if(istanza==null){
            istanza=new EffettoStrumentoFactorySingleton();
        }
        return istanza;
    }
    public EffettoStrumento creaEffettoStrumento(String id) throws FileNotFoundException{
        String effetto = id.split("_")[0];
        
        EffettoStrumento E = null;
        switch(effetto){
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
        
        return E;

    }
}
