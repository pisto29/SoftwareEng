package Entity;

public class MossaCambio implements EsecuzioneTurno {
    //public ImplementatorManagerSingleton implementatorManager;
   /*  @Override
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

}*/
public void esecuzione(Turno t) {
    t.sostituisci(t.getP2());
   // ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
   t.getP1().setAttacca(true);
   // ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
   t.getP2().setDifende(true);
   
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
      t.checkstatus(t.getP1());
      t.eseguiAttacco(t.getP1());
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
