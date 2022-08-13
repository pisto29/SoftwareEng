package Entity;



public class MossaMossa implements EsecuzioneTurno {

   // public ImplementatorManagerSingleton implementatorManager;
    public void esecuzione(Turno t){
        Personaggio primo;
        Personaggio secondo;
       if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
       else {primo=t.getP2();secondo=t.getP1();}
       this.P(t, primo, secondo);
    
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
/*private void P1(Turno t){
    //System.out.println("si sta eseguendo p1 di mossamossa");
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
    t.eseguiAttacco(t.getP1());
    t.FineTurnoKo();
   
}
if(!t.getFase().equals(Fase.Fine_Turno)){
    t.setFase(Fase.Post_azione); 
    t.EseguiAbilitàP1();
    t.EseguiAbilitàP2();
    t.checkStatusP1();
    t.checkStatusP2();
    t.FineTurnoKo();
    ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP2());
    ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP1());
}
if(!t.getFase().equals(Fase.Fine_Turno)){
    t.setFase(Fase.Pre_azione); 
    t.EseguiAbilitàP1();
    t.EseguiAbilitàP2();
    t.checkStatusP2();
    t.eseguiAttacco(t.getP2());
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
if(!t.checkKoP1()){t.checkStatusP1();
   
}
if(!t.checkKoP2())t.checkStatusP2();

}*/



private void P2(Turno t){
    //System.out.println("si sta eseguendo p2 di mossamossa");
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
        t.eseguiAttacco(t.getP2());
        t.FineTurnoKo();
    
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilitàP2();
        t.EseguiAbilitàP1();
        t.checkStatusP2();
        t.checkStatusP1();
        t.FineTurnoKo();
        ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
        ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilitàP2();
        t.EseguiAbilitàP1();
        t.checkStatusP1();
        t.eseguiAttacco(t.getP1());
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
    if(!t.checkKoP1()){
       
        t.checkStatusP1();}
    
    
    }

    private void P(Turno t,Personaggio primo, Personaggio secondo){
        //System.out.println("si sta eseguendo p1 di mossamossa");
    ImplementatorManagerSingleton.getIstanza().setattaccante(primo);
    System.out.println(primo.getNomePersonaggio()+" "+primo.getRuolo().getImplementator());
    ImplementatorManagerSingleton.getIstanza().setDifensore(secondo);
    System.out.println(secondo.getNomePersonaggio()+" "+secondo.getRuolo().getImplementator());
    t.EseguiAbilità(primo);
    t.EseguiAbilità(secondo);
    t.FineTurnoKo();
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.eseguiAttacco(primo);
        t.FineTurnoKo();
       
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.checkstatus(secondo);
        t.FineTurnoKo();
        ImplementatorManagerSingleton.getIstanza().setattaccante(secondo);
        System.out.println(secondo.getNomePersonaggio()+" "+secondo.getRuolo().getImplementator());
        ImplementatorManagerSingleton.getIstanza().setDifensore(primo);
        System.out.println(primo.getNomePersonaggio()+" "+primo.getRuolo().getImplementator());
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(secondo);
        t.eseguiAttacco(secondo);
        t.FineTurnoKo();
    }
    if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.checkstatus(secondo);
        t.FineTurnoKo();}
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo))t.EseguiAbilità(primo);
    if(!t.checkKo(secondo))t.EseguiAbilità(secondo);
    if(!t.checkKo(primo)){t.checkstatus(primo);}
    if(!t.checkKo(secondo))t.checkstatus(secondo);
    
    }

}
