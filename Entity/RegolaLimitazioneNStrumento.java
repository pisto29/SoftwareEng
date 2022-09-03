package Entity;

public class RegolaLimitazioneNStrumento implements RegolamentoComponent {
private int NumeroStrumenti;
private String id;
    public RegolaLimitazioneNStrumento(RegolaLimitazioneNStrumento R) {
        this.NumeroStrumenti=R.getNumeroStrumenti();
        this.id=R.getId();
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
