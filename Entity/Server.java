package Entity;

import java.io.IOException;

import Foundation.builder;

public class Server {

    private View v;
    
    public Server(View v){
        this.v = v;
    }
    
    public Torneo creaTorneo() throws IOException{
        int n;
        String id_torneo;
        Torneo t;
        boolean accessibilita;
        n = this.v.NumeroPartecipanti();
        id_torneo = this.v.CreazioneTorneo();
        accessibilita = this.v.AccessibilitàTorneo();

        switch(id_torneo){
            case "Italiana":
                t = new TorneoItaliana(n,accessibilita,null);
                break;
            case "Eliminazione":
                t = new TorneoEliminazioneDiretta(n,accessibilita,null);
                break;
            case "Squadre":
                t = new TorneoSquadre(n, accessibilita, null);
                break;
            default : t = null;

        }

        return t;

        
    }
    



    public static void main(String[] args) throws IOException {
        View v = new View();
        Server s = new Server(v);
        Torneo t;
        t = s.creaTorneo();
        Giocatore G1 = builder.CreaGiocatore("G1");
        Giocatore G2 = builder.CreaGiocatore("G2");
        Giocatore G3 = builder.CreaGiocatore("G3");
        Giocatore G4 = builder.CreaGiocatore("G4");
        t.Partecipa(G1);
        t.Partecipa(G2);
        t.Partecipa(G3);
        t.Partecipa(G4);
        t.esecuzione();
    
    }
}
