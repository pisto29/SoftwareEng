package Entity;

public class RegolaLimitazioneNPersonaggi extends Regolamento {
private int  NumeroPersonaggi;

 
    public RegolaLimitazioneNPersonaggi(RegolaLimitazioneNPersonaggi R) {
        super(R.getId());
        this.NumeroPersonaggi=R.getNumeroPersonaggi();
       
}
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        if(s.getPersonaggios().size()!=NumeroPersonaggi)check=false;
        return check;
    }
    public int getNumeroPersonaggi() {
        return NumeroPersonaggi;
    }
    public void setNumeroPersonaggi(int numeroPersonaggi) {
        NumeroPersonaggi = numeroPersonaggi;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "RegolaLimitazioneNPersonaggi [NumeroPersonaggi=" + NumeroPersonaggi + ", id=" + id + "]";
    }
    
}
