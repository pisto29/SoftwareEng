package Entity;



public class MossaMossa implements EsecuzioneTurno {

 
    public void esecuzione(Turno t){
        Personaggio primo;
        Personaggio secondo;
       if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
       else {primo=t.getP2();secondo=t.getP1();}
      
    
 

   primo.setAttacca(true);
   
 
secondo.setDifende(true);


    t.EseguiAbilità(primo);
    t.EseguiAbilità(secondo);
   
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.eseguiAttacco(primo);
      
       
    }
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.checkstatus(secondo);
       
      
        primo.setAttacca(false);
        
        secondo.setDifende(false);
        secondo.setAttacca(true);
        
        primo.setDifende(true);
    }
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(secondo);
        t.eseguiAttacco(secondo);
        
    }
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.checkstatus(primo);
        t.checkstatus(secondo);
        }
        secondo.setAttacca(false);
        primo.setDifende(false);
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}
    
    }

}
