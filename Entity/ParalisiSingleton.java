package Entity;
import java.util.*;
public class ParalisiSingleton implements StatusStrategy {
    private static ParalisiSingleton istanza;

    public ParalisiSingleton() {
    }

    public static ParalisiSingleton getIstanza() {

        if(istanza==null) {

            istanza=new ParalisiSingleton();
        }
     return istanza;
    }

    @Override
    public void Attivazione(Personaggio P1) {
        // TODO Auto-generated method stub
        if(this.checkAttivazione())
        P1.DisabiltaAttacco();
    }

    @Override
    public boolean checkAttivazione() {
      
        if(new Random().nextInt(100)<=25) return true;
        else return false;
    }

    @Override
    public void EffettoApplicazione(Personaggio P1) {
        P1.aggiungiMoltiplicatoreVelocita(0.25f);
        
    }
    
}
