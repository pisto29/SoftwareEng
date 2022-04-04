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

//------------------------------------------------------------------------------------------------------------------------------
    
    private int CalcolaAttacco(Personaggio p1,Personaggio p2, Mossa m){
        
        float danno;
        float attacco;
        float difesa;

        if(m.getTipologia() == Tipologia.Fisico){

            attacco = p1.getAttaccoPersonaggio();
            difesa = p2.getDifesaPersonaggio();
        }
        else{

            attacco = p1.getAttaccoSpecialePersonaggio();
            difesa = p2.getDifesaSpecialePersonaggio();

        }

        danno = (22 * m.getDanno() * attacco / (50 * difesa)) + 2;
        danno = danno * this.CalcoloModificatore(m, p1, p2);
        
        return (int) danno;
    }

    private float CalcoloModificatore(Mossa m, Personaggio p1, Personaggio p2){

        float modificatore = 1;
        float efficacia = m.getTipo().getEfficacia(p2.getTipos()[0]) * m.getTipo().getEfficacia(p2.getTipos()[1]) ;
        
        if(m.isCritico()) 
            modificatore = modificatore * 2f;
        
        if(IsStab(m, p1))
            modificatore = modificatore * 1.33f;
        
        modificatore = modificatore * efficacia;

        return modificatore;
    }
    

    private boolean IsStab(Mossa m, Personaggio p1){
        boolean stab = false;
        for(int i = 0 ; i < 2 ; i++){
            if(m.getTipo() == p1.getTipos()[i])
             stab = true; 
        }
  
        return stab;
    }




    public void EseguiAttacco(Personaggio p, Mossa m){

    }

SS
}
