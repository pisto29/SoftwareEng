package Entity;

public class EffettoModificaDifesa implements Effetto {
    
    private float moltiplicatore;
    private String id;
    private String msg;
    
   
    public EffettoModificaDifesa(float moltiplicatore, String id) {
        this.moltiplicatore = moltiplicatore;
        this.id = id;
        if(this.moltiplicatore>1){
            this.msg = "aumenta la sua Difesa";
        }
        else{
            this.msg="diminuisce la sua Difesa";
        }
    }

    public EffettoModificaDifesa(EffettoModificaDifesa effetto) {
        this.moltiplicatore = effetto.getMoltiplicatore();
        this.id = effetto.getId();
        if(this.moltiplicatore>1){
            this.msg = "aumenta la sua Difesa";
        }
        else{
            this.msg="diminuisce la sua Difesa";
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
        p1.aggiungiMoltiplicatoreDifesa(moltiplicatore);
        System.out.println(p1.getNomePersonaggio()+", "+this.msg);
        
    }

   

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
