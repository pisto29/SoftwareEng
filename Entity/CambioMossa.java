package Entity;

public class CambioMossa implements EsecuzioneTurno{
 
    //Verranno attivate solo le abilità del giocatore due e la sostituzione precede la mossa
    public void esecuzione (Turno t){
      String primo;
      String secondo;
      primo="g1";secondo="g2";
      t.sostituisci(primo);
        
      t.setAttacca(secondo,true);
       
      t.setDifende(primo,true);
      
      t.EseguiAbilità(secondo);
      if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(secondo);
        t.checkstatus(secondo);
        t.eseguiAttacco(secondo);
        if(!t.FineTurnoKo()){
          t.setFase(Fase.Post_azione);  
          t.EseguiAbilità(secondo);
          t.checkstatus(primo);
          t.checkstatus(secondo);
          
      }
      t.setAttacca(secondo,false);
      t.setDifende(primo,false);
      t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}



        
    }



    }
     
}
