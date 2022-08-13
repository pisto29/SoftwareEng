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
       
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP1());
       
  
      t.EseguiAbilità(t.getP2());
      t.EseguiAbilità(t.getP1());
      t.FineTurnoKo();
      if(!t.getFase().equals(Fase.Fine_Turno)){
          t.setFase(Fase.Pre_azione); 
          t.EseguiAbilità(t.getP2());
          t.EseguiAbilità(t.getP1());
          t.checkstatus(t.getP2());
          t.eseguiAttacco(t.getP2());
          t.FineTurnoKo();
      }
      if(!t.getFase().equals(Fase.Fine_Turno)){
          t.setFase(Fase.Post_azione); 
          t.EseguiAbilità(t.getP2());
          t.EseguiAbilità(t.getP1());
          t.checkstatus(t.getP2());
          t.checkstatus(t.getP1());
          t.FineTurnoKo();
      }
      t.setFase(Fase.Fine_Turno);
      if(!t.checkKo(t.getP2()))t.EseguiAbilità(t.getP2());
      if(!t.checkKo(t.getP1()))t.EseguiAbilità(t.getP1());
      if(!t.checkKo(t.getP2())){t.checkstatus(t.getP2());}
      if(!t.checkKo(t.getP1()))t.checkstatus(t.getP1());
  
  }
}
