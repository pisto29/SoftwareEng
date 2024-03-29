package Entity;

public class EffettoModificaAttacco implements Effetto {
    
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
     
    p1.aggiungiMoltiplicatoreAttacco(moltiplicatore);
    System.out.println(p1.getNomePersonaggio()+", "+this.msg);
    
       
        
    }

  
    
    
}
