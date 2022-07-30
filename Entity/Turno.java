package Entity;


import java.util.ArrayList;
import java.util.Random;

public class Turno {
    private int numturno;
    private Fase fase;
    private Personaggio p1;
    private Personaggio p2;
    private ArrayList <String> mosse;
    private ArrayList <Strumento> strumenti;
    private ArrayList <Personaggio> sostituzioni;
    private EsecuzioneTurno esecuzione;

    
    public Turno(int numturno, Fase fase) {
        this.numturno = numturno;
        this.fase = fase;
    }

  
    public void setMossaG1(String m){
        this.mosse.add(0, m);
    }
    public void setMossaG2(String m){
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


    public void esecuzione(){this.esecuzione.esecuzione(this);}
    public void EseguiAttaccoP1(){
       float danno=this.p1.Attacca(this.mosse.get(0));
       Mossa m1=null;
       for (Mossa m : this.p1.getMossas()) {
           if(m.getNomeMossa().equals(this.getMosse().get(0)))
           m1=m;
       }
        p2.Difendi(danno, m1);
        if(m1.CheckEffetto())m1.ApplicaEffettoMossa(this.p1,this.p2);
    }

    public void EseguiAttaccoP2(){
        float danno=this.p2.Attacca(this.mosse.get(1));
        Mossa m1=null;
        for (Mossa m : this.p1.getMossas()) {
            if(m.getNomeMossa().equals(this.getMosse().get(1)))
            m1=m;
        }
         p1.Difendi(danno, m1);
         if(m1.CheckEffetto())m1.ApplicaEffettoMossa(this.p2,this.p1);
     }


    public boolean checkVelocità(){
       if(p1.getVelocitàPersonaggio()>p2.getVelocitàPersonaggio()){
          return true;
       }
       else {
           if(p1.getVelocitàPersonaggio()==p2.getVelocitàPersonaggio()){
               Random r=new Random();
               if(r.nextInt(100)<50){
                return true;
               }
               else{
                return false;
               }
           }
           else{return false;}
       }
    }
    public void EseguiAbilitàP1(){

        if (this.fase == this.p1.getAbilità().getFase_attivazione())
        this.p1.getAbilità().Attivazione(this.p1,this.p2);


        
    }
    public void EseguiAbilitàP2(){

        if (this.fase == this.p2.getAbilità().getFase_attivazione())
        this.p2.getAbilità().Attivazione(this.p2,this.p1);


        
    }

    public void checkStatusP1(){
        this.p1.attivastatus(this.fase);
    }
    public void checkStatusP2(){
        this.p2.attivastatus(this.fase);
    }

    public Boolean checkKoP1(){
        
        if (p1.getpS() == 0)
            return true;
        else
            return false;
    }

    public Boolean checkKoP2(){
        
        if (p2.getpS() == 0)
            return true;
        else
            return false;
    }

    public void FineTurnoKo(){
        if( this.checkKoP1()||this.checkKoP2())this.setFase(Fase.Fine_Turno);
        }

    public void sostituiscip1(){
        p1.Sostituzione();
        this.p1=this.sostituzioni.get(0);
        this.p1.Sostituzione();
    }

    public void sostituiscip2(){
        p2.Sostituzione();
        this.p2=this.sostituzioni.get(1);
        this.p2.Sostituzione();
    }
  /*Array eliminati
    private void arraySwap(){
        Collections.swap(this.Personaggi, 0, 1);
        Collections.swap(this.mosse, 0, 1);
      
    }*/



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



  



    public ArrayList<String> getMosse() {
        return mosse;
    }



    public void setMosse(ArrayList<String> mosse) {
        this.mosse = mosse;
    }



    public ArrayList<Strumento> getStrumenti() {
        return strumenti;
    }



    public void setStrumenti(ArrayList<Strumento> strumenti) {
        this.strumenti = strumenti;
    }



    public ArrayList<Personaggio> getSostituzioni() {
        return sostituzioni;
    }



    public void setSostituzioni(ArrayList<Personaggio> sostituzioni) {
        this.sostituzioni = sostituzioni;
    }



    public EsecuzioneTurno getEsecuzione() {
        return esecuzione;
    }



    public void setEsecuzione(EsecuzioneTurno esecuzione) {
        this.esecuzione = esecuzione;
    }


    public Personaggio getP1() {
        return p1;
    }


    public void setP1(Personaggio p1) {
        this.p1 = p1;
    }


    public Personaggio getP2() {
        return p2;
    }


    public void setP2(Personaggio p2) {
        this.p2 = p2;
    }
  
    public void utilizzaStrumentoP1(){
        this.getStrumenti().get(0).UtilizzaStrumento(this.p1);
    }

    public void utilizzaStrumentoP2(){
        this.getStrumenti().get(0).UtilizzaStrumento(this.p2);
    }

}
