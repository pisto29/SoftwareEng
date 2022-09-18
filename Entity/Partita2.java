package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Partita2 {
    private Giocatore player1;
    private Giocatore player2;
    private Turno t;
    private boolean giocabile;
    private RegolamentoComponent regolamento;
    private String id_regolamento;
    public Partita2(Giocatore player1, Giocatore player2, 
            String id_regolamento) throws FileNotFoundException {
        this.player1 = player1;
        this.player2 = player2;
        this.t = this.createTurno(0);
        this.giocabile = giocabile;
        
        this.id_regolamento = id_regolamento;
        this.regolamento=CompetitionFactorySingleton.getIstanza().CreaRegolamento(id_regolamento);
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
            HashMap<Strumento,Personaggio> map= new HashMap();
            map.put(player1.getSquadraAttiva().getStrumento(Index_Personaggio_Strumento.get(0)), player1.getSquadraAttiva().getPersonaggio(Index_Personaggio_Strumento.get(1)));
            
            t.setStrumentoG1(map);
        }
        else{
            t.setMossaG2(null);
            t.setSostituzioneg2(null);
            HashMap<Strumento,Personaggio> map= new HashMap();
            map.put(player2.getSquadraAttiva().getStrumento(Index_Personaggio_Strumento.get(0)), player2.getSquadraAttiva().getPersonaggio(Index_Personaggio_Strumento.get(1)));
            
            t.setStrumentoG1(map);
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
        while(!terminata){
            this.turno_zero();
            this.controlloKo();
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
            terminata=this.VerificaVittoria();
        }
        return this.TrovaVincitore();
    }
    public Turno createTurno(int numturno){
        return new Turno(numturno, Fase.Inizio_turno);

    }
    //metodi privati di utilità//
    private void controlloKo() throws IOException{
        if(this.t.checkKoP1()){
            //metodo view per scegliere il cambio
            t.getP1().Sostituzione();
            PersonaggioAttivoSingleton.setpass("Istanza1");
            Personaggio p=player1.getSquadraAttiva().getPersonaggio(new View().SceltaPersonaggioCampo(player1, player1.getSquadraAttiva(), t.getP1()));
            p.Sostituzione();
            t.setP1(p);
            
        }
        if(this.t.checkKoP2()){
            //metodo view per scegliere il cambio
            t.getP2().Sostituzione();
            PersonaggioAttivoSingleton.setpass("Istanza2");
            Personaggio p=player2.getSquadraAttiva().getPersonaggio(new View().SceltaPersonaggioCampo(player2, player2.getSquadraAttiva(), t.getP2()));
            p.Sostituzione();
            t.setP2(p);
            
        }
    }
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
    private Giocatore TrovaVincitore(){
        if(player1.getSquadraAttiva().checkKOSquadra())
        return player2;
        else return player1;
    }
    private boolean VerificaVittoria(){
        if(player1.getSquadraAttiva().checkKOSquadra()||player2.getSquadraAttiva().checkKOSquadra())
        return true;
        else return false;
    }
    private void turno_zero(){
        if(this.t.getNumturno()==0){
            Personaggio p1=this.player1.getSquadraAttiva().getPersonaggio(0);
            p1.Sostituzione();
            this.t.setP1(p1);
            Personaggio p2=this.player2.getSquadraAttiva().getPersonaggio(0);
            p2.Sostituzione();
            this.t.setP2(p2);
            
        }
    }
    
    private void setTurnoStrategy(){
        
       t.setEsecuzione( EsecuzioneTurnoStrategyFactorySingleton.getIstanza().CreateStrategy(t));
       
    }
    private void VerificaCompletezzaTurno(){
        if( t.getMosse().size()+t.getSostituzioni().size()+t.getStrumenti().size()==6){
            
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

    public boolean isGiocabile() {
        return giocabile;
    }

    public void setGiocabile(boolean giocabile) {
        this.giocabile = giocabile;
    }

    public RegolamentoComponent getRegolamento() {
        return regolamento;
    }

    public void setRegolamento(RegolamentoComponent regolamento) {
        this.regolamento = regolamento;
    }

    public String getId_regolamento() {
        return id_regolamento;
    }

    public void setId_regolamento(String id_regolamento) {
        this.id_regolamento = id_regolamento;
    }
}
