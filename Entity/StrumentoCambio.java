package Entity;

public class StrumentoCambio implements EsecuzioneTurno{
    
    public void esecuzione(Turno t) {
        t.sostituiscip1();
       if(t.checkVelocità()) this.p1(t);
        else this.P2(t);

    } 

    private void p1(Turno t){
        t.EseguiAbilitàP1();
        t.EseguiAbilitàP2();
        t.FineTurnoKo();
        t.utilizzaStrumentoP1();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.checkStatusP1();
        if(!t.checkKoP2())t.checkStatusP2();
    }

    private void P2(Turno t){
        t.EseguiAbilitàP2();
        t.EseguiAbilitàP1();
        t.FineTurnoKo();
        t.utilizzaStrumentoP2();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.checkStatusP2();
        if(!t.checkKoP1())t.checkStatusP1();
    }
}
