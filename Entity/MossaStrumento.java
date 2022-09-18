package Entity;
//lo strumento viene usato prima della mossa entrambi usano abilità
public class MossaStrumento implements EsecuzioneTurno {

    //private ImplementatorManagerSingleton implementatorManagerSingleton;
    public void esecuzione(Turno t){
        t.utilizzaStrumento(t.getP2());
        t.getP1().setAttacca(true);
        t.getP2().setDifende(true);
        Personaggio primo;
        Personaggio secondo;
        primo=t.getP1();secondo=t.getP2();
       
        
        
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
        primo.setAttacca(false);
        secondo.setDifende(false);
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
        if(!t.checkKo(t.getP2())){t.EseguiAbilità(secondo);}

    }
    public void esecuzione2(Turno t) {
        
       
        t.utilizzaStrumento(t.getP2());
        //ImplementatorManagerSingleton.getIstanza().setattaccante(t.getP1());
        //ImplementatorManagerSingleton.getIstanza().setDifensore(t.getP2());
        t.getP1().setAttacca(true);
        t.getP2().setDifende(true);
        Personaggio primo;
        Personaggio secondo;
        if( t.checkVelocità()) {primo=t.getP1();secondo=t.getP2();
       
        }
        else {primo=t.getP2();secondo=t.getP1();}
        this.AvviaEsecuzione(t, primo, secondo);

       

        
    } 

 private void AvviaEsecuzione(Turno t, Personaggio primo, Personaggio secondo){
    t.EseguiAbilità(primo); //primo
        t.EseguiAbilità(secondo); //secondo
        
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Pre_azione); 
            t.EseguiAbilità(primo); //primo 
            t.EseguiAbilità(secondo); //secondo
            t.checkstatus(t.getP1());   //primo
            t.eseguiAttacco(t.getP1());
            t.FineTurnoKo();
        }
        if(!t.FineTurnoKo()){
            t.setFase(Fase.Post_azione); 
            t.EseguiAbilità(primo); //primo
            t.EseguiAbilità(secondo); //secondo
            t.checkstatus(t.getP1());   //primo
               
            t.FineTurnoKo();
        }
        primo.setAttacca(false);
        primo.setDifende(false);
        secondo.setAttacca(false);
        secondo.setDifende(false);
        t.setFase(Fase.Fine_Turno); //tutti primo secondo
        if(!t.checkKo(primo)){t.EseguiAbilità(primo);t.checkstatus(primo);}
    if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);t.checkstatus(secondo);}

 }
    
}
