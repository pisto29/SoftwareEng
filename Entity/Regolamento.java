package Entity;

public abstract class Regolamento {
    protected String id;
    
    public Regolamento(String id) {
        this.id = id;
    }
    
    public abstract boolean VerificaRegolamento(Squadra s);
    public abstract String toString();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
