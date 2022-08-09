package Entity;

public class Partita {
    private Giocatore player1;
    private Giocatore player2;
    private Turno t;
    public Partita(Giocatore player1, Giocatore player2) {
    this.player1 = player1;
    this.player2 = player2;
    this.t = new Turno(0, Fase.Inizio_turno);
}




public boolean gioca(String m1, String m2, Personaggio p1, Personaggio p2, Strumento s1, Strumento s2){
    String strat="";
    if(m1!=null){
        
        t.setMossaG1(m1);
        strat="Mossa";
    }
    else t.setMossaG1(null);
    if(p1!=null){
        t.setSostituzioneg1(p1);
        strat="Cambio";
    }
    else t.setSostituzioneg1(null);
    if(s1!=null){
        t.setStrumentoG1(s1);
        strat="Strumento";
    }
    else t.setStrumentoG1(null);
    if(m2!=null){
        t.setMossaG2(m2);
        strat=strat.concat("Mossa");
    }
    if(p2!=null){
        t.setSostituzioneg2(p2);
        strat=strat.concat("Cambio");
    }
    if(s2!=null){
        t.setStrumentoG2(s2);
        strat=strat.concat("Strumento");
    }
t.setEsecuzione(this.FindStrategy(strat));
System.out.println("turno n "+t.getNumturno()+" di tip "+strat);
t.esecuzione();
if(this.WinG1()||this.WinG2())return false;
else{
    this.avanzaturno();
    return true;
}    
    
 }   
 private EsecuzioneTurno FindStrategy(String a){
    EsecuzioneTurno strat=null;
    switch(a){
        case "MossaMossa":
        MossaMossa strat1=new MossaMossa();
        strat=strat1;
        break;
        case "MossaCambio":
        MossaCambio strat2=new MossaCambio();
        strat=strat2;
        break;
        case "MossaStrumento":
        MossaStrumento strat3=new MossaStrumento();
        strat=strat3;
        break;
        case "CambioCambio":
        CambioCambio strat4=new CambioCambio();
        strat=strat4;
        break;
        case "CambioStrumento":
        CambioStrumento strat5=new CambioStrumento();
        strat=strat5;
        break;
        case "CambioMossa":
        CambioMossa strat6=new CambioMossa();
        strat=strat6;
        break;
        case "StrumentoMossa":
        StrumentoMossa strat7=new StrumentoMossa();
        strat=strat7;
        break;
        case "StrumentoCambio":
        StrumentoCambio Strat8=new StrumentoCambio();
        strat=Strat8;
        break;
        case "StrumentoStrumento":
        StrumentoStrumento strat9=new StrumentoStrumento();
        strat=strat9;
        break;
    }
    return strat;
 }
 
 public boolean WinG1(){
    boolean vittoria=true;
    if(!this.player2.getSquadra().checkKOSquadra()){
        vittoria = false;
    }
    return vittoria;
  
 }
 
 public boolean WinG2(){
    boolean vittoria=true;
    if(!this.player1.getSquadra().checkKOSquadra()){
        vittoria = false;
    }
    
    return vittoria;
    
 }

 private void avanzaturno(){
   /*  Turno t= new Turno(this.t.getNumturno()+1, Fase.Inizio_turno);
    this.t=t;*/
    this.t.setNumturno(this.t.getNumturno()+1);
    t.setFase(Fase.Inizio_turno);
 }




public Giocatore getPlayer1() {
    return player1;
}




public void setPlayer1(Giocatore player1) {
    this.player1 = player1;
}




public Giocatore getPlayer2() {
    return player2;
}




public void setPlayer2(Giocatore player2) {
    this.player2 = player2;
}




public Turno getT() {
    return t;
}




public void setT(Turno t) {
    this.t = t;
}

public void CambioPerKoP1(Personaggio P){
    t.setSostituzioneg1(P);
    System.out.println(t.getSostituzioni().get(0));
    t.sostituiscip1();

}

public void CambioPerKoP2(Personaggio P){
   // t.setSostituzioneg1(P);
    t.setSostituzioneg2(P);
    System.out.println(t.getSostituzioni().get(0));
    System.out.println(t.getSostituzioni().get(1));
    t.sostituiscip2();
   // t.setSostituzioneg1(null);
   
}


}


