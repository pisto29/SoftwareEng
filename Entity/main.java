package Entity;

public class main {

    public static void main(String[] args) {

        Partita p = new Partita(null, null);
        while(!p.WinG1()&&!p.WinG2()){
            if(p.getT().getNumturno()==0){
                p.player1.getSquadra().getPersonaggios().get(0).setRuolo(Attivo);
                p.player2.getSquadra().getPersonaggios().get(0).setRuolo(Attivo);
            }
        }

        
    }
    
}
