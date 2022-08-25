package Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import java.security.KeyStore.Entry;;

public class TorneoItaliana extends Torneo {
public HashMap<String,Integer> classifica;
public ArrayList<HashMap<Giocatore,Squadra>>Partecipanti;

    public TorneoItaliana(int numeroPartecipanti, Boolean accessibilita) {
        super(numeroPartecipanti, accessibilita);
        classifica=new HashMap<>();
        Partecipanti=new ArrayList<>();
    }

    @Override
    public void AvviaPartite() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void GeneraAccoppiamenti() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void InvitaPartecipanti(ArrayList<String> nominativi) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void Partecipa(Giocatore u, Squadra s) {
        // TODO Auto-generated method stub
        
    }

   
  
    

}
