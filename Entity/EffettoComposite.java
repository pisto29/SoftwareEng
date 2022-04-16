package Entity;

public interface EffettoComposite {

    public void ApplicaEffetto(Personaggio p1);
    public void Add(EffettoComposite e);
    public void Remove(EffettoComposite e);
    public int getChild(int a);
 
}
