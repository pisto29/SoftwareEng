package Entity;

public interface RuoloState {

    public void Attacca(Personaggio P1, Mossa mossa);
    public void Difendi(Personaggio P1, Mossa mossa, float danno);
    public void Sostituzione(Personaggio P1);
    public float getAttacco(int attaccoOriginale);
    public float getDifesa(int difesaOriginale);
    public float getAttaccoSpecile(int attaccospecialeOriginale);
    public float getDifesaSpeciale(int difesaspecialeOriginale);
    public float getVelocita(int velocitaOriginale);
    public void aggiungiMoltiplicatoreAttacco(float moltiplicatore);
    public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore);
    public void aggiungiMoltiplicatoreDifesa(float moltiplicatore);
    public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore);
    public void aggiungiMoltiplicatoreVelocita(float moltiplicatore);
    public void AbiltaAttacco();
    public void DisabiltaAttacco();
    public PersonaggioAttivoImplementator getImplementator();
    public void setImplementator(PersonaggioAttivoImplementator implementator);

   
}
