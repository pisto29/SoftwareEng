package Entity;

public class RegolaLimitazioneNPersonaggi implements RegolamentoComponent {
private int  NumeroPersonaggi;
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        if(s.getPersonaggios().size()!=NumeroPersonaggi)check=false;
        return check;
    }
    
}
