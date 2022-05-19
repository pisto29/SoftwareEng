package Entity;

public interface StatusStrategy {
    public boolean checkAttivazione();
    public void Attivazione(Personaggio P1, Fase f);
    public void EffettoApplicazione(Personaggio P1);
   
}
