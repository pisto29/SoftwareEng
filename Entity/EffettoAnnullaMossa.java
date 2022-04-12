package Entity;

public class EffettoAnnullaMossa implements EffettoComposite {

    public void ApplicaEffetto(Personaggio p1){

        p1.DisabiltaAttacco();
    }

    
}
