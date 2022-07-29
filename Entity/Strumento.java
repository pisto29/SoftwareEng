package Entity;

public class Strumento {
    
    private String nomeStrumento;
    private EffettoStrumento effetto;
   
    public Strumento(String nomeStrumento, EffettoStrumento effetto) {
        this.nomeStrumento = nomeStrumento;
        this.effetto = effetto;
    }

    public void UtilizzaStrumento(Personaggio P){
        this.effetto.ApplicaEffettoStrumento(P);
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

    public void setEffetto(EffettoStrumento effetto) {
        this.effetto = effetto;
    } 
    
}
