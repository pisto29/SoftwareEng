package Entity;

public class MossaCambio implements EsecuzioneTurno {

    @Override
    public void esecuzione(Turno t) {
       t.getPersonaggi().get(1).Sostituzione();
       t.getSostituzioni().get(1).Sostituzione();
       t.getPersonaggi().add(1, t.getSostituzioni().get(1)); 
       this.setImplementators(t);
       t.checkVelocità();
    }
  
}
