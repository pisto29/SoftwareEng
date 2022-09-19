package Entity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Torneo {
    
        protected int NumeroPartecipanti;
        protected boolean Accessibilita;
        protected String codice;
        protected Round round;
        protected ArrayList<Regolamento> Regolamento;
        protected ArrayList<Giocatore>Partecipanti;
        protected ArrayList<String> id_regolamento;
        public Torneo(int numeroPartecipanti, Boolean accessibilita, ArrayList<String> id_regolamento) throws FileNotFoundException {
            
            this.id_regolamento=id_regolamento;
            this.Regolamento=new ArrayList<>();
            for (String string : id_regolamento) {
                Regolamento.add(CompetitionFactorySingleton.getIstanza().CreaRegolamento(string));
            }
            
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
                boolean passed=true;
                for(Regolamento r: Regolamento)
                passed=r.VerificaRegolamento(s);
                if(passed)
              SquadreAbilitate.add(s);
              else SquadreAbilitate.add(null);
            }
            return SquadreAbilitate;
            

        }
       
        public abstract ArrayList<Giocatore> AvviaTorneo() throws IOException;
        public abstract void GeneraAccoppiamenti();
        public void AvviaPartite() throws IOException{this.round.AvviaPartite();}
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

       

        public ArrayList<Giocatore> getPartecipanti() {
            return Partecipanti;
        }

        public void setPartecipanti(ArrayList<Giocatore> partecipanti) {
            Partecipanti = partecipanti;
        }

        public ArrayList<Regolamento> getRegolamento() {
            return Regolamento;
        }

        public void setRegolamento(ArrayList<Regolamento> regolamento) {
            Regolamento = regolamento;
        }

        public ArrayList<String> getId_regolamento() {
            return id_regolamento;
        }

        public void setId_regolamento(ArrayList<String> id_regolamento) {
            this.id_regolamento = id_regolamento;
        }

       public String StringForView(){
        String regole="";
        for(String s: id_regolamento)
        regole=regole.concat(s+" ");
        return this.getClass().getSimpleName()+" numeroPartecipanti "+NumeroPartecipanti+" regolamento "+regole;
       }
}
