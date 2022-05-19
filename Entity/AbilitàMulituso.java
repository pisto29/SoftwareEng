package Entity;

public class AbilitàMulituso implements Abilità {

    
    private EffettoComposite effetti_self;
    private EffettoComposite effetti;
    private Fase fase_attivazione;
    private int max_attivazioni_per_turno;
    private int attivazioni_per_turno; 
    public AbilitàMulituso(EffettoComposite effetti_self, EffettoComposite effetti, Fase fase_attivazione, int max_attivazioni_per_turno) {
        this.effetti_self = effetti_self;
        this.effetti = effetti;
        this.fase_attivazione = fase_attivazione;
         this.max_attivazioni_per_turno=max_attivazioni_per_turno;
        this.attivazioni_per_turno=0;
    }
    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio) {
        // TODO Auto-generated method stub
        if(this.attivazioni_per_turno<this.max_attivazioni_per_turno){
        this.effetti_self.ApplicaEffetto(utilizzatore);
        this.effetti.ApplicaEffetto(bersaglio);
        this.attivazioni_per_turno=+this.attivazioni_per_turno;
        }
        
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
    public int getMax_attivazioni_per_turno() {
        return max_attivazioni_per_turno;
    }
    public void setMax_attivazioni_per_turno(int max_attivazioni_per_turno) {
        this.max_attivazioni_per_turno = max_attivazioni_per_turno;
    }
    public int getAttivazioni_per_turno() {
        return attivazioni_per_turno;
    }
    public void setAttivazioni_per_turno(int attivazioni_per_turno) {
        this.attivazioni_per_turno = attivazioni_per_turno;
    }
    
}
