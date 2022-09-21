package Entity;
// il cambio avviene prima della mossa e nega l'utilizzo dell'abilità
public class MossaCambio implements EsecuzioneTurno {
    public void esecuzione(Turno t){
        String primo;
        String secondo;
        primo="g1";secondo="g2";
        t.sostituisci(secondo);
        
        t.setAttacca(primo,true);
        t.setDifende(secondo,true);
        t.EseguiAbilità(primo);
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilità(primo);
            
            t.checkstatus(primo);
            t.eseguiAttacco(primo);
            
        }
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilità(primo);
            
            t.checkstatus(primo);
            t.checkstatus(secondo);}
            t.setAttacca(primo,false);
  
  
        t.setDifende(secondo,false);
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
        if(!t.checkKo(secondo)){t.checkstatus(secondo);}
            
            

    }
 

}
