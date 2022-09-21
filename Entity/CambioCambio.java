package Entity;
// A seguito di un cambio le abilità non vengono attivate per il resto del turno ma viene solo verificata la presenza di status
public class CambioCambio implements EsecuzioneTurno{
    public void esecuzione (Turno t){
        t.sostituisci("g1");
        t.sostituisci("g2");
        String primo;
        String secondo;
        t.setFase(Fase.Fine_Turno);
        primo="g1";secondo="g2";
        t.checkstatus(primo);
        t.checkstatus(secondo);
    }
   
}
