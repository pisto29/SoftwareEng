package Entity;

import java.io.FileNotFoundException;

public abstract class Abilità {

    protected EffettoComposite effetti_self;
    protected EffettoComposite effetti;
    protected Fase fase_attivazione;
    protected String implementator_type; 
    protected AbilitàImplementator implementator;
    protected int PercentualeAttivazione;
    protected String id_effetti;
    protected String id_effetti_self;
    protected String id;
    protected String nome;

    public Abilità(  Fase fase_attivazione,
            String implementator_type,  int percentualeAttivazione,
            String id_effetti, String id_effetti_self, String id, String nome) {
        
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
        try {
            this.effetti=EffettoFactorySingleton.getIstanza().CreaEffetto(this.id_effetti);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.effetti_self=EffettoFactorySingleton.getIstanza().CreaEffetto(this.id_effetti_self);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();}
        
    }



    public abstract void Attivazione(Personaggio utilizzatore,Personaggio bersaglio);

    

    public void setEffetti_self(EffettoComposite effetti_self) {
        this.effetti_self = effetti_self;
    }

    public void setEffetti(EffettoComposite effetti) {
        this.effetti = effetti;
    }

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

    public String getId_effetti() {
        return id_effetti;
    }

    public void setId_effetti(String id_effetti) {
        this.id_effetti = id_effetti;
    }

    public String getId_effetti_self() {
        return id_effetti_self;
    }

    public void setId_effetti_self(String id_effetti_self) {
        this.id_effetti_self = id_effetti_self;
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



    public EffettoComposite getEffetti_self() {
        return effetti_self;
    }



    public EffettoComposite getEffetti() {
        return effetti;
    }



    public Fase getFase_attivazione() {
        return fase_attivazione;
    }



    public String getNome() {
        return nome;
    }
   
    
}
