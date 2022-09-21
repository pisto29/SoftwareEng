package Entity;



public class MossaMossa implements EsecuzioneTurno {

 
    public void esecuzione(Turno t){

        String primo;
        String secondo;
       if( t.checkVelocità()) {primo="g1";secondo="g2";}
       else {primo="g2";secondo="g1";}
      
    
 t.setAttacca(primo,true);
 t.setDifende(secondo,true);




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
       
      
    }
    t.setAttacca(primo,false);
    t.setDifende(secondo,false);
    t.setAttacca(secondo,true);
    t.setDifende(primo,true);
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
    t.setAttacca(secondo,false);
    t.setDifende(primo,false);
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}
    
    }

}
