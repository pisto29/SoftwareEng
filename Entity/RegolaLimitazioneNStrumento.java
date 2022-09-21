package Entity;

public class RegolaLimitazioneNStrumento extends Regolamento {
private int NumeroStrumenti;

    public RegolaLimitazioneNStrumento(RegolaLimitazioneNStrumento R) {super(R.getId());
        this.NumeroStrumenti=R.getNumeroStrumenti();
        
}
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        if(s.getStrumentos().size()!=NumeroStrumenti)check=false;
        return check;
    }
    public int getNumeroStrumenti() {
        return NumeroStrumenti;
    }
    public void setNumeroStrumenti(int numeroStrumenti) {
        NumeroStrumenti = numeroStrumenti;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "RegolaLimitazioneNStrumento [NumeroStrumenti=" + NumeroStrumenti + ", id=" + id + "]";
    }
    
}
