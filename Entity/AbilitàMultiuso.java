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
 
}
