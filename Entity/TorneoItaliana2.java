package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TorneoItaliana2 extends Torneo2{
    public HashMap<String,Integer> classifica;
    public TorneoItaliana2(int numeroPartecipanti, Boolean accessibilita, String id_regolamento)
            throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
        classifica=new HashMap<>();
    }

    @Override
    public void AggiornaRisultati() {
        // TODO Auto-generated method stub
        System.out.println("Aggiornamento CLASSIFICA");
        for(String s:this.round.getRisultati()){
            this.classifica.replace(s, this.classifica.get(s), this.classifica.get(s)+1);
           
        }
        System.out.println("CLASSIFICA PARZIALE:");
        for(String k:this.classifica.keySet()){
            System.out.println(k+"  Punteggio:"+this.classifica.get(k));
        }
    }
private void setup(){
    for (Giocatore g : Partecipanti) {
        this.classifica.put(g.getNome(), 0);
    }
}
    @Override
    public ArrayList<Giocatore> AvviaTorneo() throws IOException {
        this.setup();
        // TODO Auto-generated method stub
        while(this.round.getNumero()<this.NumeroPartecipanti-1) {
            System.out.println("ROUND NUMERO: "+ this.round.getNumero());
            this.GeneraAccoppiamenti();
            this.AvviaPartite();
            this.AggiornaRisultati();
            this.avanza();
        }
        
        return this.TrovaVincitore();
    }

    @Override
    public void GeneraAccoppiamenti() {
        String nomi[]=new String[this.NumeroPartecipanti];
        int i=0;
        for(String s: this.classifica.keySet()){
         nomi[i]=s;
         i++;
         //System.out.println(s);
        }
        //
        //String[] nomi={"1","2","3","4","5","6","7","8"};
        for(int c=0;c<=this.round.getNumero();c++){
         nomi=this.rotate(nomi);
        }
        //System.out.println("INIZIO");
        for (String n : nomi) {
            // System.out.println(n);
        }
        //System.out.println("FINE");
        int z=nomi.length-1;
         for(int h=0; h<=nomi.length/2-1;h++){
            Giocatore g1=null;
            Giocatore g2=null;
            for(Giocatore g: Partecipanti){
                if(g.getNome().equals(nomi[h]))
                g1=g;
                if(g.getNome().equals(nomi[z]))
                g2=g;
            }
            this.round.aggiungiAccoppiamento(g1, g2);
            //
            System.out.println("coppia"+nomi[h]+nomi[z]);
             z--;
         
         }
        
    }

    private String[] rotate(String[] nomi){
        String appoggio="";
        String[] temp=new String[nomi.length];
        for(int i=0;i<nomi.length;i++){
            temp[i]=nomi[i];
            /*System.out.println("Temp[i] è:");
            System.out.println((temp[i]));
            System.out.println("nomi[i] è:");
            System.out.println(nomi[i]);*/
        }
        

        appoggio=nomi[nomi.length-1];
        for(int i=1;i<nomi.length-1;i++){
            nomi[i+1]=temp[i];
        }
        nomi[1]=temp[temp.length-1];
        return nomi;
    }

    @Override
    public ArrayList<Giocatore> TrovaVincitore() {
        // TODO Auto-generated method stub
        int max = 0;
    String nome = "";
    for(String s : this.classifica.keySet()){
        if(this.classifica.get(s)>max){
            max = this.classifica.get(s);
            nome = s;
        }

    }        ArrayList<Giocatore> Vincitore=new ArrayList<>();
        for(Giocatore g: Partecipanti)
        if(g.getNome().equals(nome))Vincitore.add(g);
        System.out.println("Il vincitore è "+nome);
    return Vincitore;
    }

   
}
