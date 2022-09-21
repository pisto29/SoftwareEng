package Entity;

public class PersonaggioPanchinaSingleton implements RuoloState {
 private static PersonaggioPanchinaSingleton istanza;

    private PersonaggioPanchinaSingleton() {
}


public static PersonaggioPanchinaSingleton getIstanza() {

    if(istanza==null) {

        istanza=new PersonaggioPanchinaSingleton();
    }
     return istanza;
}

  
   
  


    @Override
    public void Sostituzione(Personaggio P1) {
        P1.setRuolo(new PersonaggioAttivo());
        // TODO Auto-generated method stub
        
    }



    



   


    
    public float getVelocita(int velocitaOriginale) {
        // TODO Auto-generated method stub
        
        return velocitaOriginale;
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
public boolean isAbilitato() {
    // TODO Auto-generated method stub
    return false;
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
    public float EseguiAttacco(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        return 0;
        
    }


    @Override
    public boolean Difendi(Personaggio P1, Mossa mossa, float danno) {
        // TODO Auto-generated method stub
        return false;
        
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


    @Override
    public float getVelocitaAttuale(Personaggio p) {
        // TODO Auto-generated method stub
        return p.getVelocitaPersonaggio();
    }


    @Override
    public void VaiInCampo(Personaggio P1) {
        // TODO Auto-generated method stub
        P1.setRuolo(new PersonaggioAttivo());
    }


    @Override
    public void VaiInPanchina(Personaggio P) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void VaiKo(Personaggio P) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void TornaUtilizzabile(Personaggio P) {
        // TODO Auto-generated method stub
        
    }



    
}
