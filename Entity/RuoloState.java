package Entity;

public interface RuoloState {

    public float EseguiAttacco(Personaggio P1, Mossa mossa);
    public boolean Difendi(Personaggio P1, Mossa mossa, float danno);
    public void Sostituzione(Personaggio P1);
    public float getVelocitaAttuale(Personaggio p);
    public void aggiungiMoltiplicatoreAttacco(float moltiplicatore);
    public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore);
    public void aggiungiMoltiplicatoreDifesa(float moltiplicatore);
    public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore);
    public void aggiungiMoltiplicatoreVelocita(float moltiplicatore);
    public void AbiltaAttacco();
    public void DisabiltaAttacco();
    public boolean isAbilitato();
    public boolean attacca();
    public boolean difende();
    public void setAttacca(boolean a);
    public void setDifende(boolean a);
   

   
}
