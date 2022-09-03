package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class TorneoEliminazioneDiretta extends Torneo {

    public TorneoEliminazioneDiretta(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
    }
    /*public void GestisciPartecipanti(){
        int i=1;
        for(Giocatore g: this.Partecipanti){
            System.out.println("Gestisci Partecipanti");
            //System.out.println(g);
            if(!this.round.getRisultati().contains(g.getNome())){
            this.Partecipanti.remove(g);
            this.NumeroPartecipanti=this.NumeroPartecipanti-1;
            System.out.println(i);
            i = i+1;
        }
        }
    }*/


    public void GestisciPartecipanti(){
        //int j=1;
        for(int i=0 ; i<this.Partecipanti.size(); i++){
            //System.out.println("Gestisci Partecipanti");
           // System.out.println(this.Partecipanti.get(i).getNome());
            //System.out.println(this.Partecipanti.get(i));
            if(!this.round.getRisultati().contains(this.Partecipanti.get(i).getNome())){
                System.out.println("SI RIMUOVE:");
                System.out.println(this.Partecipanti.get(i).getNome());
                this.Partecipanti.remove(this.Partecipanti.get(i));
                this.NumeroPartecipanti=this.NumeroPartecipanti-1;
        }
            //System.out.println(j);
            //j = j+1;
        }
        System.out.println("GIOCATORI RIMANENTI:"); 

        for (Giocatore giocatore : Partecipanti) {
            System.out.println(giocatore.getNome());    
        }
    }   





    @Override
    public void AvviaPartite() throws IOException {
        // TODO Auto-generated method stub
        this.round.AvviaPartite(this.Partecipanti);
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        
        for(int i=0;i<=this.NumeroPartecipanti-2;i=i+2){
        //System.out.println(i+" e"+(i+1));
        System.out.println("coppia");
        System.out.println(this.Partecipanti.get(i).getNome()+"  ---  "+this.Partecipanti.get(i+1).getNome());
        this.round.aggiungiAccoppiamento(this.Partecipanti.get(i).getNome(), this.Partecipanti.get(i+1).getNome());
        }
        
    }
/*public static void main(String[] args) {
 //TorneoEliminazioneDiretta e=new TorneoEliminazioneDiretta(8, true)  ;
 e.GeneraAccoppiamenti(); 
}*/
    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Partecipa(Giocatore u) {
        // TODO Auto-generated method stub
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
           // this.classifica.put(u.getNome(), 0);
           ArrayList<Squadra> Utilizzabile=new ArrayList<>();
            int utilizzabili=0;
            for(Squadra s:u.getSquadra()){
                if(this.Regolamento.VerificaRegolamento(s)){
                Utilizzabile.add(s);
                    utilizzabili++;
            }
                else
                Utilizzabile.add(null);

            }
            if(utilizzabili>0){
            try {
                u.setSquadraSelezionata(new View().ScegliSquadra(Utilizzabile));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.Partecipanti.add(u);
            }
            else{new View().Messaggi("NoSquadre");}
    }
    }
    
    public void esecuzione() throws IOException{

        if(!(this.round.getNumero()==0&&this.Partecipanti.size()!=this.NumeroPartecipanti)){
            while(this.NumeroPartecipanti> 1) {
                this.GeneraAccoppiamenti();
                this.AvviaPartite();
                this.GestisciPartecipanti();
                this.Avanza();
         }
            System.out.println("il vincitore è ");
            for (Giocatore g : this.Partecipanti) {
                System.out.println(g.getNome()); 
            }
        }
        else{new View().Messaggi("PartecipantiInsufficienti");}

    
        
    
       }
      

}
