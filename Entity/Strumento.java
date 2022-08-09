package Entity;

import java.io.FileNotFoundException;

import Foundation.builder;

public class Strumento {
    
    private String nomeStrumento;
    private EffettoStrumento effetto;
    private String idEffetto;
    private Boolean utilizzato;

    public Strumento(Strumento s) {
        this.nomeStrumento=s.nomeStrumento;
        this.idEffetto=s.idEffetto;
        this.utilizzato = false;
        try {
     
            this.effetto=builder.CreaEffettoStrumento(s.idEffetto);
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

    public void UtilizzaStrumento(Personaggio P){
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
    
}
