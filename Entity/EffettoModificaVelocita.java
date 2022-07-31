package Entity;

public class EffettoModificaVelocita implements EffettoComposite{
    
    private float moltiplicatore;
    private int id;
    private String msg;
    
    public EffettoModificaVelocita(float moltiplicatore, int id) {
        this.moltiplicatore = moltiplicatore;
        this.id = id;
        if(this.moltiplicatore>1){
            this.msg = "aumenta la sua Velocità";
        }
        else{
            this.msg="diminuisce la sua Velocità";
        }
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
