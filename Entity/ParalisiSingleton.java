package Entity;
import java.util.*;
public class ParalisiSingleton extends StatusStrategy {
    private static ParalisiSingleton istanza;
   
    private ParalisiSingleton(String nome, Fase faseAttivazione) {
        super(nome, faseAttivazione);
    }

   

    public static ParalisiSingleton getIstanza() {

        if(istanza==null) {

            istanza=new ParalisiSingleton("Paralisi",Fase.Pre_azione);
        }
     return istanza;
    }

    @Override
    public void Attivazione(Personaggio P1, Fase f) {
        // TODO Auto-generated method stub
     //System.out.println(f);
        P1.AbiltaAttacco();
        if(this.checkAttivazione()&&f.equals(Fase.Pre_azione)){
        P1.DisabiltaAttacco();
        System.out.println(P1.getNomePersonaggio()+" è paralizzato, non può attaccare");}
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

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return this.Nome;
    }
    
}
