package Entity;

public class StrumentoMossa implements EsecuzioneTurno {
    //private ImplementatorManagerSingleton implementatorManager;
public void esecuzione(Turno t){
    Personaggio P1;
    Personaggio P2;
    P1=t.getP1();P2=t.getP2();
    t.utilizzaStrumento(P1);
   P2.setAttacca(true);
   P1.setDifende(true);
   t.EseguiAbilità(P2);
    t.EseguiAbilità(P1);
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione);
        t.EseguiAbilità(P2);
        t.EseguiAbilità(P1);
        t.checkstatus(P2);
        t.eseguiAttacco(P2);
    }
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(P2);
        t.EseguiAbilità(P1);
        t.checkstatus(P2);
    }
    P2.setAttacca(false);
    P1.setDifende(false);

if(!t.checkKo(P2)){t.EseguiAbilità(P2);t.checkstatus(P2);}
    if(!t.checkKo(P1)){t.EseguiAbilità(P1);}

   


}
    public void esecuzione2(Turno t) {
        
        
        //ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP2());
        t.getP2().setAttacca(true);
        
        t.getP1().setDifende(true);
        t.utilizzaStrumento(t.getP1());
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
        else {primo=t.getP2();secondo=t.getP1();}
        this.AvviaEsecuzione(t, primo, secondo);
        
    } 

 

    private void AvviaEsecuzione(Turno t, Personaggio primo, Personaggio secondo){    
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.FineTurnoKo();
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilità(primo);
            t.EseguiAbilità(secondo);
            t.checkstatus(t.getP2());
            t.eseguiAttacco(t.getP2());
            t.FineTurnoKo();
        }
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilità(primo);
            t.EseguiAbilità(secondo);
            t.checkstatus(primo);
            t.checkstatus(secondo);
            t.FineTurnoKo();
        }
        primo.setAttacca(false);
  primo.setDifende(false);
  secondo.setAttacca(false);
  secondo.setDifende(false);
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}
    }
}
