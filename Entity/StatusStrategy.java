package Entity;

public abstract class StatusStrategy {
    protected String Nome;
    protected Fase FaseAttivazione;
    public StatusStrategy(String nome, Fase faseAttivazione) {
        Nome = nome;
        FaseAttivazione = faseAttivazione;
    }
    
    public abstract boolean checkAttivazione();
    public abstract void Attivazione(Personaggio P1, Fase f);
    public abstract void EffettoApplicazione(Personaggio P1);
    public String getNome(){ return this.Nome;}
    
   
}
