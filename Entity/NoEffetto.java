package Entity;

public class NoEffetto implements EffettoComposite{

    private String Id;

    @Override
    public void Add(EffettoComposite e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Remove(EffettoComposite e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public EffettoComposite getChild(int a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        return null;
    }
    
    public void setId(String Id){
        this.Id = Id;
    }
    
}
