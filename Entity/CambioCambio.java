package Entity;

public class CambioCambio implements EsecuzioneTurno{
    public void esecuzione(Turno t) {
        t.sostituisci(t.getP1());
        t.sostituisci(t.getP2());
        Personaggio primo;
        Personaggio secondo;
       if(t.checkVelocità()){ primo=t.getP1();secondo=t.getP2();}
        else { primo=t.getP2();secondo=t.getP1();}
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
