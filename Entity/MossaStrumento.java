package Entity;

public class MossaStrumento implements EsecuzioneTurno {

    //private ImplementatorManagerSingleton implementatorManagerSingleton;

    public void esecuzione(Turno t) {
        t.utilizzaStrumentoP2();
        ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
       if(t.checkVelocità()) this.p1(t);
        else this.p2(t);
    } 

    private void p1(Turno t){    
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

    private void p2(Turno t){    
        t.EseguiAbilitàP2();
        t.EseguiAbilitàP1();
        t.FineTurnoKo();
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilitàP2();
            t.EseguiAbilitàP1();
            t.checkStatusP1();
            t.EseguiAttaccoP1();
            t.FineTurnoKo();
        }
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilitàP2();
            t.EseguiAbilitàP1();
            t.checkStatusP2();
            t.checkStatusP1();
            t.FineTurnoKo();
        }
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.checkStatusP2();
        if(!t.checkKoP1())t.checkStatusP1();    
    }
    
}
