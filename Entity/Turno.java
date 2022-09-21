package Entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Turno {
    private int numturno;
    private Fase fase;
    private Personaggio p1;
    private Personaggio p2;
    private ArrayList <String> mosse;
    private ArrayList <String> strumenti;
    private ArrayList <Personaggio> sostituzioni;
    private EsecuzioneTurno esecuzione;

    
    public Turno(int numturno, Fase fase) {
        this.numturno = numturno;
        this.fase = fase;
        this.mosse = new ArrayList<>();
        this.strumenti = new ArrayList<>();
        this.sostituzioni = new ArrayList<>();
    }

  public boolean checkCompletezza(){
    if(this.getMosse().size()+this.getSostituzioni().size()+this.getStrumenti().size()==6)return true;
    else return false;

  }
    public void setMossaG1(String m){
        this.mosse.add(0, m);
    }
    public void setMossaG2(String m){
        //if(this.mosse.isEmpty())
           // this.mosse.add(0,null);
        this.mosse.add(1, m);
        
    }
    public void setSostituzioneg1(Personaggio p){
        this.sostituzioni.add(0, p);
    }
    public void setSostituzioneg2(Personaggio p){
        this.sostituzioni.add(1, p);
    }
    public void setStrumentoG1(String s){
        this.strumenti.add(0, s);
    }
    public void setStrumentoG2(String  s){
        this.strumenti.add(1, s);
    }



    public void esecuzione(){this.esecuzione.esecuzione(this);}
    
    public void eseguiAttacco(String  p){
       
        int index=0;
        Personaggio attaccante=null;
        Personaggio difensore=null;
        if(p.equals("g1")){index=0; attaccante=p1; difensore=this.p2;}
        else {index=1;attaccante=p2; difensore=this.p1;}
        if(attaccante.puoattaccare()) {
            System.out.println("attacca  "+attaccante.getNomePersonaggio()+" usa "+this.mosse.get(index));
            
            float danno=attaccante.EseguiAttacco(this.mosse.get(index));
            Mossa m1=attaccante.GetMossa(this.mosse.get(index));
           
            boolean colpito= difensore.Difendi(danno, m1);
            difensore.VaiKo();
            
             if(colpito)m1.ApplicaEffettoMossa(attaccante,difensore);}
             else{System.out.println(attaccante.getNomePersonaggio()+" non puo attaccare");
            attaccante.AbiltaAttacco();}

    }

    public boolean checkVelocità(){
       if(p1.getVelocitaAttuale()>p2.getVelocitaAttuale()){
          return true;
       }
       else {
           if(p1.getVelocitaAttuale()==p2.getVelocitaAttuale()){
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

    public void EseguiAbilità(String p){
        Personaggio bersaglio=this.p2;
        Personaggio utilizzatore=this.p1;
        if(p.equals("g1")){
            utilizzatore=p1;
            bersaglio=p2;

        }
        if(p.equals("g2")){
            utilizzatore=p2;
            bersaglio=this.p1;
        }
       /*  if (this.fase == p.getAbilità().getFase_attivazione())
        p.getAbilità().Attivazione(p,bersaglio);*/
        utilizzatore.AttivaAbilità(bersaglio, fase);

    }


    public void checkstatus(String p){
       if( p.equals("g1"))
        p1.attivastatus(this.fase);
        if(p.equals("g2"))
        p2.attivastatus(this.fase);
    }
  
    public void setAttacca(String p, boolean b){
        Personaggio per=null;
        if(p.equals("g1"))per=p1;
        if(p.equals("g2"))per=p2;
        per.setAttacca(b);
    }
    public void setDifende(String p, boolean b){
        Personaggio per=null;
        if(p.equals("g1"))per=p1;
        if(p.equals("g2"))per=p2;
        per.setDifende(b);
    }
    public boolean checkKo(String p){
        Personaggio per=null;
        if(p.equals("g1"))per=p1;
        if(p.equals("g2"))per=p2;
        if(per.getpS()==0)return true;
        else return false;
    }
  
    public boolean FineTurnoKo(){
        if( this.checkKo("g1")||this.checkKo("g2")){
            return true;
        
        }
        else return false;
        }



    public void sostituisci(String p){
        
        int index=0;
        Personaggio per=null;
        if(p.equals("g1")){
            per=p1;
        
           
            index=0;
           this.p1=this.sostituzioni.get(index);
            this.p1.VaiInCampo();
        }
        if(p.equals("g2")){
        per=p2;
            
            
            index=1;
            this.p2=this.sostituzioni.get(index);
            this.p2.VaiInCampo();
        }

        System.out.println(per.getNomePersonaggio()+" viene sostituito da "+ this.sostituzioni.get(index).getNomePersonaggio());
       
        per.VaiInPanchina();
        


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



  



    public ArrayList<String> getMosse() {
        return mosse;
    }



    public void setMosse(ArrayList<String> mosse) {
        this.mosse = mosse;
    }



    public ArrayList<String> getStrumenti() {
        return strumenti;
    }



    public void setStrumenti(ArrayList<String> strumenti) {
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
    public void utilizzaStrumento(String p){
        int index=0;
        if(p.equals("g1")){ index=0;}
        if(p.equals("g2")){index=1;}
       System.out.println(strumenti.get(index));
    }
   
 

}
