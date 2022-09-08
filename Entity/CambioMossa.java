package Entity;

public class CambioMossa implements EsecuzioneTurno{
    //public ImplementatorManagerSingleton implementatorManager;
 /*    public void esecuzione(Turno t) {
        t.sostituisciP2getP2();
        ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
  
  t.EseguiAbilitàP1getP1();
  t.EseguiAbilitàP2getP2();
  t.FineTurnoKo();
  if(!t.getFase().equals(Fase.Fine_Turno)){
      t.setFase(Fase.Pre_azione); 
      t.EseguiAbilitàP1getP1();
      t.EseguiAbilitàP2getP2();
      t.checkStatusP1getP1();
      t.EseguiAttaccoP1getP1();
      t.FineTurnoKo();
  }
  if(!t.getFase().equals(Fase.Fine_Turno)){
      t.setFase(Fase.Post_azione); 
      t.EseguiAbilitàP1getP1();
      t.EseguiAbilitàP2getP2();
      t.checkStatusP1getP1();
      t.checkStatusP2getP2();
      t.FineTurnoKo();
  }
  t.setFase(Fase.Fine_Turno);
  if(!t.checkKoP1getP1())t.EseguiAbilitàP1getP1();
  if(!t.checkKoP2getP2())t.EseguiAbilitàP2getP2();
  if(!t.checkKoP1getP1())t.checkStatusP1getP1();
  if(!t.checkKoP2getP2())t.checkStatusP2getP2();
      }*/
    
      public void esecuzione(Turno t) {
        t.sostituisci(t.getP1());
        ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP2());
       t.getP2().setAttacca(true);
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP1());
        t.getP1().setDifende(true);
       
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
       else {primo=t.getP2();secondo=t.getP1();}
       //this.P(t, primo, secondo);
    


  
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
      if(!t.checkKo(primo))t.EseguiAbilità(primo);
      if(!t.checkKo(secondo))t.EseguiAbilità(secondo);
      if(!t.checkKo(primo)){t.checkstatus(primo);}
      if(!t.checkKo(secondo))t.checkstatus(secondo);
  
  }
}
