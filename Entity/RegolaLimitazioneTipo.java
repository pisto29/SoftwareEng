package Entity;

public class RegolaLimitazioneTipo implements RegolamentoComponent {
    private String Id_tipo;
    private Tipo tipo;
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        for(Personaggio p: s.getPersonaggios()){
            for(Tipo t: p.getTipos())
            if(t.getNomeTipo()==tipo.getNomeTipo()) check=false;
        }
        return check;
    }

}
