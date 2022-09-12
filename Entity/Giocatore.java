package Entity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Foundation.builder;

public class Giocatore {
    private String nome;
    private int punteggio;
    private ArrayList<Squadra> squadra;
    private Matchmaking matchmaking;
    private ArrayList<String> idSquadra;
    private Integer SquadraSelezionata;
    
    public Giocatore(String nome, int punteggio, Squadra squadra, Matchmaking matchmaking) {
        this.nome = nome;
        this.punteggio = punteggio;
       // this.squadra = squadra;
        this.matchmaking = matchmaking;
    }

    public Giocatore( Giocatore g) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        this.squadra=new ArrayList<>();
        this.idSquadra=new ArrayList<>();
        this.nome = g.getNome();
        this.punteggio = g.getPunteggio();
        this.idSquadra = g.getIdSquadra();
        for(String id: idSquadra)
        this.squadra.add(builder.creaSquadra(id));
        this.SquadraSelezionata=0;
        

        
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

   


    public Matchmaking getMatchmaking() {
        return matchmaking;
    }

    public void setMatchmaking(Matchmaking matchmaking) {
        this.matchmaking = matchmaking;
    }

   

    @Override
    public String toString() {
        return "Giocatore [idSquadra=" + idSquadra + ", matchmaking=" + matchmaking + ", nome=" + nome + ", punteggio="
                + punteggio + ", squadra=" + squadra + "]";
    }

    public ArrayList<Squadra> getSquadra() {
        return squadra;
    }

    public void setSquadra(ArrayList<Squadra> squadra) {
        this.squadra = squadra;
    }

    public ArrayList<String> getIdSquadra() {
        return idSquadra;
    }

    public void setIdSquadra(ArrayList<String> idSquadra) {
        this.idSquadra = idSquadra;
    }

    public Integer getSquadraSelezionata() {
        return SquadraSelezionata;
    }

    public void setSquadraSelezionata(Integer squadraSelezionata) {
        SquadraSelezionata = squadraSelezionata;
    }
    
  

  
}
