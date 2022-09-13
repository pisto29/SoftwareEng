package Entity;

public class CambioStrumento implements EsecuzioneTurno{

    public void esecuzione(Turno t) {
        
        
        
        t.utilizzaStrumento(t.getP2());
        t.sostituisci(t.getP1());
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
        else {primo=t.getP2();secondo=t.getP1();}
        this.P(t, primo, secondo);

    } 

   
    private void P(Turno t, Personaggio primo, Personaggio secondo){
        primo.setAttacca(false);
  primo.setDifende(false);
  secondo.setAttacca(false);
  secondo.setDifende(false);
        t.EseguiAbilità(primo);
        t.EseguiAbilità(secondo);
        t.FineTurnoKo();
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo))t.EseguiAbilità(primo);
        if(!t.checkKo(secondo))t.EseguiAbilità(secondo);
        if(!t.checkKo(primo))t.checkstatus(primo);
        if(!t.checkKo(secondo))t.checkstatus(secondo);
    }







}
