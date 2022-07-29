package Entity;

import java.util.ArrayList;

public class Squadra {
    
    private String nomeSquadra;
    private ArrayList<Personaggio> personaggios;
    private ArrayList<Strumento> strumentos;
    public Squadra(String nomeSquadra, ArrayList<Personaggio> personaggios, ArrayList<Strumento> strumentos) {
        this.nomeSquadra = nomeSquadra;
        this.personaggios = personaggios;
        this.strumentos = strumentos;
    }
    public String getNomeSquadra() {
        return nomeSquadra;
    }
    public void setNomeSquadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
    }
    public ArrayList<Personaggio> getPersonaggios() {
        return personaggios;
    }
    public void setPersonaggios(ArrayList<Personaggio> personaggios) {
        this.personaggios = personaggios;
    }
    public ArrayList<Strumento> getStrumentos() {
        return strumentos;
    }
    public void setStrumentos(ArrayList<Strumento> strumentos) {
        this.strumentos = strumentos;
    }
 
    
}
