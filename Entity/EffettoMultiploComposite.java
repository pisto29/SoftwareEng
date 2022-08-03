package Entity;

import java.util.*;

public class EffettoMultiploComposite implements EffettoComposite{

    private int id;
    private ArrayList <EffettoComposite> effetti;
    private String[] idEffetti;

    

    public EffettoMultiploComposite(int id, ArrayList<EffettoComposite> effetti, String[] idEffetti) {
        this.id = id;
        this.effetti = effetti;
        this.idEffetti = idEffetti;
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
        // TODO Auto-generated method stub
        int i = 0;
        Iterator <EffettoComposite> iter = this.effetti.iterator();
        while(iter.hasNext()){
            iter.next().ApplicaEffetto(p1);
            //iter.next();
            i++;
            System.out.println(i);
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<EffettoComposite> getEffetti() {
        return effetti;
    }

    public void setEffetti(ArrayList<EffettoComposite> effetti) {
        this.effetti = effetti;
    }

    public String[] getIdEffetti() {
        return idEffetti;
    }
    
}
