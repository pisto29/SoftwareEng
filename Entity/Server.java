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
        String id_regolamento;
        n = this.v.NumeroPartecipanti();
        id_torneo = this.v.CreazioneTorneo();
        accessibilita = this.v.AccessibilitàTorneo();
        id_regolamento=this.v.SceltaRegolamento();

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
    



    public static void main(String[] args) throws IOException {
        View v = new View();
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
        t.esecuzione();
    
    }
}
