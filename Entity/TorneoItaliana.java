package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.*;
import java.security.KeyStore.Entry;

public class TorneoItaliana extends Torneo {
public HashMap<String,Integer> classifica;


    public TorneoItaliana(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) throws FileNotFoundException {
        super(numeroPartecipanti, accessibilita, id_regolamento);
        classifica=new HashMap<>();
        
    }

    
    public void GiocaRound() {
       // this.round.AvviaPartite(Partecipanti,squadre);
        
        
    }
public void AggiornaClassifica(){
    System.out.println("Aggiornamento CLASSIFICA");
    for(String s:this.round.getRisultati()){
        this.classifica.replace(s, this.classifica.get(s), this.classifica.get(s)+1);
        System.out.println(s);
    }
    System.out.println("CLASSIFICA PARZIALE:");
    for(String k:this.classifica.keySet()){
        System.out.println(k+"  Punteggio:"+this.classifica.get(k));
    }
    
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
public static void main(String[] args) {
   /*  String[] nomi={"1","2","3","4","5","6","7","8"};
   
    nomi=i.rotate(nomi);
    nomi=i.rotate(nomi);
    for(String s: nomi)
    System.out.println(s+"\n");*/
     ///TorneoItaliana i= new TorneoItaliana(4, true);
     //i.GeneraAccoppiamenti();
}
   
    @Override
    public void Partecipa(Giocatore u) {
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
      

            this.classifica.put(u.getNome(), 0);
           // this.squadre.put(u.getNome(), s);
            this.Partecipanti.add(u);
        }else{new View().Messaggi("NoPosti");}
        if(this.Partecipanti.size()<this.NumeroPartecipanti){
            new View().CompletaTorneo(this.NumeroPartecipanti-this.Partecipanti.size());
        }
        else{new View().Messaggi("TorneoStart");
    try {
        this.esecuzione();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }
    }
        
        
    


    @Override
    public void AvviaPartite() throws IOException {
        // TODO Auto-generated method stub
        this.round.AvviaPartite(this.Partecipanti,this.id_regolamento);
        
    }

    public void Avanza(){
        this.round = new Round(this.round.getNumero()+1);
    }

   public void esecuzione() throws IOException{
    //System.out.println("Partecipanti:");
    if(!(this.round.getNumero()==0&&this.Partecipanti.size()!=this.NumeroPartecipanti)){
    while(this.round.getNumero()<this.NumeroPartecipanti-1) {
        System.out.println("ROUND NUMERO: "+ this.round.getNumero());
        this.GeneraAccoppiamenti();
        this.AvviaPartite();
        this.AggiornaClassifica();
        this.Avanza();
    }
    System.out.println("RISULTATO:");

    System.out.println(this.ris() + "  " + this.classifica.get(this.ris()));}
    else{new View().Messaggi("PartecipantiInsufficienti");}

   }
  
   private String ris(){
    int max = 0;
    String nome = "";
    for(String s : this.classifica.keySet()){
        if(this.classifica.get(s)>max){
            max = this.classifica.get(s);
            nome = s;
        }
    }
    /*for(Map.Entry<String,Integer> entry : this.classifica.entrySet()){
       
        if(entry.getValue()> max){
        max = entry.getValue();
        nome = entry.getKey();
       }      
       System.out.println(nome);
    
    }*/

    return nome;
   }

}
