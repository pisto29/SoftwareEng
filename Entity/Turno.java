package Entity;

import java.util.ArrayList;

public class Turno {
    private int numturno;
    private Fase fase;
    private ArrayList <Personaggio> Personaggi;
    private ArrayList <Mossa> mosse;
    private ArrayList <Strumento> strumenti;
    private ArrayList <Personaggio> sostituzioni;
    private EsecuzioneTurno esecuzione;

    
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
    public void setMossaG1(Mossa m){
        this.mosse.add(0, m);
    }
    public void setMossaG2(Mossa m){
        this.mosse.add(1, m);
    }
    public void setSostituzioneg1(Personaggio p){
        this.sostituzioni.add(0, p);
    }
    public void setSostituzioneg2(Personaggio p){
        this.sostituzioni.add(1, p);
    }
    public void setStrumentoG1(Strumento s){
        this.strumenti.add(0, s);
    }
    public void setStrumentoG2(Strumento s){
        this.strumenti.add(1, s);
    }
//------------------------------------------------------------------------------------------------------------------------------
    
    /*private int CalcolaAttacco(Personaggio p1,Personaggio p2, Mossa m){
        
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
        
        if(m.CheckCritico()) 
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
      */



    public void EseguiAttacco(Personaggio p, Mossa m){

    }
    public void checkVelocità(){}
    public void checkAbilità(){}
    public void checkKo(){}
    private void arraySwap(){
      
    }
    private void swap(ArrayList a) throws ClassNotFoundException{
      String s=a.get(0).getClass().getName();
      Class c= Class.forName(s);
      //c=c.newInstance();

    }
}
