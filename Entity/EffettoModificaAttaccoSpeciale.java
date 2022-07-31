package Entity;

public class EffettoModificaAttaccoSpeciale implements EffettoComposite{
    
    private float moltiplicatore;
    private int id;
    private String msg;

    public EffettoModificaAttaccoSpeciale(float moltiplicatore, int id) {
        this.moltiplicatore = moltiplicatore;
        this.id = id;
        if(this.moltiplicatore>1){
            this.msg = "aumenta il suo Attacco Speciale";
        }
        else{
            this.msg="diminuisce il suo Attacco Speciale";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        p1.aggiungiMoltiplicatoreAttaccoSpeciale(moltiplicatore);
        System.out.println(p1.getNomePersonaggio()+", "+this.msg);
        
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
