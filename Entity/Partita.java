package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Foundation.builder;

public class Partita {
    private Giocatore player1;
    private Giocatore player2;
    private Turno t;
    private boolean giocabile;
    private RegolamentoComponent regolamento;
    private String id_regolamento;
    public Partita(Giocatore player1, Giocatore player2,String id_regolamento) throws FileNotFoundException {
    this.player1 = player1;
    this.player2 = player2;
    this.id_regolamento=id_regolamento;
   
    this.regolamento=RegolamentoFactorySingleton.getIstanza().CreaRegolamento(id_regolamento);
    this.giocabile=this.checksquadre();
    this.t = new Turno(0, Fase.Inizio_turno);
}

private boolean checksquadre(){
    boolean rit=false;
    
    if(!regolamento.VerificaRegolamento(player1.getSquadra().get(this.player1.getSquadraSelezionata()))){
        ArrayList<Squadra> Utilizzabile=new ArrayList<>();
        int utilizzabili=0;
        for(Squadra s:this.player1.getSquadra()){
            if(this.regolamento.VerificaRegolamento(s)){
            Utilizzabile.add(s);
                utilizzabili++;
        }
            else
            Utilizzabile.add(null);

        }
        if(utilizzabili>0){
        try {
            this.player1.setSquadraSelezionata(new View().ScegliSquadra(Utilizzabile));
            rit=true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    else{
        new View().Messaggi("NoSquadre");
        rit=false;
        
    }

}
else{rit=true;}
if(!regolamento.VerificaRegolamento(player2.getSquadra().get(this.player2.getSquadraSelezionata()))){
    ArrayList<Squadra> Utilizzabile=new ArrayList<>();
    int utilizzabili=0;
    for(Squadra s:this.player2.getSquadra()){
        if(this.regolamento.VerificaRegolamento(s)){
        Utilizzabile.add(s);
            utilizzabili++;
    }
        else
        Utilizzabile.add(null);

    }
    if(utilizzabili>0){
    try {
        this.player1.setSquadraSelezionata(new View().ScegliSquadra(Utilizzabile));
        rit=true;
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
else{
    new View().Messaggi("NoSquadre");
    rit=false;
    
}

}
return rit;
}


public boolean gioca(String m1, String m2, Personaggio p1, Personaggio p2, HashMap<Strumento,Personaggio> s1, HashMap<Strumento,Personaggio> s2){
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
System.out.println("turno numero "+t.getNumturno());
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
    if(!this.player2.getSquadra().get(this.player2.getSquadraSelezionata()).checkKOSquadra()){
        vittoria = false;
    }
    return vittoria;
  
 }
 
 public boolean WinG2(){
   
    boolean vittoria=true;
    if(!this.player1.getSquadra().get(this.player1.getSquadraSelezionata()).checkKOSquadra()){
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


public Giocatore EseguiPartita() throws IOException{
    if(!this.giocabile){
        new View().Messaggi("non giocabile");
        return null;
    }
        int i=1;
        int azione1=0;
        int azione2=0;
        String MossaG1=null;
        HashMap<Strumento,Personaggio> StrumentoG1=null;
        Personaggio SostituzioneG1=null;
        String MossaG2=null;
        HashMap<Strumento,Personaggio> StrumentoG2=null;
        Personaggio SostituzioneG2=null;
        View v = new View();
        Boolean continua = true;
        v.Messaggi("inizio");
        while(continua){
            //turno 0
            if(this.t.getNumturno()==0){
                this.t.setP1(v.SceltaPersonaggioCampo(this.player1, this.player1.getSquadra().get(this.player1.getSquadraSelezionata()),null));
                this.t.getP1().Sostituzione();
                PersonaggioAttivoSingleton.setpass("istanza2");
                this.t.setP2(v.SceltaPersonaggioCampo(this.player2, this.player2.getSquadra().get(this.player2.getSquadraSelezionata()),null));
                this.t.getP2().Sostituzione();
            }
            if(this.t.checkKoP1()){
                v.pokemonko(t.getP1().getNomePersonaggio()+" di "+this.player1.getNome());
                MossaG1=null;
                StrumentoG1=null;
                SostituzioneG1 =  v.SceltaPersonaggioCampo(this.player1, this.player1.getSquadra().get(this.player1.getSquadraSelezionata()),null);
                this.CambioPerKoP1(SostituzioneG1);
            }
            if(this.t.checkKoP2()){
                v.pokemonko(t.getP2().getNomePersonaggio()+" di "+this.player2.getNome());
                MossaG2=null;
                StrumentoG2=null;
                SostituzioneG2 =  v.SceltaPersonaggioCampo(this.player2, this.player2.getSquadra().get(this.player2.getSquadraSelezionata()),null);
                this.CambioPerKoP2(SostituzioneG2);
            }
            v.ResoConto(this);
            do{try {
                azione1 = v.ScegliAzione(this.getPlayer1());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }}
            while(azione1<1 || azione1>3);
            switch(azione1){
                case 1:
                    try {
                        MossaG1 = v.SelezionaMossa(t.getP1());
                        System.out.println("mossa 1 e "+MossaG1);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                StrumentoG1 = null;
                SostituzioneG1 = null;
                break;
                ///////////////////////////////////////////
            
            case 2:
            MossaG1=null;
            StrumentoG1=null;
            SostituzioneG1 =  v.SceltaPersonaggioCampo(this.player1, this.player1.getSquadra().get(this.player1.getSquadraSelezionata()),this.getT().getP1());
            break;

            case 3:
            MossaG1=null;
            SostituzioneG1=null;
            StrumentoG1=v.ScegliStrumento(this.player1.getSquadra().get(this.player1.getSquadraSelezionata()));
            break;
        
        }
        ///g2
        do{try {
            azione2 = v.ScegliAzione(this.getPlayer2());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}
        while(azione2<1 || azione2>3);
        switch(azione2){
            case 1:
                try {
                    MossaG2 = v.SelezionaMossa(t.getP2());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            StrumentoG2 = null;
            SostituzioneG2 = null;
            break;
            ///////////////////////////////////////////
        
        case 2:
        MossaG2=null;
        StrumentoG2=null;
        SostituzioneG2 =  v.SceltaPersonaggioCampo(this.player2, this.player2.getSquadra().get(this.player2.getSquadraSelezionata()),this.getT().getP2());
        break;

        case 3:
        MossaG2=null;
        SostituzioneG2=null;
        StrumentoG2=v.ScegliStrumento(this.player2.getSquadra().get(this.player2.getSquadraSelezionata()));
        break;
    
    }
    continua=this.gioca(MossaG1, MossaG2, SostituzioneG1, SostituzioneG2, StrumentoG1, StrumentoG2);
        }
        if(this.WinG1()==true){
            
            System.out.println("Vince "+this.player1.getNome());
            return this.player1;
        }
        else{
            System.out.println("Vince "+this.player1.getNome());
            return this.player2;
        }

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
   
    t.sostituiscip1();

}

public void CambioPerKoP2(Personaggio P){
   // t.setSostituzioneg1(P);
    t.setSostituzioneg2(P);
    
    t.sostituiscip2();
   // t.setSostituzioneg1(null);
   
}
public static void main(String[] args) throws IOException, JsonSyntaxException, JsonIOException, ClassNotFoundException {
    Giocatore g1 = builder.CreaGiocatore("G1");
     Giocatore g2 = builder.CreaGiocatore("G2");
     Partita p=new Partita(g1, g2,"NoRegole_");
     p.EseguiPartita();
    
}

public Giocatore simula(){

    int v = new Random().nextInt(2);
   
    if(v == 0)
        return this.player1;
    else 
        return this.player2;

}

}


