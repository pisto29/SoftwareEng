package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Foundation.builder;

public class Squadra {
    
    private String nomeSquadra;
    private ArrayList<Personaggio> personaggios;
    private HashMap<String,String[]> id;
    private ArrayList<Strumento> strumentos;
    private String[] id_strumenti;
    public Squadra(String nomeSquadra, ArrayList<Personaggio> personaggios, ArrayList<Strumento> strumentos) {
        this.nomeSquadra = nomeSquadra;
        this.personaggios = personaggios;
        this.strumentos = strumentos;
    }
    public Squadra(Squadra s) throws FileNotFoundException{
        this.nomeSquadra=s.getNomeSquadra();
        this.id=s.getId();
        this.id_strumenti=s.getId_strumenti();
        this.personaggios=new ArrayList<>();
        this.strumentos=new ArrayList<>();
        for(String st: this.id_strumenti){
            try {
                this.strumentos.add(builder.CreaStrumento(st));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        for(String st: this.id.keySet()){
            Personaggio p= builder.CreaPersonaggio(st);
           
            p.setId_mosse(this.id.get(st));
            
            this.personaggios.add(new Personaggio(p));
            
        }
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

    public boolean checkKOSquadra(){

        for(Personaggio p:  this.personaggios){
            System.out.println(p.getRuolo().getClass().getSimpleName());
            System.out.println(p.getRuolo().getClass().getSimpleName().equals("KoSingleton"));
            if(!p.getRuolo().getClass().getSimpleName().equals("KoSingleton"))
            return false;
            
          }
        return true;

        
    }
    public HashMap<String, String[]> getId() {
        return id;
    }
    public void setId(HashMap<String, String[]> id) {
        this.id = id;
    }
    public String[] getId_strumenti() {
        return id_strumenti;
    }
    public void setId_strumenti(String[] id_strumenti) {
        this.id_strumenti = id_strumenti;
    }
    @Override
    public String toString() {
        return "Squadra [id=" + id + ", id_strumenti=" + Arrays.toString(id_strumenti) + ", nomeSquadra=" + nomeSquadra
                + ", personaggios=" + personaggios + ", strumentos=" + strumentos + "]";
    }
 
    
}
