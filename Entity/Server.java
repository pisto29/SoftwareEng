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
    
    public Server(){
        online=new ArrayList<>();
        tornei=new ArrayList<>();
        this.v = new View();
    }

public void OrganizzaTorneo(String Struttura_torneo,int NumeroPartecipanti,Boolean accessibilità,String id_regolamento) throws FileNotFoundException{
this.tornei.add(CompetitionFactorySingleton.getIstanza().creaTorneo(Struttura_torneo, NumeroPartecipanti, accessibilità, id_regolamento));
}
public void IscrizioneTorneo(String Username, int Index_torneo){}
public void SelezionaSquadra(String NomeGiocatore, int SquadraSelezionata){
    for (Giocatore giocatore : online) {
        if(giocatore.getNome().equals(NomeGiocatore))giocatore.setSquadraSelezionata(SquadraSelezionata);
        
    }
}
public ArrayList<Squadra>VerificaConformitaSquadre(int index_torneo,String Username){}


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
    public void inputTorneo(Giocatore g) throws IOException{
        int n;
        String id_torneo;
        
        boolean accessibilita;
        String id_regolamento;
        n = this.v.NumeroPartecipanti();
        id_torneo = this.v.CreazioneTorneo();
        accessibilita = this.v.AccessibilitàTorneo();
        id_regolamento=this.v.SceltaRegolamento();
        Torneo t=this.creaTorneo(n, id_torneo,id_regolamento,accessibilita);
        this.tornei.add(t);
        this.PartecipaTorneo(g,t);
     

        

        
    }

    private Torneo creaTorneo(int n, String id_torneo,String id_regolamento, boolean accessibilita) throws FileNotFoundException{
        Torneo t;
        switch(id_torneo){
            case "Italiana":
                t = new TorneoItaliana(n,accessibilita,id_regolamento);
                break;
            case "Eliminazione":
                t = new TorneoEliminazioneDiretta(n,accessibilita,id_regolamento);
                break;
            case "Squadre":
                t = new TorneoSquadre(n, accessibilita, id_regolamento);
                break;
            default : t = null;

        }
        return t;
    }
    public Giocatore login(String id) throws JsonSyntaxException, JsonIOException, FileNotFoundException, ClassNotFoundException{
        Giocatore g= builder.CreaGiocatore(id);
        this.online.add(g);
        return g;
    }
    public void  PartecipaTorneo(Giocatore g, Torneo t){
        this.v.inizioIscrizione(g.getNome());
            // this.classifica.put(u.getNome(), 0);
            ArrayList<Squadra> Utilizzabile=new ArrayList<>();
             int utilizzabili=0;
             for(Squadra s:g.getSquadra()){
                 if(t.getRegolamento().VerificaRegolamento(s)){
                 Utilizzabile.add(s);
                     utilizzabili++;
             }
                 else
                 Utilizzabile.add(null);
 
             }
             if(utilizzabili>0){
             try {
                 g.setSquadraSelezionata(new View().ScegliSquadra(Utilizzabile));
                 t.Partecipa(g);
             } catch (IOException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
             }}
             else{
                v.Messaggi("NoSquadre");
             }

    }

public Partita2 CreaPartita(String p1, String p2, String id_regolamento) throws JsonSyntaxException, JsonIOException, FileNotFoundException, ClassNotFoundException{
    Giocatore g1=null;
    Giocatore g2=null;
   for(Giocatore g: this.online){
    if(g.getNome().equals(p1))g1=g;
    if(g.getNome().equals(p2))g2=g;
   }
   if(g1==null)g1=this.login(p1);
   if(g1==null)g2=this.login(p1);
   return new Partita2(g1, g2, id_regolamento);
}

  /*   public static void main(String[] args) throws IOException, JsonSyntaxException, JsonIOException, ClassNotFoundException {
       /* *View v = new View();
        Server s = new Server(v);
        Torneo t;
        t = s.creaTorneo();
        Giocatore G1 = builder.CreaGiocatore("G1");
        Giocatore G2 = builder.CreaGiocatore("G2");
        Giocatore G3 = builder.CreaGiocatore("G3");
        Giocatore G4 = builder.CreaGiocatore("G4");
        Giocatore G5 = builder.CreaGiocatore("G5");

        t.Partecipa(G1);//mattia
        t.Partecipa(G3);//alessandro
        t.Partecipa(G2);//riccardo
        t.Partecipa(G5);//dino
        t.esecuzione();*
        Server s=new Server();
        Giocatore g1= s.login("Mattia");
        Giocatore g2= s.login("Riccardo");
        Giocatore g3= s.login("Alessandro");
        Giocatore g4= s.login("Luca");
       s.CreaPartita("Luca", "Alessandro", "NoRegole_").giocaPartita();
      /*    s.inputTorneo(g1);
        s.PartecipaTorneo(g2, s.GetTornei(null).get(0));
        s.PartecipaTorneo(g3, s.GetTornei(null).get(0));
        s.PartecipaTorneo(g4, s.GetTornei(null).get(0));*

    
    }*/

     public static void main(String[] args) throws JsonSyntaxException, JsonIOException, ClassNotFoundException, IOException {
        Server s=new Server();
        Giocatore g1= s.login("Mattia");
        Giocatore g2= s.login("Riccardo");
        Giocatore g3= s.login("Alessandro");
        Giocatore g4= s.login("Luca");
        TorneoSquadre2 t= new TorneoSquadre2(4, false, "NoRegole_");
        t.AggiungiPartecipante(g1);
        t.AggiungiPartecipante(g2);
        t.AggiungiPartecipante(g3);
        t.AggiungiPartecipante(g4);
        t.AvviaTorneo();
    }
}
