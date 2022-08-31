package Entity;

import java.util.ArrayList;

public class TorneoEliminazioneDiretta extends Torneo {

    public TorneoEliminazioneDiretta(int numeroPartecipanti, Boolean accessibilita) {
        super(numeroPartecipanti, accessibilita);
    }
    public void GestisciPartecipanti(){
        for(Giocatore g: this.Partecipanti){
            if(!this.round.getRisultati().contains(g.getNome())){
            this.Partecipanti.remove(g);
        this.NumeroPartecipanti=this.NumeroPartecipanti-1;
        }
        }
    }
    @Override
    public void AvviaPartite() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        
        for(int i=0;i<=this.NumeroPartecipanti-2;i=i+2)
        //System.out.println(i+" e"+(i+1));
        
        this.round.aggiungiAccoppiamento(this.Partecipanti.get(i).getNome(), this.Partecipanti.get(i+1).getNome());
        
    }
public static void main(String[] args) {
 TorneoEliminazioneDiretta e=new TorneoEliminazioneDiretta(8, true)  ;
 e.GeneraAccoppiamenti(); 
}
    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Partecipa(Giocatore u, Squadra s) {
        // TODO Auto-generated method stub
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
           // this.classifica.put(u.getNome(), 0);
            this.squadre.put(u.getNome(), s);
            this.Partecipanti.add(u);
        }
    }
    
}
