package Entity;

public class CambioMossa implements EsecuzioneTurno{
 
    //Verranno attivate solo le abilità del giocatore due e la sostituzione precede la mossa
    public void esecuzione (Turno t){
      t.sostituisci(t.getP1());
        
      t.getP2().setAttacca(true);
       
      t.getP1().setDifende(true);
      Personaggio primo;
      Personaggio secondo;
      primo=t.getP1();secondo=t.getP2();
      t.EseguiAbilità(secondo);
      if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(secondo);
        t.checkstatus(secondo);
        t.eseguiAttacco(secondo);
        if(!t.FineTurnoKo()){
          t.setFase(Fase.Post_azione);  
          t.EseguiAbilità(secondo);
          t.checkstatus(primo);
          t.checkstatus(secondo);
          
      }
      secondo.setAttacca(false);
      primo.setDifende(false);
      t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}



        
    }



    }
      public void esecuzione2(Turno t) {
        t.sostituisci(t.getP1());
        
       t.getP2().setAttacca(true);
        
        t.getP1().setDifende(true);
       
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
       else {primo=t.getP2();secondo=t.getP1();}
       this.AvviaEsecuzione(t, primo, secondo);
    


  
  
  }
  private void AvviaEsecuzione(Turno t, Personaggio primo, Personaggio secondo){
    
    t.EseguiAbilità(primo);
    t.EseguiAbilità(secondo);
    
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(t.getP2());
        t.eseguiAttacco(t.getP2());
        t.FineTurnoKo();
    }
    if(!t.FineTurnoKo()){
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
