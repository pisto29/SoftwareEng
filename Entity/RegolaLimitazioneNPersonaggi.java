package Entity;

public class RegolaLimitazioneNPersonaggi implements RegolamentoComponent {
private int  NumeroPersonaggi;
private String id;
    public RegolaLimitazioneNPersonaggi(RegolaLimitazioneNPersonaggi R) {
        this.NumeroPersonaggi=R.getNumeroPersonaggi();
        this.id=R.getId();
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
