package Entity;

public class PersonaggioPanchinaSingleton implements RuoloState {
 private static PersonaggioPanchinaSingleton istanza;

    public PersonaggioPanchinaSingleton() {
}



    @Override
    public void Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        
    }
   
  

    public static PersonaggioPanchinaSingleton getIstanza() {
         if(istanza==null){istanza=new PersonaggioPanchinaSingleton();}
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

   


    
}
