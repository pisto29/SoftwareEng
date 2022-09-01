package Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    private HashMap <String,String> Accoppiamenti;
    private ArrayList<Partita>Partite;
    private ArrayList<String>Risultati;
    private int numero;
    
    public Round( int numero) {
        Partite = new ArrayList<>();
        this.numero = numero;
        Accoppiamenti = new HashMap<>();
        Risultati = new ArrayList<>();
    }

    public void AvviaPartite(ArrayList<Giocatore>Partecipanti) throws IOException{
        for(String s: Accoppiamenti.keySet()){
            //System.out.println("STAMPO S ACCOPPIAMENTI");
            //System.out.println(s);
            Giocatore g1=null;
            Giocatore g2=null;
            Squadra s1=null;
            Squadra s2=null;
           for(Giocatore g: Partecipanti){
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
           }
           //crea la partita
            //Partite.add(new Partita(g1, g2));
            //Risultati.add(new Partita(g1,g2).EseguiPartita().getNome());
            String c = new Partita(g1,g2).simula().getNome();
            System.out.println("Vincitore:");
            System.out.println(c);
            Risultati.add(c);
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

    public void aggiungiAccoppiamento(String p1,String p2){
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
