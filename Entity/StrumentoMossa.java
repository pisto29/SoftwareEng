package Entity;

public class StrumentoMossa implements EsecuzioneTurno {
    //private ImplementatorManagerSingleton implementatorManager;

    public void esecuzione(Turno t) {
        
        
        ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP2());
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP1());
        t.utilizzaStrumento(t.getP1());
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
        else {primo=t.getP2();secondo=t.getP1();}
        this.P(t, primo, secondo);
        
    } 

    private void p1(Turno t){    
        t.EseguiAbilitàP1();
        t.EseguiAbilitàP2();
        t.FineTurnoKo();
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilitàP1();
            t.EseguiAbilitàP2();
            t.checkStatusP2();
            t.EseguiAttaccoP2();
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
            t.checkStatusP2();
            t.EseguiAttaccoP2();
            t.FineTurnoKo();
        }
        if(!t.getFase().equals(Fase.Fine_Turno)){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilitàP2();
            t.EseguiAbilitàP1();
            t.checkStatusP1();
            t.checkStatusP2();
            t.FineTurnoKo();
        }
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKoP2())t.EseguiAbilitàP2();
        if(!t.checkKoP1())t.EseguiAbilitàP1();
        if(!t.checkKoP2())t.checkStatusP2();
        if(!t.checkKoP1())t.checkStatusP1();    
    }

    private void P(Turno t, Personaggio primo, Personaggio secondo){    
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
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo))t.EseguiAbilità(primo);
        if(!t.checkKo(secondo))t.EseguiAbilità(secondo);
        if(!t.checkKo(primo))t.checkstatus(primo);
        if(!t.checkKo(secondo))t.checkstatus(secondo);    
    }
}
