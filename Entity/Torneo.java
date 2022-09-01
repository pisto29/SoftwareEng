package Entity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Torneo {
    protected int NumeroPartecipanti;
    protected boolean Accessibilita;
    protected String codice;
    protected Round round;
    
    protected ArrayList<Giocatore>Partecipanti;
    protected String id_regolamento;
    public Torneo(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) {
        
        this.id_regolamento=id_regolamento;
        Partecipanti=new ArrayList<>();
        round=new Round(0);
        NumeroPartecipanti = numeroPartecipanti;
        Accessibilita = accessibilita;
        if(accessibilita){}
        else{

            // chose a Character random from this String

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        + "0123456789"

        + "abcdefghijklmnopqrstuvxyz";



// create StringBuffer size of AlphaNumericString

        StringBuilder sb = new StringBuilder(5);



        for (int i = 0; i < 5; i++) {



        // generate a random number between

        // 0 to AlphaNumericString variable length

        int index = (int)(AlphaNumericString.length()* Math.random());



        // add Character one by one in end of sb

        sb.append(AlphaNumericString.charAt(index));

}


        this.codice=sb.toString();
        //return sb.toString();
        }
    }
    public abstract void InvitaPartecipanti(ArrayList<String> nominativi);
    public abstract void Partecipa(Giocatore u);
    public abstract void AvviaPartite() throws IOException;
    public abstract void GeneraAccoppiamenti();

    public void Avanza(){

        this.round = new Round(this.round.getNumero()+1);

    }

    public void esecuzione() throws IOException{

        
    }



}






