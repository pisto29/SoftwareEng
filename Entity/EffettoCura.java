package Entity;

public class EffettoCura implements EffettoStrumento {

    private int PS;
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
        // TODO Auto-generated method stub
        P.setpS(P.getpS()+this.PS);
        System.out.println(P.getNomePersonaggio()+" ha recuperato "+this.PS+" PS");
      
        
        
    }
    public int getPS() {
        return PS;
    }

    
}
