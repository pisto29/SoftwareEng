package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Foundation.builder;

public class Server {
    private ArrayList<Torneo> tornei;
    private ArrayList<Giocatore> online;
    private View v;
    private CatalogoRegolamento r;
    
    public Server() throws FileNotFoundException{
        online=new ArrayList<>();
        tornei=new ArrayList<>();
        this.v = new View();
        r=new CatalogoRegolamento();
    }

public void OrganizzaTorneo(String Struttura_torneo,int NumeroPartecipanti,Boolean accessibilità,ArrayList<String> id_regolamento) throws FileNotFoundException{
this.tornei.add(CompetitionFactorySingleton.getIstanza().creaTorneo(Struttura_torneo, NumeroPartecipanti, accessibilità, id_regolamento));
for(String s: id_regolamento){
    Regolamento re=this.r.GetRegolamento(s);
    this.tornei.get(this.tornei.size()-1).AddRegolamento(re);
}
}
public void IscrizioneTorneo(String Username, int Index_torneo) throws IOException{
    Giocatore DaIscrivere=null;
    for(Giocatore g: online){
        if(g.getNome().equals(Username))DaIscrivere=g;
    }
    int iscritti=this.tornei.get(Index_torneo).AggiungiPartecipante(DaIscrivere);
    System.out.println("Iscrizione di "+Username+" mancano "+(this.tornei.get(Index_torneo).getNumeroPartecipanti()-iscritti)+"iscritti");
    if(iscritti==this.tornei.get(Index_torneo).getNumeroPartecipanti()){
        System.out.println("Iscrizioni completate il torneo ha inizio");
        this.tornei.get(Index_torneo).AvviaTorneo();}
}
public void SelezionaSquadra(String NomeGiocatore, int SquadraSelezionata){
    for (Giocatore giocatore : online) {
        if(giocatore.getNome().equals(NomeGiocatore))giocatore.setSquadraSelezionata(SquadraSelezionata);
        
    }
}
public ArrayList<Squadra>VerificaConformitaSquadre(int index_torneo,String Username){
    Giocatore g=null;
    for (Giocatore giocatore : online) {
        if(giocatore.getNome().equals(Username))g=giocatore;
    }
    return this.tornei.get(index_torneo).GetSquadreAbilitate(g);
}


public ArrayList<Torneo> GetTornei(String codice){
        ArrayList<Torneo> t;
        if(codice==null) return t=this.tornei;
        else{
            t= new ArrayList<>();
            for (Torneo torneo : tornei) {
                if(torneo.getCodice().equals(codice))
                t.add(torneo);
                
                
            }
        }return t;
    }

    public void SimulaCreazioneTorneo(Giocatore g) throws IOException{
        int n;
        String Struttura;
        
        boolean accessibilita;
        ArrayList<String> id_regolamento;
        n = this.v.NumeroPartecipanti();
        Struttura = this.v.CreazioneTorneo();
        accessibilita = this.v.AccessibilitàTorneo();
        id_regolamento=this.v.SceltaRegolamento();
        this.OrganizzaTorneo(Struttura, n, accessibilita, id_regolamento);
        int index=this.tornei.size()-1;
       int scelta= new View().ScegliSquadra(this.VerificaConformitaSquadre(index, g.getNome()));
       this.SelezionaSquadra(g.getNome(), scelta);
       this.IscrizioneTorneo(g.getNome(), index);

    }
    public void simulaIscrizione(Giocatore g) throws IOException{
        String codice=new View().getCodiceTorneo();
        int index=new View().recuperaIndiceTorneo(this.GetTornei(codice));
        int scelta= new View().ScegliSquadra(this.VerificaConformitaSquadre(index, g.getNome()));
        this.SelezionaSquadra(g.getNome(), scelta);
        this.IscrizioneTorneo(g.getNome(), index);

    }
   

  
    public Giocatore login(String id) throws JsonSyntaxException, JsonIOException, FileNotFoundException, ClassNotFoundException{
        Giocatore g= builder.CreaGiocatore(id);
        this.online.add(g);
        return g;
    }
  

public Partita CreaPartita(String p1, String p2) throws JsonSyntaxException, JsonIOException, FileNotFoundException, ClassNotFoundException{
    Giocatore g1=null;
    Giocatore g2=null;
   for(Giocatore g: this.online){
    if(g.getNome().equals(p1))g1=g;
    if(g.getNome().equals(p2))g2=g;
   }
   if(g1==null)g1=this.login(p1);
   if(g1==null)g2=this.login(p1);
   return new Partita(g1, g2);
}

  
     public static void main(String[] args) throws IOException, JsonSyntaxException, JsonIOException, ClassNotFoundException {
        Server s= new Server();
        Giocatore g1= s.login("Mattia");
        Giocatore g2= s.login("Riccardo");
        Giocatore g3= s.login("Alessandro");
        Giocatore g4= s.login("Luca");
        s.SimulaCreazioneTorneo(g1);
        s.simulaIscrizione(g2);
        s.simulaIscrizione(g3);
        s.simulaIscrizione(g4);
        //System.out.println(new Partita(g4, g1).giocaPartita().getNome()+" vince");
    }
}
