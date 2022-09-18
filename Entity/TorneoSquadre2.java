package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TorneoSquadre2 extends Torneo2 {
    public ArrayList<Giocatore> Squadra1;
    public ArrayList<Giocatore>Squadra2;
    public HashMap<String,Integer>Punteggio;
    public TorneoSquadre2(int numeroPartecipanti, Boolean accessibilita, String id_regolamento)
            throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
        Squadra1=new ArrayList<>();
        Squadra2=new ArrayList<>();
        Punteggio=new HashMap<>();
        Punteggio.put("Squadra1", 0);
        Punteggio.put("Squadra2", 0);
    }

    @Override
    public void AggiornaRisultati() {
        // TODO Auto-generated method stub
        ArrayList<String> Risultati=this.round.getRisultati();
        int counter1=0;
        int counter2=0;
        boolean found=false;
        for(String s: Risultati)
        
        {found=false;
            for(Giocatore g: this.Squadra1)
            if(g.getNome().equals(s)){
                counter1++;
                found=true;
    
            }
            if(!found)counter2++;
    
        }
        if(counter1>counter2){
            this.Punteggio.replace("Squadra1", this.Punteggio.get("Squadra1"), this.Punteggio.get("Squadra1")+1);
            System.out.println("ROUND VINTO DA SQUADRA 1");
        }
        if(counter1<counter2){
            this.Punteggio.replace("Squadra2", this.Punteggio.get("Squadra2"), this.Punteggio.get("Squadra2")+1);
            System.out.println("ROUND VINTO DA SQUADRA 2");
        }
        if(counter1 == counter2){
            System.out.println("ROUND TERMINATO IN PARITA");  
        }

    }
    private void setup(){
        int n=0;
        for(Giocatore g: Partecipanti){
        if(n<NumeroPartecipanti/2){
        this.Squadra1.add(g);
        n++;
    }
    else this.Squadra2.add(g);}
    }

    @Override
    public ArrayList<Giocatore> AvviaTorneo() throws IOException {
        this.setup();
        // TODO Auto-generated method stub
        while(this.Punteggio.get("Squadra1")< 2 && this.Punteggio.get("Squadra2")< 2) {
            //System.out.print("WHILE");
            this.GeneraAccoppiamenti();
            this.AvviaPartite();
            this.AggiornaRisultati();
            this.avanza();
        }
        return this.TrovaVincitore();
    }

    @Override
    public void GeneraAccoppiamenti() {
        // TODO Auto-generated method stub
        ArrayList <Integer> picked1=new ArrayList<>();
        ArrayList <Integer> picked2=new ArrayList<>();
        boolean end=false;
        Random r = new Random();
        while(!end){
            int n1= new Random().nextInt((NumeroPartecipanti/2));
           
            int n2 = new Random().nextInt(NumeroPartecipanti/2, NumeroPartecipanti);
            
            
            
            
            while(picked1.contains(n1)){
                
                //System.out.println("while1");
                n1= r.nextInt((NumeroPartecipanti/2));
                //System.out.println(n1);
            }
            while(picked2.contains(n2)){
                //System.out.println("while2");
                n2= new Random().nextInt(NumeroPartecipanti/2, NumeroPartecipanti);
            }

            picked1.add(n1);
            picked2.add(n2);
            this.round.aggiungiAccoppiamento(this.Partecipanti.get(n1), this.Partecipanti.get(n2));
            if(picked1.size()==(NumeroPartecipanti/2)&&picked2.size()==(NumeroPartecipanti/2)){
            end=true;
            
            }
            

        }
        
    }

    @Override
    public ArrayList<Giocatore> TrovaVincitore() {
        if(this.Punteggio.get("Squadra1") == 2){
        System.out.println("vince squadra 1");
        return this.Squadra1;}
       else  {
        System.out.println("vince squadra 2");
        return this.Squadra2;}
    }
    
}
