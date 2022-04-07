package Entity;

public class PersonaggioAttivoSingleton implements RuoloState {
private static PersonaggioAttivoSingleton istanza;

   



   



    private float moltiplicatoreAttacco;
    private float moltiplicatoreDifesa;
    private float moltiplicatoreAttSpec;
    private float moltiplicatoreDifSpec;
    private float moltiplicatoreVelocita; 


    public static PersonaggioAttivoSingleton getIstanza() {
        if(istanza==null){istanza=new PersonaggioAttivoSingleton(1,1,1,1,1);}
     return istanza;
    }
    
    public PersonaggioAttivoSingleton(float moltiplicatoreAttacco, float moltiplicatoreDifesa,
            float moltiplicatoreAttSpec, float moltiplicatoreDifSpec, float moltiplicatoreVelocita) {
        this.moltiplicatoreAttacco = moltiplicatoreAttacco;
        this.moltiplicatoreDifesa = moltiplicatoreDifesa;
        this.moltiplicatoreAttSpec = moltiplicatoreAttSpec;
        this.moltiplicatoreDifSpec = moltiplicatoreDifSpec;
        this.moltiplicatoreVelocita = moltiplicatoreVelocita;
    }



    @Override
    public void Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        
    }

   

    @Override
    public void Sostituzione(Personaggio P1) {
        this.reset();
        if(P1.getpS()==0){}
        else
        P1.setRuolo(PersonaggioPanchinaSingleton.getIstanza());
        
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

   
public void reset(){
    this.moltiplicatoreAttSpec=1;
    this.moltiplicatoreAttacco=1;
    this.moltiplicatoreDifSpec=1;
    this.moltiplicatoreDifesa=1;
    this.moltiplicatoreVelocita=1;
}

    
}
