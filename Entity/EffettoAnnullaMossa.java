package Entity;

public class EffettoAnnullaMossa implements Effetto {
private String id;
private String messaggio;

    public EffettoAnnullaMossa(String id) {
    this.id = id;
    messaggio=" non potrà eseguire il prossimo attacco";
}
    public EffettoAnnullaMossa(EffettoAnnullaMossa effetto){
    
        this.id = effetto.getId();
        messaggio=" non potrà eseguire il prossimo attacco";
    }

    public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

    public void ApplicaEffetto(Personaggio p1){
    System.out.println(p1.getNomePersonaggio()+" "+this.messaggio);
        p1.DisabiltaAttacco();
        

    }

   

    
    
}
