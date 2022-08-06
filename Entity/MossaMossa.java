package Entity;



public class MossaMossa implements EsecuzioneTurno {
   // public ImplementatorManagerSingleton implementatorManager;
    public void esecuzione(Turno t){
       if( t.checkVelocità())this.P1(t);
       else this.P2(t);
    
        /*this.implementatorManager.setattaccante(t.getPersonaggi().get(0));
        this.implementatorManager.setDifensore(t.getPersonaggi().get(1));
        //prova
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        t.checkStatus(0);
        t.EseguiAttacco(0, 1);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione);
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione);
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        t.checkStatus(1);
        t.EseguiAttacco(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

       
        t.setFase(Fase.Fine_Turno);
       if(!t.checkKo(0)) t.EseguiAbilità(0, 1);
       if(!t.checkKo(1))t.EseguiAbilità(1, 0);
       if(!t.checkKo(0))t.checkStatus(0);
       if(!t.checkKo(1))t.checkStatus(1);
        





    }*/

}
private void P1(Turno t){
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
    t.FineTurnoKo();}
t.setFase(Fase.Fine_Turno);
if(!t.checkKoP1())t.EseguiAbilitàP1();
if(!t.checkKoP2())t.EseguiAbilitàP2();
if(!t.checkKoP1())t.checkStatusP1();
if(!t.checkKoP2())t.checkStatusP2();

}


private void P2(Turno t){
    ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP2());
    ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP1());
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
        t.checkStatusP2();
        t.checkStatusP1();
        t.FineTurnoKo();
    }
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
    t.FineTurnoKo();}
    t.setFase(Fase.Fine_Turno); 
    if(!t.checkKoP2())t.EseguiAbilitàP2();
    if(!t.checkKoP1())t.EseguiAbilitàP1();
    if(!t.checkKoP2())t.checkStatusP2();
    if(!t.checkKoP1())t.checkStatusP1();
    
    
    }



}
