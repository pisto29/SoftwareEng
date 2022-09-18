package Entity;
// il cambio avviene prima della mossa e nega l'utilizzo dell'abilità
public class MossaCambio implements EsecuzioneTurno {
    public void esecuzione(Turno t){
        t.sostituisci(t.getP2());
        Personaggio primo;
        Personaggio secondo;
        primo=t.getP1();secondo=t.getP2();
        primo.setAttacca(true);
        secondo.setDifende(true);
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
            primo.setAttacca(false);
  
  
        secondo.setDifende(false);
        t.setFase(Fase.Fine_Turno);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
        if(!t.checkKo(secondo)){t.checkstatus(secondo);}
            
            

    }
 
public void esecuzione2(Turno t) {
    t.sostituisci(t.getP2());
   // ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
   t.getP1().setAttacca(true);
   // ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
   t.getP2().setDifende(true);
   
    Personaggio primo;
    Personaggio secondo;
    if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();}
   else {primo=t.getP2();secondo=t.getP1();}
    this.AvviaEsecuzione(t, primo, secondo);}



private void AvviaEsecuzione(Turno t, Personaggio primo, Personaggio secondo){
  t.EseguiAbilità(primo);
  t.EseguiAbilità(secondo);
  
  if(!t.FineTurnoKo()){
      t.setFase(Fase.Pre_azione); 
      t.EseguiAbilità(primo);
      t.EseguiAbilità(secondo);
      t.checkstatus(t.getP1());
      t.eseguiAttacco(t.getP1());
      
  }
  if(!t.FineTurnoKo()){
      t.setFase(Fase.Post_azione); 
      t.EseguiAbilità(primo);
      t.EseguiAbilità(secondo);
      t.checkstatus(primo);
      t.checkstatus(secondo);
      
      
  }
  primo.setAttacca(false);
  primo.setDifende(false);
  secondo.setAttacca(false);
  secondo.setDifende(false);
  t.setFase(Fase.Fine_Turno);
  if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}

}
  
}
