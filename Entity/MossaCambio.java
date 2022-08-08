package Entity;

public class MossaCambio implements EsecuzioneTurno {
    //public ImplementatorManagerSingleton implementatorManager;
    @Override
    public void esecuzione(Turno t) {
      t.sostituiscip2();
      ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
      ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());

    t.EseguiAbilitàP1();
    t.EseguiAbilitàP2();
    t.FineTurnoKo();
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilitàP1();
        t.EseguiAbilitàP2();
        t.checkStatusP1();
        t.EseguiAttaccoP1();
        t.FineTurnoKo();
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilitàP1();
        t.EseguiAbilitàP2();
        t.checkStatusP1();
        t.checkStatusP2();
        t.FineTurnoKo();
    }
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKoP1())t.EseguiAbilitàP1();
    if(!t.checkKoP2())t.EseguiAbilitàP2();
    if(!t.checkKoP1())t.checkStatusP1();
    if(!t.checkKoP2())t.checkStatusP2();

}
  
}
