package Entity;

public class EffettoModificaDifesaSpeciale implements EffettoComposite{
    
    private float moltiplicatore;

    public EffettoModificaDifesaSpeciale(float moltiplicatore) {
        this.moltiplicatore = moltiplicatore;
    }

    public float getMoltiplicatore() {
        return moltiplicatore;
    }

    public void setMoltiplicatore(float moltiplicatore) {
        this.moltiplicatore = moltiplicatore;
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
        // TODO Auto-generated method stub
        p1.aggiungiMoltiplicatoreDifesaSpeciale(moltiplicatore);
        
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
    public int getChild(int a) {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
