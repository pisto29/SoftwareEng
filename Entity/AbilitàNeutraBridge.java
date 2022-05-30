package Entity;

public class AbilitàNeutraBridge implements AbilitàImplementator {

    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
        utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        
    }
    
}
