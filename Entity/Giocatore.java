package Entity;
import java.util.Scanner;

public class Giocatore {
    private String nome;
    private int punteggio;
    private Squadra squadra;
    private Strumento[] strumentos;
    private Matchmaking matchmaking;

    public Giocatore(String nome, int punteggio, Squadra squadra, Strumento[] strumentos, Matchmaking matchmaking) {
        this.nome = nome;
        this.punteggio = punteggio;
        this.squadra = squadra;
        this.strumentos = strumentos;
        this.matchmaking = matchmaking;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public Squadra getSquadra() {
        return squadra;
    }

    public void setSquadra(Squadra squadra) {
        this.squadra = squadra;
    }

    public Strumento[] getStrumentos() {
        return strumentos;
    }

    public void setStrumentos(Strumento[] strumentos) {
        this.strumentos = strumentos;
    }

    public Matchmaking getMatchmaking() {
        return matchmaking;
    }

    public void setMatchmaking(Matchmaking matchmaking) {
        this.matchmaking = matchmaking;
    }
    
    public int GetInput(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli un'azione:");
        System.out.println("1) ATTACCA");
        System.out.println("2) SOSTITUZIONE");
        System.out.println("3) STRUMENTO");
        int scelta = scanner.nextInt();
        scanner.close();
        if(scelta<1||scelta>3){
            System.out.println("Scelta non valida insersici un valore tra 1 e 3");
            GetInput();
        }
        return scelta;

    }
}
