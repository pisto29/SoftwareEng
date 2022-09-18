package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Torneo2 {
    
        protected int NumeroPartecipanti;
        protected boolean Accessibilita;
        protected String codice;
        protected Round round;
        protected RegolamentoComponent Regolamento;
        protected ArrayList<Giocatore>Partecipanti;
        protected String id_regolamento;
        public Torneo2(int numeroPartecipanti, Boolean accessibilita, String id_regolamento) throws FileNotFoundException {
            
            this.id_regolamento=id_regolamento;
            this.Regolamento=CompetitionFactorySingleton.getIstanza().CreaRegolamento(id_regolamento);
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

        public int AggiungiPartecipante(Giocatore g){
            this.Partecipanti.add(g);
            return this.Partecipanti.size();
        }
        public ArrayList<Squadra>GetSquadreAbilitate(Giocatore g){
            ArrayList<Squadra>  Squadre=g.getSquadra();
            ArrayList<Squadra>SquadreAbilitate= new ArrayList<>();
            for (Squadra s : Squadre) {
              if( this.Regolamento.VerificaRegolamento(s))
              SquadreAbilitate.add(s);
              else SquadreAbilitate.add(null);
            }
            return SquadreAbilitate;
            

        }
       
        public abstract ArrayList<Giocatore> AvviaTorneo() throws IOException;
        public abstract void GeneraAccoppiamenti();
        public void AvviaPartite() throws IOException{this.round.AvviaPartite(this.id_regolamento);}
        public abstract void AggiornaRisultati();
        public void avanza(){
            this.round=this.createRound(this.round.getNumero()+1);
        }

        public Round createRound(int numero){
            return new Round(numero);

        }
        public abstract ArrayList<Giocatore>TrovaVincitore();

        public int getNumeroPartecipanti() {
            return NumeroPartecipanti;
        }

        public void setNumeroPartecipanti(int numeroPartecipanti) {
            NumeroPartecipanti = numeroPartecipanti;
        }

        public boolean isAccessibilita() {
            return Accessibilita;
        }

        public void setAccessibilita(boolean accessibilita) {
            Accessibilita = accessibilita;
        }

        public String getCodice() {
            return codice;
        }

        public void setCodice(String codice) {
            this.codice = codice;
        }

        public Round getRound() {
            return round;
        }

        public void setRound(Round round) {
            this.round = round;
        }

        public RegolamentoComponent getRegolamento() {
            return Regolamento;
        }

        public void setRegolamento(RegolamentoComponent regolamento) {
            Regolamento = regolamento;
        }

        public ArrayList<Giocatore> getPartecipanti() {
            return Partecipanti;
        }

        public void setPartecipanti(ArrayList<Giocatore> partecipanti) {
            Partecipanti = partecipanti;
        }

        public String getId_regolamento() {
            return id_regolamento;
        }

        public void setId_regolamento(String id_regolamento) {
            this.id_regolamento = id_regolamento;
        }
}
