package Entity;

public class CambioStrumento implements EsecuzioneTurno{
//lo strumento blocca lo status per un turno il cambio evita che venga controllata l'abilità, lo strumento precede il cambio
public void esecuzione(Turno t){
    t.utilizzaStrumento(t.getP2());
    t.sostituisci(t.getP1());
    Personaggio primo;
    Personaggio secondo;
    primo=t.getP1();secondo=t.getP2();
    t.EseguiAbilità(secondo);
    t.FineTurnoKo();
    t.setFase(Fase.Fine_Turno);
    if(!t.checkKo(primo)){t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);}

}
    public void esecuzione2(Turno t) {
        
        
        
        t.utilizzaStrumento(t.getP2());
        t.sostituisci(t.getP1());
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
        else {primo=t.getP2();secondo=t.getP1();}
        this.AvviaEsecuzione(t, primo, secondo);

    } 

   
    private void AvviaEsecuzione(Turno t, Personaggio primo, Personaggio secondo){
        primo.setAttacca(false);
  primo.setDifende(false);
  secondo.setAttacca(false);
  secondo.setDifende(false);
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.FineTurnoKo();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
        if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}
    }







}
