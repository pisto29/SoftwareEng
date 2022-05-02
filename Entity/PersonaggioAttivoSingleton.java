package Entity;

public class PersonaggioAttivoSingleton implements RuoloState {
private static PersonaggioAttivoSingleton istanza;

    private float moltiplicatoreAttacco;
    private float moltiplicatoreDifesa;
    private float moltiplicatoreAttSpec;
    private float moltiplicatoreDifSpec;
    private float moltiplicatoreVelocita; 
    private boolean abilitazioneAttacco;

    public static PersonaggioAttivoSingleton getIstanza() {
        if(istanza==null){
            istanza=new PersonaggioAttivoSingleton(1,1,1,1,1,true);
        }
     return istanza;
    }
    
    public PersonaggioAttivoSingleton(float moltiplicatoreAttacco, float moltiplicatoreDifesa,
            float moltiplicatoreAttSpec, float moltiplicatoreDifSpec, float moltiplicatoreVelocita, boolean abilitazioneAttacco) {
        this.moltiplicatoreAttacco = moltiplicatoreAttacco;
        this.moltiplicatoreDifesa = moltiplicatoreDifesa;
        this.moltiplicatoreAttSpec = moltiplicatoreAttSpec;
        this.moltiplicatoreDifSpec = moltiplicatoreDifSpec;
        this.moltiplicatoreVelocita = moltiplicatoreVelocita;
        this.abilitazioneAttacco = abilitazioneAttacco;
    }



    @Override
    public void Attacca(Personaggio P1, Mossa mossa) {
        // TODO Auto-generated method stub
        
    }

   

    @Override
    public void Sostituzione(Personaggio P1) {
        this.reset();
        if(P1.getpS()==0){

            P1.setRuolo(KoSingleton.getIstanza());
        }
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

public float getMoltiplicatoreAttacco() {
    return moltiplicatoreAttacco;
}

public void setMoltiplicatoreAttacco(float moltiplicatoreAttacco) {
    this.moltiplicatoreAttacco = moltiplicatoreAttacco;
}

public float getMoltiplicatoreDifesa() {
    return moltiplicatoreDifesa;
}

public void setMoltiplicatoreDifesa(float moltiplicatoreDifesa) {
    this.moltiplicatoreDifesa = moltiplicatoreDifesa;
}

public float getMoltiplicatoreAttSpec() {
    return moltiplicatoreAttSpec;
}

public void setMoltiplicatoreAttSpec(float moltiplicatoreAttSpec) {
    this.moltiplicatoreAttSpec = moltiplicatoreAttSpec;
}

public float getMoltiplicatoreDifSpec() {
    return moltiplicatoreDifSpec;
}

public void setMoltiplicatoreDifSpec(float moltiplicatoreDifSpec) {
    this.moltiplicatoreDifSpec = moltiplicatoreDifSpec;
}

public float getMoltiplicatoreVelocita() {
    return moltiplicatoreVelocita;
}

public void setMoltiplicatoreVelocita(float moltiplicatoreVelocita) {
    this.moltiplicatoreVelocita = moltiplicatoreVelocita;
}

@Override
public void aggiungiMoltiplicatoreAttacco(float moltiplicatore) {
    // TODO Auto-generated method stub
    this.moltiplicatoreAttacco = this.moltiplicatoreAttacco * moltiplicatore;
    
}

@Override
public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore) {
    // TODO Auto-generated method stub
    this.moltiplicatoreAttSpec = this.moltiplicatoreAttSpec * moltiplicatore;
    
}

@Override
public void aggiungiMoltiplicatoreDifesa(float moltiplicatore) {
    // TODO Auto-generated method stub
    this.moltiplicatoreDifesa = this.moltiplicatoreDifesa * moltiplicatore;
    
}

@Override
public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore) {
    // TODO Auto-generated method stub
    this.moltiplicatoreDifSpec = this.moltiplicatoreDifSpec * moltiplicatore;
}

@Override
public void aggiungiMoltiplicatoreVelocita(float moltiplicatore) {
    // TODO Auto-generated method stub
    this.moltiplicatoreVelocita = this.moltiplicatoreVelocita * moltiplicatore;
    
}

public boolean isAbilitazioneAttacco() {
    return abilitazioneAttacco;
}

public void setAbilitazioneAttacco(boolean abilitazioneAttacco) {
    this.abilitazioneAttacco = abilitazioneAttacco;
}

@Override
public void AbiltaAttacco() {
    // TODO Auto-generated method stub
    abilitazioneAttacco = true;
}

@Override
public void DisabiltaAttacco() {
    // TODO Auto-generated method stub
    abilitazioneAttacco = false;
}

    
}
