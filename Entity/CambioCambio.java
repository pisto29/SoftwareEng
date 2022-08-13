package Entity;

public class CambioCambio implements EsecuzioneTurno{
    public void esecuzione(Turno t) {
        t.sostituisci(t.getP1());
        t.sostituisci(t.getP2());
        Personaggio primo;
        Personaggio secondo;
       if(t.checkVelocità()){ primo=t.getP1();secondo=t.getP2();}
        else { primo=t.getP2();secondo=t.getP1();}
        this.p(t, primo, secondo);

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

    private void P2(Turno t){
        t.EseguiAbilitàP2();
        t.EseguiAbilitàP1();
        t.FineTurnoKo();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.checkStatusP2();
        if(!t.checkKoP1())t.checkStatusP1();
    }
    private void p(Turno t, Personaggio primo, Personaggio secondo){
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.FineTurnoKo();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo))t.EseguiAbilità(primo);
        if(!t.checkKo(secondo))t.EseguiAbilità(secondo);
        if(!t.checkKo(primo)){t.checkstatus(primo);}
        if(!t.checkKo(secondo))t.checkstatus(secondo);
    }
}
