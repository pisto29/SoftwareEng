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
    ;

    public Strumento(Strumento s) throws JsonSyntaxException, JsonIOException, ClassNotFoundException {
        this.nomeStrumento=s.nomeStrumento;
        this.idEffetto=s.idEffetto;
        this.utilizzato = false;
        
       this.effetto=EffettiFactorySingleton.getIstanza().creEffettoStrumento(this.idEffetto);
    }

    public Strumento(String nomeStrumento, String idEffetto) {
        
        this.nomeStrumento = nomeStrumento;
        this.idEffetto = idEffetto;
        this.utilizzato = false;
    }

    public String Utilizza(Personaggio p){this.utilizzato = true;
        return "Viene utilizzato "+this.nomeStrumento+" su "+p.getNomePersonaggio()+" ".concat(this.effetto.ApplicaEffettoStrumento(p));
        
        
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
