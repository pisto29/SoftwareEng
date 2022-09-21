package Entity;

public class StrumentoMossa implements EsecuzioneTurno {
    //private ImplementatorManagerSingleton implementatorManager;
public void esecuzione(Turno t){
    String primo;
    String secondo;
    primo="g1";secondo="g2";
    t.utilizzaStrumento(primo);
   t.setAttacca(secondo,true);
   t.setDifende(primo,true);
   t.EseguiAbilità(secondo);
    t.EseguiAbilità(primo);
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Pre_azione);
        t.EseguiAbilità(secondo);
        t.EseguiAbilità(primo);
        t.checkstatus(secondo);
        t.eseguiAttacco(secondo);
    }
    if(!t.FineTurnoKo()){
        t.setFase(Fase.Post_azione); 
        t.EseguiAbilità(secondo);
        t.EseguiAbilità(primo);
        t.checkstatus(secondo);
    }
    t.setAttacca(secondo,false);
    t.setDifende(primo,false);

if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}
    if(!t.checkKo(primo)){t.EseguiAbilità(primo);}

   


}
  
}
