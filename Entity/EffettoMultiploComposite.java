package Entity;

import java.util.*;

public class EffettoMultiploComposite implements Effetto{

    private String id;
    private ArrayList <Effetto> effetti;
    private String[] idEffetti;

    

    public EffettoMultiploComposite(String id, ArrayList<Effetto> effetti, String[] idEffetti) {
        this.id = id;
        this.effetti = effetti;
        this.idEffetti = idEffetti;
    }

    @Override
    public void ApplicaEffetto(Personaggio p1) {
        // TODO Auto-generated method stub
        int i = 0;
        Iterator <Effetto> iter = this.effetti.iterator();
        while(iter.hasNext()){
            iter.next().ApplicaEffetto(p1);
            //iter.next();
            i++;
            System.out.println(i);
        }
        
    }


    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Effetto> getEffetti() {
        return effetti;
    }

    public void setEffetti(ArrayList<Effetto> effetti) {
        this.effetti = effetti;
    }

    public String[] getIdEffetti() {
        return idEffetti;
    }
    
}
