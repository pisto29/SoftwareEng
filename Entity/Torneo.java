package Entity;

import java.util.ArrayList;

public abstract class Torneo {
    private int NumeroPartecipanti;
    private boolean Accessibilita;
    private String codice;
    public Torneo(int numeroPartecipanti, Boolean accessibilita) {
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

int index

= (int)(AlphaNumericString.length()

* Math.random());



// add Character one by one in end of sb

sb.append(AlphaNumericString.charAt(index));

}


this.codice=sb.toString();
//return sb.toString();
        }
    }
    public abstract void InvitaPartecipanti(ArrayList<String> nominativi);
    public abstract void Partecipa(Giocatore u, Squadra s);
    public abstract void AvviaPartite();
    public abstract void GeneraAccoppiamenti();
}
