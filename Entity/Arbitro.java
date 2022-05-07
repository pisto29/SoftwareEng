package Entity;

import java.util.Random;

public class Arbitro {
    
    public boolean checkAbilità(Personaggio p1,Fase f){
if(p1.getAbilità().getFase_attivazione()==f) return true;
else return false;
    }
    public void checkVelocità(Personaggio p[]){
        if(p[0].getVelocitàPersonaggio()<p[1].getVelocitàPersonaggio()){
            Personaggio appoggio=p[1];//da testare
            p[1]=p[0];
            p[0]=appoggio;

        }
        if(p[0].getVelocitàPersonaggio()==p[1].getVelocitàPersonaggio()){
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
