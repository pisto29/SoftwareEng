package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class Abilità {

    protected ArrayList<Effetto> effetti_self;
    protected ArrayList<Effetto> effetti;
    protected Fase fase_attivazione;
    protected String implementator_type; 
    protected AbilitàImplementator implementator;
    protected int PercentualeAttivazione;
    protected ArrayList<String> id_effetti;
    protected ArrayList<String> id_effetti_self;
    protected String id;
    protected String nome;

    public Abilità(  Fase fase_attivazione,
            String implementator_type,  int percentualeAttivazione,
            ArrayList<String> id_effetti, ArrayList<String> id_effetti_self, String id, String nome) throws FileNotFoundException {
        
        this.fase_attivazione = fase_attivazione;
        this.implementator_type = implementator_type;
        this.implementator = implementator;
        PercentualeAttivazione = percentualeAttivazione;
        this.id_effetti = id_effetti;
        this.id_effetti_self = id_effetti_self;
        this.id = id;
        this.nome = nome;
        switch(this.implementator_type){
            case "attacco":
            this.implementator=AbilitàAttaccoBridge.getIstanza();
            break;
            case "difesa":
            this.implementator=AbilitàDifesaBridge.getIstanza();
            break;
            default:this.implementator=AbilitàNeutraBridge.getIstanza();
        }
        effetti=new ArrayList<>();
        for(String s: id_effetti)
        this.effetti.add(EffettiFactorySingleton.getIstanza().CreaEffetto(s));
        this.effetti_self=new ArrayList<>();
        for(String s: id_effetti_self)
        this.effetti_self.add(EffettiFactorySingleton.getIstanza().CreaEffetto(s));
        
    }



    public abstract void Attivazione(Personaggio utilizzatore,Personaggio bersaglio, Fase Fase_corrente);

    

 

    public void setFase_attivazione(Fase fase_attivazione) {
        this.fase_attivazione = fase_attivazione;
    }

    public String getImplementator_type() {
        return implementator_type;
    }

    public void setImplementator_type(String implementator_type) {
        this.implementator_type = implementator_type;
    }

    public AbilitàImplementator getImplementator() {
        return implementator;
    }

    public void setImplementator(AbilitàImplementator implementator) {
        this.implementator = implementator;
    }

    public int getPercentualeAttivazione() {
        return PercentualeAttivazione;
    }

    public void setPercentualeAttivazione(int percentualeAttivazione) {
        PercentualeAttivazione = percentualeAttivazione;
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



   


    public Fase getFase_attivazione() {
        return fase_attivazione;
    }



    public String getNome() {
        return nome;
    }



    public ArrayList<Effetto> getEffetti_self() {
        return effetti_self;
    }



    public void setEffetti_self(ArrayList<Effetto> effetti_self) {
        this.effetti_self = effetti_self;
    }



    public ArrayList<Effetto> getEffetti() {
        return effetti;
    }



    public void setEffetti(ArrayList<Effetto> effetti) {
        this.effetti = effetti;
    }



    public ArrayList<String> getId_effetti() {
        return id_effetti;
    }



    public void setId_effetti(ArrayList<String> id_effetti) {
        this.id_effetti = id_effetti;
    }



    public ArrayList<String> getId_effetti_self() {
        return id_effetti_self;
    }



    public void setId_effetti_self(ArrayList<String> id_effetti_self) {
        this.id_effetti_self = id_effetti_self;
    }
   
    
}
