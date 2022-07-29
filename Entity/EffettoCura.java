package Entity;

public class EffettoCura implements EffettoStrumento {

    private int PS;
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
        // TODO Auto-generated method stub
        P.setpS(P.getpS()+this.PS);
        
    }

    
}
