package Entity;
//lo strumento viene usato prima della mossa entrambi usano abilità
public class MossaStrumento implements EsecuzioneTurno {

    //private ImplementatorManagerSingleton implementatorManagerSingleton;
    public void esecuzione(Turno t){ 
        String primo;
        String secondo;
        primo="g1";secondo="g2";
        t.utilizzaStrumento(secondo);
        t.setAttacca(primo,true);
        t.setDifende(secondo,true);
       
       
        
        
        t.EseguiAbilità(primo); //primo
        t.EseguiAbilità(secondo);
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilità(primo); //primo 
            t.EseguiAbilità(secondo); //secondo
            t.checkstatus(primo);   //primo
            t.eseguiAttacco(secondo);
            
        }
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilità(primo); //primo
            t.EseguiAbilità(secondo); //secondo
            t.checkstatus(primo);   //primo
               
            
        }
        t.setAttacca(primo,false);
        t.setDifende(secondo,false);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
        if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);}

    }
   
}
