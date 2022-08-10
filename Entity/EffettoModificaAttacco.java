package Entity;

public class EffettoModificaAttacco implements EffettoComposite {
    
    private float moltiplicatore;
    private String id;
    private String msg;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EffettoModificaAttacco(float moltiplicatore,String id) {
        this.moltiplicatore = moltiplicatore;
        this.id=id;
        if(this.moltiplicatore>1){
            this.msg = "aumenta il suo attacco";
        }
        else{
            this.msg="diminuisce il suo attacco";
        }

    }
    public EffettoModificaAttacco(EffettoModificaAttacco effetto){
        this.id = effetto.getId();
        this.moltiplicatore = effetto.getMoltiplicatore();
        if(this.moltiplicatore>1){
            this.msg = "aumenta il suo attacco";
        }
        else{
            this.msg="diminuisce il suo attacco";
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
        System.out.println(p1.getAttaccoPersonaggio());
    p1.aggiungiMoltiplicatoreAttacco(moltiplicatore);
    System.out.println(p1.getNomePersonaggio()+", "+this.msg);
    System.out.println(p1.getAttaccoPersonaggio());
       
        
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
