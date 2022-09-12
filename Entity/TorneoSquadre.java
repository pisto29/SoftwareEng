package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TorneoSquadre extends Torneo{
public ArrayList<Giocatore> Squadra1;
public ArrayList<Giocatore>Squadra2;
public HashMap<String,Integer>Punteggio;
    public TorneoSquadre(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
        Squadra1=new ArrayList<>();
        Squadra2=new ArrayList<>();
        Punteggio=new HashMap<>();
        Punteggio.put("Squadra1", 0);
        Punteggio.put("Squadra2", 0);
        
    }

    @Override
    public void AvviaPartite() throws IOException {
        // TODO Auto-generated method stub
        this.round.AvviaPartite(this.Partecipanti,this.id_regolamento);
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        //System.out.print("GENERA ACCOPPIAMENTI");
        ArrayList <Integer> picked1=new ArrayList<>();
        ArrayList <Integer> picked2=new ArrayList<>();
        boolean end=false;
        Random r = new Random();
        while(!end){
            int n1= new Random().nextInt((NumeroPartecipanti/2));
            //int n2= new Random().nextInt(NumeroPartecipanti-1);
            int n2 = new Random().nextInt(NumeroPartecipanti/2, NumeroPartecipanti);
            
            
            
            //System.out.println("NUM PARTECIPANTI: ");
            //System.out.println((NumeroPartecipanti/2));
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
            this.round.aggiungiAccoppiamento(this.Partecipanti.get(n1).getNome(), this.Partecipanti.get(n2).getNome());
            if(picked1.size()==(NumeroPartecipanti/2)&&picked2.size()==(NumeroPartecipanti/2)){
            end=true;
            //System.out.println("FINITO");
            }
            //System.out.println("P1:");
            //(System.out.println(picked1.size());
            //System.out.println("P2:");
            //System.out.println(picked2.size());

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
    if(counter1>counter2){
        this.Punteggio.replace("Squadra1", this.Punteggio.get("Squadra1"), this.Punteggio.get("Squadra1")+1);
        System.out.println("ROUND VINTO DA SQUADRA 1");
    }
    if(counter1<counter2){
        this.Punteggio.replace("Squadra2", this.Punteggio.get("Squadra2"), this.Punteggio.get("Squadra2")+1);
        System.out.println("ROUND VINTO DA SQUADRA 2");
    }
}
    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Partecipa(Giocatore u) {
        // TODO Auto-generated method stub
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
            // this.classifica.put(u.getNome(), 0);
          
             this.Partecipanti.add(u);
            if(this.Partecipanti.size()<=this.NumeroPartecipanti/2){
                Squadra1.add(u);
            }
            else{
                Squadra2.add(u);
            }
             }
             else{new View().Messaggi("NoPosti");}
     

    }

    public void esecuzione() throws IOException{
        
        if(!(this.round.getNumero()==0&&this.Partecipanti.size()!=this.NumeroPartecipanti)){
        while(this.Punteggio.get("Squadra1")< 2 && this.Punteggio.get("Squadra2")< 2) {
            //System.out.print("WHILE");
            this.GeneraAccoppiamenti();
            this.AvviaPartite();
            this.aggiornaPunteggio();
            this.Avanza();
        }

        if(this.Punteggio.get("Squadra1") == 2)
         System.out.println("vince squadra 1");
        else  
         System.out.println("vince squadra 2");
        
        }
    }


    public static void main(String[] args) {
        Random r = new Random();

        while(true){
            System.out.println(r.nextInt(2, 4));
        }
    }
    
}
