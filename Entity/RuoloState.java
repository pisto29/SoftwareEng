package Entity;

public interface RuoloState {

    public void Attacca(Personaggio P1, Mossa mossa);
    public void Sostituzione();
    public float getAttacco(int attaccoOriginale);
    public float getDifesa(int difesaOriginale);
    public float getAttaccoSpecile(int attaccospecialeOriginale);
    public float getDifesaSpeciale(int difesaspecialeOriginale);
    public float getVelocita(int velocitaOriginale);
   
}
