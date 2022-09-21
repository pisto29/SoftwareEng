package Entity;

public class StrumentoCambio implements EsecuzioneTurno{
    public void esecuzione(Turno t){
        String primo;
        String secondo;
        primo="g1";secondo="g2";
        t.utilizzaStrumento(primo);
        t.sostituisci(secondo);
        
        t.EseguiAbilità(primo);
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);}
        if(!t.checkKo(secondo)){t.checkstatus(secondo);}
    }
    
   
}
