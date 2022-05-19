package Entity;



public class MossaMossa implements EsecuzioneTurno {
    
    public void esecuzione(Turno t){
        t.checkVelocità();
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione); 
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        t.checkStatus(0);
        t.EseguiAttacco(0, 1);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Post_azione);
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

        if(!t.getFase().equals(Fase.Fine_Turno)){
        t.setFase(Fase.Pre_azione);
        t.EseguiAbilità(0, 1);
        t.EseguiAbilità(1, 0);
        t.checkStatus(1);
        t.EseguiAttacco(1, 0);
        if(t.checkKo(0)||t.checkKo(1))t.setFase(Fase.Fine_Turno);
        }

       
        t.setFase(Fase.Fine_Turno);
       if(!t.checkKo(0)) t.EseguiAbilità(0, 1);
       if(!t.checkKo(1))t.EseguiAbilità(1, 0);
       if(!t.checkKo(0))t.checkStatus(0);
       if(!t.checkKo(1))t.checkStatus(1);
        





    }
}
