package Entity;
import java.util.*;
public class Sonno implements StatusStrategy {
private int durataSonno;
private int durataMassima;

   

    public Sonno() {
    this.durataSonno = 0;
    this.durataMassima = 3;
}

    @Override
    public void Attivazione(Personaggio P1) {
        // TODO Auto-generated method stub
        if(this.checkAttivazione()) this.durataSonno=+this.durataSonno;
        else ;
        
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
    
}
