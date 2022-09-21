package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Random;

public class Partita {
    private Giocatore player1;
    private Giocatore player2;
    private Turno t;
    
    
   
    public Partita(Giocatore player1, Giocatore player2) throws FileNotFoundException {
        this.player1 = player1;
        this.player2 = player2;
        this.t = this.createTurno(0);
       
        
       
    }

    public void UsaMossa(String id_mossa,String Nome_giocatore){
        if(this.player1.getNome().equals(Nome_giocatore)){
            t.setMossaG1(id_mossa);
            t.setSostituzioneg1(null);
            t.setStrumentoG1(null);
        }
        else{
            t.setMossaG2(id_mossa);
            t.setSostituzioneg2(null);
            t.setStrumentoG2(null);
        }
       this.VerificaCompletezzaTurno();
        
    }


    public void UsaStrumento(ArrayList<Integer>Index_Personaggio_Strumento,String Nome_giocatore){
        if(this.player1.getNome().equals(Nome_giocatore)){
            
            t.setMossaG1(null);
            t.setSostituzioneg1(null);
          
            Personaggio p=this.player1.getPersonaggioFromSquadra(Index_Personaggio_Strumento.get(0));
            Strumento s=this.player1.GetStrumentoFromSquadra(Index_Personaggio_Strumento.get(1));
          
            
            String message=s.Utilizza(p);
            t.setStrumentoG1(message);
        }
        else{
            t.setMossaG2(null);
            t.setSostituzioneg2(null);
         
           
            Personaggio p=this.player2.getPersonaggioFromSquadra(Index_Personaggio_Strumento.get(0));
            Strumento s=this.player2.GetStrumentoFromSquadra(Index_Personaggio_Strumento.get(1));
            String message=s.Utilizza(p);
            
            t.setStrumentoG2(message);
        }
        this.VerificaCompletezzaTurno();
    }

    public void EffettuaSostituzione(String Nome_giocatore,int index_personaggio){
        if(this.player1.getNome().equals(Nome_giocatore)){
            t.setMossaG1(null);
            t.setSostituzioneg1(player1.getSquadraAttiva().getPersonaggio(index_personaggio));
            
            t.setStrumentoG1(null);
        }
        else{
            t.setMossaG2(null);
            t.setSostituzioneg2(player2.getSquadraAttiva().getPersonaggio(index_personaggio));
            
            t.setStrumentoG2(null);
        }
       this.VerificaCompletezzaTurno();
          
    }

    //gioca partita//
    public Giocatore giocaPartita() throws IOException{
        boolean terminata=false;
        Giocatore vincitore=null;
        while(vincitore==null){
            this.turno_zero();
            ArbitroSingleton.getIstanza().CambioPerKo(t, player1, player2);
            new View().ResoConto(this);
            int sceltag1= new View().ScegliAzione(this.player1);
            switch(sceltag1){
                case 1:
                this.UsaMossa(new View().SelezionaMossa(t.getP1()), player1.getNome());
                break;
                case 2:
                this.EffettuaSostituzione(player1.getNome(), new View().SceltaPersonaggioCampo(player1, player1.getSquadraAttiva(), t.getP1()));
                break;
                case 3:
                this.UsaStrumento(new View().ScegliStrumento(this.player1.getSquadraAttiva()), this.player1.getNome());
                break;

            }
            int sceltag2= new View().ScegliAzione(this.player2);
            switch(sceltag2){
                case 1:
                this.UsaMossa(new View().SelezionaMossa(t.getP2()), player2.getNome());
                break;
                case 2:
                this.EffettuaSostituzione(player2.getNome(), new View().SceltaPersonaggioCampo(player2, player2.getSquadraAttiva(), t.getP2()));
                break;
                case 3:
                this.UsaStrumento(new View().ScegliStrumento(this.player2.getSquadraAttiva()), this.player2.getNome());
                break;

            }
            this.avanza();
            vincitore=ArbitroSingleton.getIstanza().TrovaVincitore(player1, player2);
        }
        return vincitore;
    }
    public Turno createTurno(int numturno){
        return new Turno(numturno, Fase.Inizio_turno);

    }
    //metodi privati di utilità//
   
    private void avanza(){
        //this.t=this.createTurno(this.t.getNumturno()+1);
       /* this.t.setNumturno(this.t.getNumturno()+1);
        this.t.setMossaG1(null);
        this.t.setMossaG2(null);
        this.t.*/
        Personaggio p1=t.getP1();
        Personaggio p2=t.getP2();

        this.t=this.createTurno(this.t.getNumturno()+1);
        this.t.setP1(p1);
        this.t.setP2(p2);
    }
   
 
    private void turno_zero(){
        if(this.t.getNumturno()==0){
            Personaggio p1=this.player1.getSquadraAttiva().getPersonaggio(0);
            p1.VaiInCampo();
            this.t.setP1(p1);
            Personaggio p2=this.player2.getSquadraAttiva().getPersonaggio(0);
            p2.VaiInCampo();;
            this.t.setP2(p2);
            
        }
    }
    
    private void setTurnoStrategy(){
        
       t.setEsecuzione( EsecuzioneTurnoStrategyFactorySingleton.getIstanza().CreateStrategy(t));
       
    }
    private void VerificaCompletezzaTurno(){
        if( t.checkCompletezza()){
            
            this.setTurnoStrategy();
            t.esecuzione();
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

    public Turno getTurno() {
        return t;
    }

    public void setTurno(Turno t) {
        this.t = t;
    }

    public Giocatore simula(){

        int v = new Random().nextInt(2);
       
        if(v == 0)
            return this.player1;
        else 
            return this.player2;
    
    }
 
}
