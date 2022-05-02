package Entity;

import java.util.*;

public class EffettoMultiploComposite implements EffettoComposite{

    private int id;
    private ArrayList <EffettoComposite> effetti;

    public EffettoMultiploComposite(int id, ArrayList<EffettoComposite> effetti) {
        this.id = id;
        this.effetti = effetti;
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
        // TODO Auto-generated method stub
        Iterator <EffettoComposite> iter = this.effetti.iterator();
        while(iter.hasNext()){
            iter.next().ApplicaEffetto(p1);
        }
    }

    @Override
    public void Add(EffettoComposite e) {
        // TODO Auto-generated method stub
        this.effetti.add(e);
    }

    @Override
    public void Remove(EffettoComposite e) {
        // TODO Auto-generated method stub
        //non necessario al momento
    }

    @Override
    public EffettoComposite getChild(int a) {
        // TODO Auto-generated method stub
        return this.effetti.get(a);
    }
    
}
