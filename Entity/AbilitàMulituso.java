package Entity;

public class AbilitàMulituso implements Abilità {

    
    private EffettoComposite effetti_self;
    private EffettoComposite effetti;
    private Fase fase_attivazione; 
    public AbilitàMulituso(EffettoComposite effetti_self, EffettoComposite effetti, Fase fase_attivazione) {
        this.effetti_self = effetti_self;
        this.effetti = effetti;
        this.fase_attivazione = fase_attivazione;
    }
    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio) {
        // TODO Auto-generated method stub
        
        this.effetti_self.ApplicaEffetto(utilizzatore);
        this.effetti.ApplicaEffetto(bersaglio);
        
        
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
    
}
