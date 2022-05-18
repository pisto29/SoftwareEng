package Entity;

import javax.lang.model.util.ElementScanner14;

public class MossaMossa implements EsecuzioneTurno {
    
    public void esecuzione(Turno t){
        t.checkVelocità();
        
        if(t.checkAbilità(t.getPersonaggi().get(0)))
            t.getPersonaggi().get(0).getAbilità().Attivazione(t.getPersonaggi().get(0), t.getPersonaggi().get(1));
        
        if (t.checkAbilità(t.getPersonaggi().get(1)))
             t.getPersonaggi().get(1).getAbilità().Attivazione(t.getPersonaggi().get(1), t.getPersonaggi().get(0));
       
        t.setFase(Fase.Pre_azione);

        if(t.checkAbilità(t.getPersonaggi().get(0)))
             t.getPersonaggi().get(0).getAbilità().Attivazione(t.getPersonaggi().get(0), t.getPersonaggi().get(1));
    
        if (t.checkAbilità(t.getPersonaggi().get(1)))
             t.getPersonaggi().get(1).getAbilità().Attivazione(t.getPersonaggi().get(1), t.getPersonaggi().get(0));

        t.getPersonaggi().get(0).Attacca(t.getMosse().get(0).getNomeMossa(), t.getPersonaggi().get(1));
        t.checkKo(t.getPersonaggi().get(1));
        t.checkKo(t.getPersonaggi().get(0));
        t.getPersonaggi().get(1).Attacca(t.getMosse().get(1).getNomeMossa(), t.getPersonaggi().get(0));
        t.checkKo(t.getPersonaggi().get(0));
        t.checkKo(t.getPersonaggi().get(1));

        t.setFase(Fase.Post_azione);

        if(t.checkAbilità(t.getPersonaggi().get(0)))
             t.getPersonaggi().get(0).getAbilità().Attivazione(t.getPersonaggi().get(0), t.getPersonaggi().get(1));
    
        if (t.checkAbilità(t.getPersonaggi().get(1)))
             t.getPersonaggi().get(1).getAbilità().Attivazione(t.getPersonaggi().get(1), t.getPersonaggi().get(0));

        t.setFase(Fase.Fine_Turno);
        
        if(t.checkAbilità(t.getPersonaggi().get(0)))
             t.getPersonaggi().get(0).getAbilità().Attivazione(t.getPersonaggi().get(0), t.getPersonaggi().get(1));
    
        if (t.checkAbilità(t.getPersonaggi().get(1)))
             t.getPersonaggi().get(1).getAbilità().Attivazione(t.getPersonaggi().get(1), t.getPersonaggi().get(0));
    





    }
}
