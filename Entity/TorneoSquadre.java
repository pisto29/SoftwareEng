package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TorneoSquadre extends Torneo{
public ArrayList<Giocatore> Squadra1;
public ArrayList<Giocatore>Squadra2;
public HashMap<String,Integer>Punteggio;
    public TorneoSquadre(int numeroPartecipanti, Boolean accessibilita) {
        super(numeroPartecipanti, accessibilita);
        Squadra1=new ArrayList<>();
        Squadra2=new ArrayList<>();
        Punteggio=new HashMap<>();
    }

    @Override
    public void AvviaPartite() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        ArrayList <Integer> picked1=new ArrayList<>();
        ArrayList <Integer> picked2=new ArrayList<>();
        boolean end=false;
        while(!end){
            int n1= new Random().nextInt(NumeroPartecipanti-1);
            int n2= new Random().nextInt(NumeroPartecipanti-1);
            while(picked1.contains(n1))
            n1= new Random().nextInt(NumeroPartecipanti-1);
            while(picked2.contains(n2))
            n2= new Random().nextInt(NumeroPartecipanti-1);
            picked1.add(n1);
            picked2.add(n2);
            this.round.aggiungiAccoppiamento(this.Partecipanti.get(n1).getNome(), this.Partecipanti.get(n2).getNome());
            if(picked1.size()==NumeroPartecipanti&&picked2.size()==NumeroPartecipanti)
            end=true;

        }
        
    
    }
public void aggiornaPunteggio(){
    int counter1=0;
    int counter2=0;
    boolean found=false;
    for(String s: this.round.getRisultati())
    
    {found=false;
        for(Giocatore g: this.Squadra1)
        if(g.getNome().equals(s)){
            counter1++;
            found=true;

        }
        if(!found)counter2++;

    }
    if(counter1>counter2)this.Punteggio.replace("Squadra1", this.Punteggio.get("Squadra1"), this.Punteggio.get("Squadra1")+1);
    if(counter1<counter2)this.Punteggio.replace("Squadra2", this.Punteggio.get("Squadra2"), this.Punteggio.get("Squadra2")+1);
}
    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Partecipa(Giocatore u, Squadra s) {
        // TODO Auto-generated method stub
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
            
            this.squadre.put(u.getNome(), s);
            this.Partecipanti.add(u);
            if(this.Partecipanti.size()<=this.NumeroPartecipanti/2){
                Squadra1.add(u);
            }
            else{
                Squadra2.add(u);
            }
        }
        
    }
    
}
