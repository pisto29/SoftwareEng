package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class AbilitàMonouso extends Abilità{

    private boolean attivata;
    public boolean isAttivata() {
        return attivata;
       
    }


    public void setAttivata(boolean attivata) {
        this.attivata = attivata;
    }




   
  



    public AbilitàMonouso(Fase fase_attivazione, String implementator_type, int percentualeAttivazione,
    ArrayList< String >id_effetti, ArrayList<String> id_effetti_self, String id, String nome) throws FileNotFoundException{
        super( fase_attivazione, implementator_type,  percentualeAttivazione,
                id_effetti, id_effetti_self, id, nome);
        this.attivata = false;
        
    }


    public AbilitàMonouso(AbilitàMonouso a) throws FileNotFoundException{
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
