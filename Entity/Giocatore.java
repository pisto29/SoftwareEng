package Entity;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Foundation.builder;

public class Giocatore {
    private String nome;
    private ArrayList<Squadra> squadra;
    private ArrayList<String> idSquadra;
    private Integer SquadraSelezionata;
    
    public Giocatore(String nome, Squadra squadra) {
        this.nome = nome;
        
       // this.squadra = squadra;
        
    }

    public Giocatore( Giocatore g) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        this.squadra=new ArrayList<>();
        this.idSquadra=new ArrayList<>();
        this.nome = g.getNome();
        this.idSquadra = g.getIdSquadra();
        for(String id: idSquadra)
        this.squadra.add(builder.creaSquadra(id));
        this.SquadraSelezionata=0;
        

        
    }
public Squadra getSquadraAttiva(){
    return this.squadra.get(this.SquadraSelezionata);
}
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
   


 

   

    @Override
    public String toString() {
        return "Giocatore [idSquadra=" + idSquadra + ", nome=" + nome 
                 + ", squadra=" + squadra + "]";
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
