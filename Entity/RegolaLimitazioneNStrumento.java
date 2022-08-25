package Entity;

public class RegolaLimitazioneNStrumento implements RegolamentoComponent {
private int NumeroStrumenti;
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        if(s.getStrumentos().size()!=NumeroStrumenti)check=false;
        return check;
    }
    
}
