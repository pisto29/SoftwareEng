package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TorneoEliminazioneDiretta extends Torneo {

    public TorneoEliminazioneDiretta(int numeroPartecipanti, Boolean accessibilita, ArrayList<String> id_regolamento)
            throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
    }

    @Override
    public void AggiornaRisultati() {
      ArrayList<String> Risultati=this.round.getRisultati();
        for(int i=0 ; i<this.Partecipanti.size(); i++){
          
            if(!Risultati.contains(this.Partecipanti.get(i).getNome())){
                System.out.println(" è stato eliminato");
                System.out.println(this.Partecipanti.get(i).getNome());
                this.Partecipanti.remove(this.Partecipanti.get(i));
                
        }
            
        }
        System.out.println("i giocatori rimanenti sono:"); 

        for (Giocatore giocatore : Partecipanti) {
            System.out.println(giocatore.getNome());    
        }

        
    }

    @Override
    public ArrayList<Giocatore> AvviaTorneo() throws IOException {
        while(this.Partecipanti.size()>1) {
            this.GeneraAccoppiamenti();
            this.AvviaPartite();
            this.AggiornaRisultati();
            this.avanza();
     }
     ArrayList<Giocatore>Vincitore= this.TrovaVincitore();
        System.out.println("il vincitore è ");
        for (Giocatore g : Vincitore) {
            System.out.println(g.getNome()); 
        }
        return Vincitore;
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        for(int i=0;i<=this.Partecipanti.size()-2;i=i+2){
            
            System.out.println("coppia");
            System.out.println(this.Partecipanti.get(i).getNome()+"  ---  "+this.Partecipanti.get(i+1).getNome());
            this.round.aggiungiAccoppiamento(this.Partecipanti.get(i), this.Partecipanti.get(i+1));
            }
       
        
    }

    @Override
    public ArrayList<Giocatore> TrovaVincitore() {
        // TODO Auto-generated method stub
        return this.Partecipanti;
    }
    
}
