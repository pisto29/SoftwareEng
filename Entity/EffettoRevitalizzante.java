package Entity;

import java.util.ArrayList;

public class EffettoRevitalizzante implements EffettoStrumento {
private int PS;
    public int getPS() {
    return PS;
}
public void setPS(int PS) {
    this.PS = PS;
}
    public EffettoRevitalizzante(int PS) {
    this.PS = PS;
}
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
       if(P.getRuolo().getClass().getSimpleName().equals("KoSingleton")){
       P.setpS(this.PS);
       P.Sostituzione();
       System.out.println(P.getNomePersonaggio()+" torna in forze recuperando "+this.PS+" PS");
    }
       
        
    }
    @Override
    public ArrayList<Personaggio> Utilizzabile(ArrayList<Personaggio> a) {
        
    
        ArrayList<Personaggio> u= new ArrayList<>();
        for(Personaggio p: a){
         if(p.getpS()==0)u.add(p);
         else{u.add(null);}
       
        }
          return u;
    }
    
}
