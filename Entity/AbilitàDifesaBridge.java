package Entity;

public class AbilitàDifesaBridge implements AbilitàImplementator {

    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        if(utilizzatore.getImplementator().getClass().getSimpleName().equals("difensoreBridge")){
            utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
            utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        }
    }
    
}
