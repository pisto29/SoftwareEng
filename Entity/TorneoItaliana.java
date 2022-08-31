package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.security.KeyStore.Entry;

public class TorneoItaliana extends Torneo {
public HashMap<String,Integer> classifica;


    public TorneoItaliana(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) {
        super(numeroPartecipanti, accessibilita, id_regolamento);
        classifica=new HashMap<>();
        
    }

    
    public void GiocaRound() {
        this.round.AvviaPartite(Partecipanti,squadre);
        
        
    }
public void AggiornaClassifica(){
    for(String s:this.round.getRisultati()){
        this.classifica.replace(s, this.classifica.get(s), this.classifica.get(s)+1);
    }
}
    @Override
    public void GeneraAccoppiamenti() {
        String nomi[]=new String[this.NumeroPartecipanti];
       int i=0;
       for(String s: this.classifica.keySet()){
        nomi[i]=s;
       }
       //
       //String[] nomi={"1","2","3","4","5","6","7","8"};
       for(int c=0;c<=this.round.getNumero();c++){
        nomi=this.rotate(nomi);
       }
       int z=nomi.length-1;
        for(int h=0; h<=nomi.length/2-1;h++){
           this.round.aggiungiAccoppiamento(nomi[h], nomi[z]);
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
        }

        appoggio=nomi[nomi.length-1];
        for(int i=1;i<nomi.length-1;i++){
            nomi[i+1]=temp[i];
        }
        nomi[1]=temp[temp.length-1];
        return nomi;
    }
public static void main(String[] args) {
   /*  String[] nomi={"1","2","3","4","5","6","7","8"};
   
    nomi=i.rotate(nomi);
    nomi=i.rotate(nomi);
    for(String s: nomi)
    System.out.println(s+"\n");*/
     TorneoItaliana i= new TorneoItaliana(4, true);
     i.GeneraAccoppiamenti();
}
    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub

        
    }

    @Override
    public void Partecipa(Giocatore u, Squadra s) {
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
            this.classifica.put(u.getNome(), 0);
            this.squadre.put(u.getNome(), s);
            this.Partecipanti.add(u);
        }
        
    }


    @Override
    public void AvviaPartite() {
        // TODO Auto-generated method stub
        
    }

   
  
    

}
