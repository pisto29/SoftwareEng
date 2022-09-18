package Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    private HashMap <Giocatore,Giocatore> Accoppiamenti;
    private ArrayList<Partita>Partite;
    private ArrayList<String>Risultati;
    private int numero;
    
    public Round( int numero) {
        Partite = new ArrayList<>();
        this.numero = numero;
        Accoppiamenti = new HashMap<>();
        Risultati = new ArrayList<>();
    }

    public void AvviaPartite(String id_regolamento) throws IOException{
        System.out.println("Round iniziato");
        int u=1;
        for(Giocatore g: Accoppiamenti.keySet()){
            //System.out.println("STAMPO S ACCOPPIAMENTI");
            //System.out.println(s);
            Giocatore g1=null;
            Giocatore g2=null;
            g1=g;
            g2=Accoppiamenti.get(g1);
            
        /*    for(Giocatore g: Partecipanti){
            //System.out.println("NOMI GIOCATORI: ");
            if(g.getNome().equals(s)){
                g1=g;
                //s1=squadre.get(s);
                //System.out.println(g1.getNome());
            }
            if(g.getNome().equals(Accoppiamenti.get(s))){
                g2=g;
                //s2=squadre.get(Accoppiamenti.get(s));
                //System.out.println(g2.getNome());
            }
           }*/
           //crea la partita
            //Partite.add(new Partita(g1, g2));
            //Risultati.add(new Partita(g1,g2).EseguiPartita().getNome());
            System.out.println("Inizia la Partita tra :"+ " "+ g1.getNome()+" e "+g2.getNome());
            
            String c="";
            if(this.numero==0&&u==0){
                 c = new Partita2(g1,g2,id_regolamento).giocaPartita().getNome();
                u++;
                System.out.println("La partita è stata vinta da: "+c);
            
                Risultati.add(c);
            }
            else{
             c = new Partita(g1,g2,id_regolamento).simula().getNome();
            System.out.println("La partita è stata vinta da: "+c);
            
            Risultati.add(c);}
            
            
  //gioca o simula partita e memorizza il risultato classe partita da modificare
           }

         
        }
    

    public ArrayList<Partita> getPartite() {
        return Partite;
    }

    public void setPartite(ArrayList<Partita> partite) {
        Partite = partite;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void aggiungiAccoppiamento(Giocatore p1,Giocatore p2){
        this.Accoppiamenti.put(p1, p2);
    }

    public HashMap<String, String> getAccoppiamenti() {
        return Accoppiamenti;
    }

    public void setAccoppiamenti(HashMap<String, String> accoppiamenti) {
        Accoppiamenti = accoppiamenti;
    }

    public ArrayList<String> getRisultati() {
        return Risultati;
    }

    public void setRisultati(ArrayList<String> risultati) {
        Risultati = risultati;
    }
    
}
