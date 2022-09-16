package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Foundation.builder;

public class Strumento {
    
    private String nomeStrumento;
    private EffettoStrumento effetto;
    private String idEffetto;
    private Boolean utilizzato;

    public Strumento(Strumento s) throws JsonSyntaxException, JsonIOException, ClassNotFoundException {
        this.nomeStrumento=s.nomeStrumento;
        this.idEffetto=s.idEffetto;
        this.utilizzato = false;
        try {
         
            String classe = s.idEffetto.split("_")[0];
           // String effetto = id.split("_")[0];
        
            EffettoStrumento E = null;
            switch(classe){
                case "EffettoCura" :
                
                    E = builder.creaEffettoCura(s.idEffetto);
                    break;
                case "EffettoRimozioneStatus" :
                    E =builder.creaEffettoRimozioneStatus(s.idEffetto);
                    break;
                case "EffettoRevitalizzante" :
                    E =builder.creaEffettoRevitalizzante(s.idEffetto);
                    break;
    
            }
            this.effetto=E;
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Strumento(String nomeStrumento, String idEffetto) {
        
        this.nomeStrumento = nomeStrumento;
        this.idEffetto = idEffetto;
        this.utilizzato = false;
    }

    public void Utilizza(Personaggio P){
        System.out.println("Viene utilizzato "+this.nomeStrumento+" su "+P.getNomePersonaggio());
        this.effetto.ApplicaEffettoStrumento(P);
        this.utilizzato = true;
    }

    public String getNomeStrumento() {
        return nomeStrumento;
    }

    public void setNomeStrumento(String nomeStrumento) {
        this.nomeStrumento = nomeStrumento;
    }

    public EffettoStrumento getEffetto() {
        return effetto;
    }

    public void setEffetto(EffettoStrumento E) {
        this.effetto=E;
    }

    public String getIdEffetto() {
        return idEffetto;
    }

    public void setIdEffetto(String idEffetto) {
        this.idEffetto = idEffetto;
    }

    public Boolean getUtilizzato() {
        return utilizzato;
    }

    public void setUtilizzato(Boolean utilizzato) {
        this.utilizzato = utilizzato;
    } 

    public ArrayList<Personaggio> utilizzabile(ArrayList<Personaggio> p){
       
        return this.effetto.Utilizzabile(p);
    }
    
}
