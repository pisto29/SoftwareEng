package Entity;

public class AbilitàMonouso implements Abilità{

    private boolean attivata;
    public boolean isAttivata() {
        return attivata;
    }


    public void setAttivata(boolean attivata) {
        this.attivata = attivata;
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


    private EffettoComposite effetti_self;
    private EffettoComposite effetti;
    private Fase fase_attivazione; 

    
    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio) {
        this.effetti_self.ApplicaEffetto(utilizzatore);
        this.effetti.ApplicaEffetto(bersaglio);
        this.attivata=false;
        
    }
    
    
}
