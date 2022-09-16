package Entity;

import java.io.FileNotFoundException;
import java.util.Random;

public class AbilitàMonouso extends Abilità{

    private boolean attivata;
    public boolean isAttivata() {
        return attivata;
       
    }


    public void setAttivata(boolean attivata) {
        this.attivata = attivata;
    }




   
  



    public AbilitàMonouso(EffettoComposite effetti_self, EffettoComposite effetti, Fase fase_attivazione,
            String implementator_type, AbilitàImplementator implementator, int percentualeAttivazione,
            String id_effetti, String id_effetti_self, String id, String nome, boolean attivata,
            EffettoComposite effetti_self2, EffettoComposite effetti2, Fase fase_attivazione2,
            String implementator_type2, AbilitàImplementator implementator2, int percentualeAttivazione2,
            String id_effetti2, String id_effetti_self2, String id2, String nome2) {
        super( fase_attivazione, implementator_type,  percentualeAttivazione,
                id_effetti, id_effetti_self, id, nome);
        this.attivata = attivata;
        
    }


    public AbilitàMonouso(AbilitàMonouso a){
        super( a.getFase_attivazione(), a.getImplementator_type(), a.getPercentualeAttivazione(),
        a.getId_effetti(), a.getId_effetti_self(), a.getId(), a.getNome());
        this.attivata=a.isAttivata();
      
    }

    @Override
    public void Attivazione(Personaggio utilizzatore, Personaggio bersaglio, Fase Fase_corrente) {
        if(!this.attivata&&Fase_corrente.equals(this.fase_attivazione)){
            if(new Random().nextInt(100)<=this.PercentualeAttivazione){
                //System.out.println("Si attiva l'abilità "+ this.nome +" di "+ utilizzatore.getNomePersonaggio());
        this.implementator.ApplicaEffetto(utilizzatore, bersaglio, effetti_self,effetti);
        this.attivata=true;
    }
    }
        
    }


  
}
