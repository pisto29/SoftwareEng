package Entity;

public class EffettoStatus implements EffettoComposite {

    
    private int id;
    private StatusStrategy statusApplicato;
    private String msg;
    public EffettoStatus(int id) {
        this.id = id;
        this.msg="è ora affetto da"+this.statusApplicato.getNome();
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
       p1.setStatus(this.statusApplicato);
       System.out.println(p1.getNomePersonaggio()+this.msg);
        
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
