package Entity;

public class PersonaggioAttivoSingleton implements RuoloState {

    private float moltiplicatoreAttacco;
    private float moltiplicatoreDifesa;
    private float moltiplicatoreAttSpec;
    private float moltiplicatoreDifSpec;
    private float moltiplicatoreVelocita; 

    @Override
    public void Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        
    }

   

    @Override
    public void Sostituzione() {
        // TODO Auto-generated method stub
        
    }



    @Override
    public float getAttacco(int attaccoOriginale) {
        
        return (float) attaccoOriginale * moltiplicatoreAttacco;
    }



    @Override
    public float getAttaccoSpecile(int attaccospecialeOriginale) {
        
        return (float) attaccospecialeOriginale * moltiplicatoreAttSpec;
    }



    @Override
    public float getDifesa(int difesaOriginale) {
        
        return (float) difesaOriginale * moltiplicatoreDifesa;
    }



    @Override
    public float getDifesaSpeciale(int difesaspecialeOriginale) {
        
        return (float) difesaspecialeOriginale * moltiplicatoreDifSpec;
    }



    @Override
    public float getVelocita(int velocitaOriginale) {
        
        return (float) velocitaOriginale * moltiplicatoreVelocita;
    }

   


    
}
