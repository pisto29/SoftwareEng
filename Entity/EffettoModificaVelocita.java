package Entity;

public class EffettoModificaVelocita implements EffettoComposite{
    
    private float moltiplicatore;
    private int id;
    
    
    public EffettoModificaVelocita(float moltiplicatore, int id) {
        this.moltiplicatore = moltiplicatore;
        this.id = id;
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
        p1.aggiungiMoltiplicatoreVelocita(moltiplicatore);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
