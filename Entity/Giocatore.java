package Entity;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Foundation.builder;

public class Giocatore {
    private String nome;
    private int punteggio;
    private Squadra squadra;
    private Matchmaking matchmaking;
    private String idSquadra;
    
    public Giocatore(String nome, int punteggio, Squadra squadra, Matchmaking matchmaking) {
        this.nome = nome;
        this.punteggio = punteggio;
        this.squadra = squadra;
        this.matchmaking = matchmaking;
    }

    public Giocatore( Giocatore g) throws FileNotFoundException{
        this.nome = g.getNome();
        this.punteggio = g.getPunteggio();
        this.idSquadra = g.getIdSquadra();
        this.squadra = builder.creaSquadra(this.idSquadra);
        

        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Squadra getSquadra() {
        return squadra;
    }

    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
    }


    public Matchmaking getMatchmaking() {
        return matchmaking;
    }

    public void setMatchmaking(Matchmaking matchmaking) {
        this.matchmaking = matchmaking;
    }

    public String getIdSquadra() {
        return idSquadra;
    }

    public void setIdSquadra(String idSquadra) {
        this.idSquadra = idSquadra;
    }

    @Override
    public String toString() {
        return "Giocatore [idSquadra=" + idSquadra + ", matchmaking=" + matchmaking + ", nome=" + nome + ", punteggio="
                + punteggio + ", squadra=" + squadra + "]";
    }
    
    

  
}
