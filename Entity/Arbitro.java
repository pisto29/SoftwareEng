package Entity;

import java.util.Random;

public class Arbitro {
    //aa
    public boolean checkAbilità(Personaggio p1,Fase f){
if(p1.getAbilità().getFase_attivazione()==f) return true;
else return false;
    }
    public void checkvelocita(Personaggio p[]){
        if(p[0].getvelocitaPersonaggio()<p[1].getvelocitaPersonaggio()){
            Personaggio appoggio=p[1];//da testare
            p[1]=p[0];
            p[0]=appoggio;

        }
        if(p[0].getvelocitaPersonaggio()==p[1].getvelocitaPersonaggio()){
            if(new Random().nextInt(100)<=50){
                Personaggio appoggio=p[1];//da testare
                p[1]=p[0];
                p[0]=appoggio;
            }
        }
    }

    public boolean checkKO(Personaggio P){
        if(P.getpS()==0) return true;
        else return false;
    }

}
