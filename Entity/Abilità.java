package Entity;



public interface Abilità {

   

    public void Attivazione(Personaggio utilizzatore,Personaggio bersaglio);

    public Fase getFase_attivazione();

    public EffettoComposite getEffetti();
    public EffettoComposite getEffetti_self();
    public String toString();
    public String getNome();
   
    
}
