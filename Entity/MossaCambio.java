package Entity;

public class MossaCambio implements EsecuzioneTurno {
    //public ImplementatorManagerSingleton implementatorManager;
    @Override
    public void esecuzione(Turno t) {
      t.sostituisci(t.getP2());
      ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
      ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());

    t.EseguiAbilità(t.getP1());
    t.EseguiAbilità(t.getP2());
    t.FineTurnoKo();
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(t.getP1());
        t.EseguiAbilità(t.getP2());
        t.checkstatus(t.getP1());
        t.eseguiAttacco(t.getP1());
        t.FineTurnoKo();
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(t.getP1());
        t.EseguiAbilità(t.getP2());
        t.checkstatus(t.getP1());
        t.checkstatus(t.getP2());
        t.FineTurnoKo();
    }
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(t.getP1()))t.EseguiAbilità(t.getP1());
    if(!t.checkKo(t.getP2()))t.EseguiAbilità(t.getP2());
    if(!t.checkKo(t.getP1())){t.checkstatus(t.getP1());}
    if(!t.checkKo(t.getP2()))t.checkstatus(t.getP2());

}
  
}
