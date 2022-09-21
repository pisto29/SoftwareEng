package Entity;

public class CambioStrumento implements EsecuzioneTurno{
//lo strumento blocca lo status per un turno il cambio evita che venga controllata l'abilità, lo strumento precede il cambio
public void esecuzione(Turno t){
     String primo;
    String secondo;
    primo="g1";secondo="g2";
    t.utilizzaStrumento(secondo);
    t.sostituisci(primo);
   
    t.EseguiAbilità(secondo);
    t.FineTurnoKo();
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);}

}
 
}
