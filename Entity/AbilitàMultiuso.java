package Entity;

import java.io.FileNotFoundException;
import java.util.Random;

public class AbilitàMultiuso implements Abilità {

    private String id;
    private EffettoComposite effetti_self;
    private EffettoComposite effetti;
    private Fase fase_attivazione;
    private String implementator_type; 
    private AbilitàImplementator implementator;
    private int PercentualeAttivazione;
    private String id_effetti;
    private String id_effetti_self;

  

    public AbilitàMultiuso(EffettoComposite effetti_self, EffettoComposite effetti, Fase fase_attivazione,
            String implementator_type, AbilitàImplementator implementator, int percentualeAttivazione,
            String id_effetti, String id_effetti_self, String id) {
                this.id=id;
        this.effetti_self = effetti_self;
        this.effetti = effetti;
        this.fase_attivazione = fase_attivazione;
        this.implementator_type = implementator_type;
        this.implementator = implementator;
        PercentualeAttivazione = percentualeAttivazione;
        this.id_effetti = id_effetti;
        this.id_effetti_self = id_effetti_self;
    }


    public AbilitàMultiuso(AbilitàMultiuso a){
        
        this.effetti_self = a.getEffetti_self();
        this.id=a.getId();
        this.fase_attivazione = a.getFase_attivazione();
        this.PercentualeAttivazione=a.getPercentualeAttivazione();
        this.id_effetti=a.getId_effetti();
        this.id_effetti_self=a.getId_effetti_self();
        this.implementator_type=a.getImplementator_type();
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
            this.effetti=FlyweightEffettoFactorySingleton.getIstanza().createEffetto(this.id_effetti);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            this.effetti_self=FlyweightEffettoFactorySingleton.getIstanza().createEffetto(this.id_effetti_self);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio) {
        // TODO Auto-generated method stub
       if(new Random().nextInt(100)<=this.PercentualeAttivazione)
        this.implementator.ApplicaEffetto(utilizzatore, bersaglio);
       
       
        
        
    }
    public EffettoComposite getEffetti_self() {
        return effetti_self;
    }
    public void setEffetti_self(EffettoComposite effetti_self) {
        this.effetti_self = effetti_self;
    }
    public EffettoComposite getEffetti() {
        return effetti;
    }
    public void setEffetti(EffettoComposite effetti) {
        this.effetti = effetti;
    }
    public Fase getFase_attivazione() {
        return fase_attivazione;
    }
    public void setFase_attivazione(Fase fase_attivazione) {
        this.fase_attivazione = fase_attivazione;
    }
    public AbilitàImplementator getImplementator() {
        return implementator;
    }
    public void setImplementator(AbilitàImplementator implementator) {
        this.implementator = implementator;
    }
    public String getImplementator_type() {
        return implementator_type;
    }
    public void setImplementator_type(String implementator_type) {
        this.implementator_type = implementator_type;
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


    @Override
    public String toString() {
        return "AbilitàMultiuso [PercentualeAttivazione=" + PercentualeAttivazione + ", effetti=" + effetti
                + ", effetti_self=" + effetti_self + ", fase_attivazione=" + fase_attivazione + ", id=" + id
                + ", id_effetti=" + id_effetti + ", id_effetti_self=" + id_effetti_self + ", implementator="
                + implementator + ", implementator_type=" + implementator_type + "]";
    }
   
    
}
