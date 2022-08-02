package Entity;

public class EffettoAnnullaMossa implements EffettoComposite {
private int id;
private String messaggio;

    public EffettoAnnullaMossa(int id) {
    this.id = id;
    messaggio=" la mossa avversaria è stata bloccata";
}

    public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

    public void ApplicaEffetto(Personaggio p1){

        p1.DisabiltaAttacco();
        System.out.println(this.messaggio);

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
