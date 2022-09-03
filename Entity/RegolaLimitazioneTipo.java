package Entity;

import java.io.FileNotFoundException;

public class RegolaLimitazioneTipo implements RegolamentoComponent {
    private String Id_tipo;
    private Tipo tipo;
    private String id;
    public RegolaLimitazioneTipo(RegolaLimitazioneTipo R) throws FileNotFoundException {
        this.id=R.getId();
        this.Id_tipo=R.getId_tipo();
        this.tipo=TipoFactorySingleton.getIstanza().Create(this.Id_tipo);
    }
    @Override
    public boolean VerificaRegolamento(Squadra s) {
        boolean check=true;
        for(Personaggio p: s.getPersonaggios()){
            for(Tipo t: p.getTipos())
            if(t.getNomeTipo()==tipo.getNomeTipo()) check=false;
        }
        return check;
    }
    public String getId_tipo() {
        return Id_tipo;
    }
    public void setId_tipo(String id_tipo) {
        Id_tipo = id_tipo;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "RegolaLimitazioneTipo [Id_tipo=" + Id_tipo + ", id=" + id + ", tipo=" + tipo + "]";
    }

}
