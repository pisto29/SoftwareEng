package Entity;

public class KoSingleton implements RuoloState {
    private static KoSingleton istanza;
  
    private KoSingleton() {
    }

  public static KoSingleton getIstanza() {
    if(istanza==null){istanza=new KoSingleton();}
    return istanza;
    }

   

 

    @Override
    public void Sostituzione(Personaggio P1) {
        P1.setRuolo(PersonaggioPanchinaSingleton.getIstanza());
    }


    @Override
public boolean isAbilitato() {
    // TODO Auto-generated method stub
    return false;
}


    @Override
    public float getAttacco(int attaccoOriginale) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public float getAttaccoSpecile(int attaccospecialeOriginale) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public float getDifesa(int difesaOriginale) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public float getDifesaSpeciale(int difesaspecialeOriginale) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public float getVelocita(int velocitaOriginale) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void aggiungiMoltiplicatoreAttacco(float moltiplicatore) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void aggiungiMoltiplicatoreDifesa(float moltiplicatore) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void aggiungiMoltiplicatoreVelocita(float moltiplicatore) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void AbiltaAttacco() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void DisabiltaAttacco() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public float Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean Difendi(Personaggio P1, Mossa mossa, float danno) {
        // TODO Auto-generated method stub
        return false;
        
    }

    @Override
    public PersonaggioAttivoImplementator getImplementator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setImplementator(PersonaggioAttivoImplementator implementator) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getPriorità() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setPriorità(int p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean attacca() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean difende() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setAttacca(boolean a) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDifende(boolean a) {
        // TODO Auto-generated method stub
        
    }
    
}
