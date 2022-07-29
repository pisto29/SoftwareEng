package Entity;

public class StrumentoStrumento implements EsecuzioneTurno{

    public void esecuzione(Turno t) {
        t.utilizzaStrumentoP2();
        t.utilizzaStrumentoP1();
       if(t.checkVelocità()) this.p1(t);
        else this.p2(t);
    } 

    private void p1(Turno t){    
        t.EseguiAbilitàP1();
        t.EseguiAbilitàP2();
        t.FineTurnoKo();
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
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.checkStatusP2();
        if(!t.checkKoP1())t.checkStatusP1();    
    }
    
    
}
