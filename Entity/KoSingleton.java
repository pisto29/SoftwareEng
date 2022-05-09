package Entity;

public class KoSingleton implements RuoloState {
    private static KoSingleton istanza;
  
    public KoSingleton() {
    }

  public static KoSingleton getIstanza() {
    if(istanza==null){istanza=new KoSingleton();}
    return istanza;
    }

    @Override
    public void Attacca(Personaggio P1, Mossa mossa, Personaggio p2) {
        // TODO Auto-generated method stub
        
    }

 

    @Override
    public void Sostituzione(Personaggio P1) {
        // TODO Auto-generated method stub
        
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
    
}
