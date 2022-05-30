package Entity;

public class AbilitàAttaccoBridge implements AbilitàImplementator {

    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        
        if(utilizzatore.getImplementator().getClass().getSimpleName().equals("attaccanteBridge")){
            utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
            utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        }
    }

  
    
}
