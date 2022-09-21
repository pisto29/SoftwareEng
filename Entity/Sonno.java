package Entity;
import java.util.*;
public class Sonno extends StatusStrategy {
private int durataSonno;
private int durataMassima;
private String Nome;
   

   
    


    public Sonno() {
    super("Sonno", Fase.Pre_azione);this.durataSonno = 0;
    this.durataMassima = 3;
   
}

    @Override
    public void Attivazione(Personaggio P1, Fase f) {
        // TODO Auto-generated method stub
        //System.out.println(P1.getNomePersonaggio()+" si è addormentato ");
        if(f.equals(Fase.Pre_azione))
        if(this.checkAttivazione()){
            P1.DisabiltaAttacco();
            this.durataSonno=+this.durataSonno;
            System.out.println(P1.getNomePersonaggio()+" sta dormendo, non può attaccare");
        } 
        else{
            P1.setStatus(null);
            System.out.println(P1.getNomePersonaggio()+" si è svegliato!");
            P1.AbiltaAttacco();} 
        
    }

    @Override
    public boolean checkAttivazione() {
        if(this.durataSonno==this.durataMassima) return false;
        else {
            if(new Random().nextInt(100)<=33){
                return false;
                
            }
            else return true;
        }
         
    }

    @Override
    public void EffettoApplicazione(Personaggio p1) {
        // TODO Auto-generated method stub
        p1.DisabiltaAttacco();
        
    }

    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return this.Nome;
    }
    
}
