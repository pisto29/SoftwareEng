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
    private ArrayList <HashMap<Strumento,Personaggio>> strumenti;
    private ArrayList <Personaggio> sostituzioni;
    private EsecuzioneTurno esecuzione;

    
    public Turno(int numturno, Fase fase) {
        this.numturno = numturno;
        this.fase = fase;
        this.mosse = new ArrayList<>();
        this.strumenti = new ArrayList<>();
        this.sostituzioni = new ArrayList<>();
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
    public void setStrumentoG1(HashMap<Strumento,Personaggio> s){
        this.strumenti.add(0, s);
    }
    public void setStrumentoG2(HashMap<Strumento,Personaggio>  s){
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

        if(this.p1.puoattaccare()){
        
        System.out.println("attacca p1 "+p1.getNomePersonaggio()+" usa "+this.mosse.get(0));
       float danno=this.p1.Attacca(this.mosse.get(0));
      

       Mossa m1=null;
       for (Mossa m : this.p1.getMossas()) {
           if(m.getNomeMossa().equals(this.getMosse().get(0)))
           m1=m;
       }
       //print da levare poi
       
        boolean colpito=p2.Difendi(danno, m1);
        
        if(colpito&&m1.CheckEffetto()){
            
            m1.ApplicaEffettoMossa(this.p1,this.p2);}
           
    
    }
        else{ System.out.println(this.p1.getNomePersonaggio()+" non puo attaccare");
        p1.AbiltaAttacco();
    }
    }

    public void EseguiAttaccoP2(){
       if(this.p2.puoattaccare()) {
        System.out.println("attacca p2 "+p2.getNomePersonaggio()+" usa "+this.mosse.get(1));
        float danno=this.p2.Attacca(this.mosse.get(1));
        Mossa m1=null;
        for (Mossa m : this.p2.getMossas()) {
            if(m.getNomeMossa().equals(this.getMosse().get(1)))
            m1=m;
        }
        boolean colpito= p1.Difendi(danno, m1);
         if(colpito&&m1.CheckEffetto())m1.ApplicaEffettoMossa(this.p2,this.p1);}
         else{System.out.println(this.p2.getNomePersonaggio()+" non puo attaccare");
        this.p2.AbiltaAttacco();}
     }
    public void eseguiAttacco(Personaggio p){
       
        int index=0;
        Personaggio difensore=this.p2;
        if(p.equals(this.p1)){index=0;  difensore=this.p2;}
        else {index=1; difensore=this.p1;}
        if(p.puoattaccare()) {
            System.out.println("attacca  "+p.getNomePersonaggio()+" usa "+this.mosse.get(index));
            
            float danno=p.Attacca(this.mosse.get(index));
            Mossa m1=null;
            for (Mossa m : p.getMossas()) {
                if(m.getNomeMossa().equals(this.getMosse().get(index)))
                m1=m;
            }
            boolean colpito= difensore.Difendi(danno, m1);
            
             if(colpito&&m1.CheckEffetto())m1.ApplicaEffettoMossa(p,difensore);}
             else{System.out.println(p.getNomePersonaggio()+" non puo attaccare");
            p.AbiltaAttacco();}

    }

    public boolean checkVelocità(){
       if(p1.getvelocitaPersonaggio()>p2.getvelocitaPersonaggio()){
          return true;
       }
       else {
           if(p1.getvelocitaPersonaggio()==p2.getvelocitaPersonaggio()){
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

    public void EseguiAbilità(Personaggio p){
        Personaggio bersaglio=this.p2;
       
        if(p.equals(this.p1)){
            
            bersaglio=p2;

        }
        if(p.equals(this.p2)){
            
            bersaglio=this.p1;
        }
        if (this.fase == p.getAbilità().getFase_attivazione())
        p.getAbilità().Attivazione(p,bersaglio);

    }
    public void EseguiAbilitàP1(){

        if (this.fase == this.p1.getAbilità().getFase_attivazione())
        this.p1.getAbilità().Attivazione(this.p1,this.p2);


        
    }
    public void EseguiAbilitàP2(){

        if (this.fase == this.p2.getAbilità().getFase_attivazione())
        this.p2.getAbilità().Attivazione(this.p2,this.p1);


        
    }

    public void checkstatus(Personaggio p){
        p.attivastatus(this.fase);
    }
    public void checkStatusP1(){
        this.p1.attivastatus(this.fase);
    }
    public void checkStatusP2(){
        this.p2.attivastatus(this.fase);
    }
    public boolean checkKo(Personaggio p){
        if(p.getpS()==0)return true;
        else return false;
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
        if( this.checkKoP1()||this.checkKoP2()){this.setFase(Fase.Fine_Turno);
        System.out.println("fine turno ko ");
        }
        }



    public void sostituisci(Personaggio p){
        String istanza="istanza1";
        int index=0;
        if(this.p1.equals(p)){
            
            istanza="istanza1";
            PersonaggioAttivoSingleton.setpass(istanza);
            index=0;
           this.p1=this.sostituzioni.get(index);
            this.p1.Sostituzione();
        }
        if(this.p2.equals(p)){
        
            istanza="istanza2";
            PersonaggioAttivoSingleton.setpass(istanza);
            index=1;
            this.p2=this.sostituzioni.get(index);
            this.p2.Sostituzione();
        }

        System.out.println(p.getNomePersonaggio()+" viene sostituito da "+ this.sostituzioni.get(index).getNomePersonaggio());
        if(p.getpS()>0
        )
        p.Sostituzione();
        


    }
    public void sostituiscip1(){
        //if(this.p1 != this.sostituzioni.get(0)){
        PersonaggioAttivoSingleton.setpass("istanza1");
        System.out.println(p1.getNomePersonaggio()+" viene sostituito da "+ this.sostituzioni.get(0).getNomePersonaggio());
        if(p1.getpS()>0
        )
        p1.Sostituzione();
        this.p1=this.sostituzioni.get(0);
        this.p1.Sostituzione();
       // }
    }

    public void sostituiscip2(){
        PersonaggioAttivoSingleton.setpass("istanza2");
        System.out.println(p2.getNomePersonaggio()+" viene sostituito da "+ this.sostituzioni.get(1).getNomePersonaggio());
        if(p2.getpS()>0)
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



    public ArrayList<HashMap<Strumento,Personaggio>> getStrumenti() {
        return strumenti;
    }



    public void setStrumenti(ArrayList<HashMap<Strumento,Personaggio>> strumenti) {
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
    public void utilizzaStrumento(Personaggio p){
        int index=0;
        if(this.p1.equals(p)){ index=0;}
        if(this.p2.equals(p)){index=1;}
        for(Strumento s: this.strumenti.get(index).keySet()){
            s.UtilizzaStrumento(this.strumenti.get(index).get(s));
           }
    }
    public void utilizzaStrumentoP1(){
       for(Strumento s: this.strumenti.get(0).keySet()){
        s.UtilizzaStrumento(this.strumenti.get(0).get(s));
       }
        //this.getStrumenti().get(0).UtilizzaStrumento(this.p1);
    }

    public void utilizzaStrumentoP2(){
        for(Strumento s: this.strumenti.get(1).keySet()){
            s.UtilizzaStrumento(this.strumenti.get(1).get(s));
           }
    }

}
