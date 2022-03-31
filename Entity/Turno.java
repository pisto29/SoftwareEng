package Entity;

public class Turno {
    private int numturno;
    private Fase fase;

    
    public Turno(int numturno, Fase fase) {
        this.numturno = numturno;
        this.fase = fase;
    }


    public int getNumturno() {
        return numturno;
    }


    public void setNumturno(int numturno) {
        this.numturno = numturno;
    }


    public Fase getFase() {
        return fase;
    }


    public void setFase(Fase fase) {
        this.fase = fase;
    }

    private int CalcolaAttacco(Personaggio p1,Personaggio p2, Mossa m){
        int D;
        int mod;
        float eff1 = m.getTipo().getEfficacia(p2.getTipos()[0]);
        float eff2 = m.getTipo().getEfficacia(p2.getTipos()[1]);
        
    
        if(m.isCritico() == true) 
            mod = 2;
        else
            mod = 1;
        
        mod =  mod * (int) eff1 * (int) eff2;
        //COMPLETARE CALCOLO MOD
        if(m.getTipologia()==Tipologia.Fisico)
            D = (22*m.getDanno()*p1.getAttaccoPersonaggio())/50*p2.getDifesaPersonaggio();
            D = D + 2;
            D = D * mod;

        return D;
    }
    
    public void EseguiAttacco(Personaggio p, Mossa m){

    }


}
