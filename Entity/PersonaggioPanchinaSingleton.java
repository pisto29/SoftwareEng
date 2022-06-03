package Entity;

public class PersonaggioPanchinaSingleton implements RuoloState {
 private static PersonaggioPanchinaSingleton istanza;

    public PersonaggioPanchinaSingleton() {
}


public static PersonaggioPanchinaSingleton getIstanza() {

    if(istanza==null) {

        istanza=new PersonaggioPanchinaSingleton();
    }
     return istanza;
}

  
   
  


    @Override
    public void Sostituzione(Personaggio P1) {
        P1.setRuolo(PersonaggioAttivoSingleton.getIstanza());
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


    @Override
    public void Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void Difendi(Personaggio P1, Mossa mossa, float danno) {
        // TODO Auto-generated method stub
        
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



    
}
