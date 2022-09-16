package Entity;

public class StrumentoMossa implements EsecuzioneTurno {
    //private ImplementatorManagerSingleton implementatorManager;

    public void esecuzione(Turno t) {
        
        
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
