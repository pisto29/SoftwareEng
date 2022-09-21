package Entity;

import java.io.IOException;

public class ArbitroSingleton {
    public static ArbitroSingleton istanza;
    private ArbitroSingleton() {
    }
    public static ArbitroSingleton getIstanza(){
        if(istanza==null) istanza= new ArbitroSingleton();
        return istanza;
    }
    public Giocatore TrovaVincitore (Giocatore g1, Giocatore g2){
        Giocatore Vincitore=null;
        if(g1.SquadraKo())Vincitore=g2;
        if(g2.SquadraKo())Vincitore=g1;
        return Vincitore;
    }

    public void CambioPerKo(Turno t, Giocatore player1, Giocatore player2) throws IOException{
        if(t.checkKo("g1")){
           
            System.out.println(t.getP1().getNomePersonaggio()+" è andato ko");
            Personaggio p=player1.MandaProssimo();
            p.VaiInCampo();
            System.out.println(player1.getNome()+" manda in campo "+p.getNomePersonaggio());
            t.setP1(p);
            
        }
        if(t.checkKo("g2")){
            
            
            Personaggio p=player2.MandaProssimo();
            p.VaiInCampo();
            System.out.println(player2.getNome()+" manda in campo "+p.getNomePersonaggio());
            t.setP2(p);
    }
}}
