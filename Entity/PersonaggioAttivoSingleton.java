package Entity;

public class PersonaggioAttivoSingleton implements RuoloState {
private static PersonaggioAttivoSingleton istanza1;
private static PersonaggioAttivoSingleton istanza2;
private static String LastReturned;


    private float moltiplicatoreAttacco;
    private float moltiplicatoreDifesa;
    private float moltiplicatoreAttSpec;
    private float moltiplicatoreDifSpec;
    private float moltiplicatoreVelocita; 
    private boolean abilitazioneAttacco;
    private int priorità;
    private PersonaggioAttivoImplementator implementator;
    public static PersonaggioAttivoSingleton getIstanza() {
        if(istanza1==null){
           istanza1=new PersonaggioAttivoSingleton(1,1,1,1,1,true);
           LastReturned = "istanza1";
           return istanza1;    
        }
        if(istanza2==null){
            istanza2=new PersonaggioAttivoSingleton(1,1,1,1,1,true);
            LastReturned = "istanza2";
            return istanza2;  
         }
        if(LastReturned.equals("istanza1")){
            LastReturned = "istanza2";
            return istanza2;
        }
        LastReturned = "istanza1";
        return istanza1;
        
    }
    
    public PersonaggioAttivoSingleton(float moltiplicatoreAttacco, float moltiplicatoreDifesa,
            float moltiplicatoreAttSpec, float moltiplicatoreDifSpec, float moltiplicatoreVelocita, boolean abilitazioneAttacco) {
        this.moltiplicatoreAttacco = moltiplicatoreAttacco;
        this.moltiplicatoreDifesa = moltiplicatoreDifesa;
        this.moltiplicatoreAttSpec = moltiplicatoreAttSpec;
        this.moltiplicatoreDifSpec = moltiplicatoreDifSpec;
        this.moltiplicatoreVelocita = moltiplicatoreVelocita;
        this.abilitazioneAttacco = abilitazioneAttacco;
        this.priorità=0;
    }



    /*private float CalcoloModificatore(Mossa m, Personaggio p1, Personaggio p2){

        float modificatore = 1;
        float efficacia = m.getTipo().getEfficacia(p2.getTipos()[0]) * m.getTipo().getEfficacia(p2.getTipos()[1]) ;
        
        if(m.CheckCritico()) 
            modificatore = modificatore * 2f;
        
        if(IsStab(m, p1))
            modificatore = modificatore * 1.33f;
        
        modificatore = modificatore * efficacia;

        return modificatore;
    }*/

    private boolean IsStab(Mossa m, Personaggio p1){
        boolean stab = false;
        for(int i = 0 ; i < 2 ; i++){
            if(m.getTipo() == p1.getTipos().get(i))
             stab = true; 
        }
  
        return stab;
    }

    
   /* @Override ATTACCA REINDIRIZZATO ALL IMPLEMENTATOR
    public void Attacca(Personaggio p1, Mossa m, Personaggio p2 ) {
        float danno;
        float attacco;
        float difesa;

        if(m.getTipologia() == Tipologia.Fisico){

            attacco = p1.getAttaccoPersonaggio();
            difesa = p2.getDifesaPersonaggio();
        }
        else{

            attacco = p1.getAttaccoSpecialePersonaggio();
            difesa = p2.getDifesaSpecialePersonaggio();

        }

        danno = (22 * m.getDanno() * attacco / (50 * difesa)) + 2;
        danno = danno * this.CalcoloModificatore(m, p1, p2);
        p2.setpS(p2.getpS()-(int) danno);
        //return (int) danno;
    }*/
    @Override 
    public float Attacca(Personaggio p1, Mossa m) {
        return this.implementator.attacca(p1, m);
    }
   
    @Override 
    public void Difendi(Personaggio p1, Mossa m, float danno) {
        this.implementator.difendi(danno, m, p1);
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

@Override
public PersonaggioAttivoImplementator getImplementator() {
    // TODO Auto-generated method stub
    return this.implementator;
}

@Override
public void setImplementator(PersonaggioAttivoImplementator implementator) {
    this.implementator=implementator;
}

public int getPriorità() {
    return priorità;
}

public void setPriorità(int priorità) {
    this.priorità = priorità;
}

    
}
