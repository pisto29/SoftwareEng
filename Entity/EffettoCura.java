package Entity;

import java.util.ArrayList;

public class EffettoCura implements EffettoStrumento {

    private int PS;
    public EffettoCura(int pS) {
        PS = pS;
    }
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
        // TODO Auto-generated method stub
        P.setpS(P.getpS()+this.PS);
        System.out.println(P.getNomePersonaggio()+" ha recuperato "+this.PS+" PS");
      
        
        
    }
    public int getPS() {
        return PS;
    }
    @Override
    public ArrayList<Personaggio> Utilizzabile(ArrayList<Personaggio> a) {
       ArrayList<Personaggio> u= new ArrayList<>();
       for(Personaggio p: a){
        if(p.getpS()>0)u.add(p);
        else{u.add(null);}
      
       }
         return u;
    }

    
}
