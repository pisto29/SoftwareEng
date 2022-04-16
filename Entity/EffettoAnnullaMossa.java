package Entity;

public class EffettoAnnullaMossa implements EffettoComposite {

    public void ApplicaEffetto(Personaggio p1){

        p1.DisabiltaAttacco();
        

    }

    @Override
    public void Add(EffettoComposite e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Remove(EffettoComposite e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EffettoComposite getChild(int a) {
        // TODO Auto-generated method stub
        return this;
    }

    
    
}
