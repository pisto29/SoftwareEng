package Entity;

import java.io.FileNotFoundException;
import java.util.Random;

public class AbilitàMultiuso extends Abilità {

    

  

    


    public AbilitàMultiuso(Fase fase_attivazione, String implementator_type, int percentualeAttivazione,
            String id_effetti, String id_effetti_self, String id, String nome) {
        super(fase_attivazione, implementator_type, percentualeAttivazione, id_effetti, id_effetti_self, id, nome);
    }
    public AbilitàMultiuso(Abilità a) {
        super( a.getFase_attivazione(), a.getImplementator_type(), a.getPercentualeAttivazione(),
        a.getId_effetti(), a.getId_effetti_self(), a.getId(), a.getNome());
    }
    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio) {
        // TODO Auto-generated method stub
       if(new Random().nextInt(100)<=this.PercentualeAttivazione){
        //System.out.println("Si attiva l'abilità "+ this.nome +" di "+ utilizzatore.getNomePersonaggio());
        this.implementator.ApplicaEffetto(utilizzatore, bersaglio);
       
       }
        
        
    }
  /*   public EffettoComposite getEffetti_self() {
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


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
   
    */
}
