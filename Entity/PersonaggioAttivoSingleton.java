package Entity;

import java.util.Random;

public class PersonaggioAttivoSingleton implements RuoloState {
private static PersonaggioAttivoSingleton istanza1;
private static PersonaggioAttivoSingleton istanza2;
private static String topass="istanza1";

    private boolean attacca;
    private boolean difende;
    private float moltiplicatoreAttacco;
    private float moltiplicatoreDifesa;
    private float moltiplicatoreAttSpec;
    private float moltiplicatoreDifSpec;
    private float moltiplicatoreVelocita; 
    private boolean abilitazioneAttacco;
    public static PersonaggioAttivoSingleton getIstanza() {
        if(topass.equals("istanza1")){
        if(istanza1==null){
           istanza1=new PersonaggioAttivoSingleton(1,1,1,1,1,true);
           //LastReturned = "istanza1";
           return istanza1;    
        }
    else return istanza1;
    }
    else{
        if(istanza2==null){
            istanza2=new PersonaggioAttivoSingleton(1,1,1,1,1,true);
           // LastReturned = "istanza2";
            return istanza2;  
         }
         return istanza2;
        }
        
    }
    public static void setpass(String pass){
        topass=pass;
    }
    private PersonaggioAttivoSingleton(float moltiplicatoreAttacco, float moltiplicatoreDifesa,
            float moltiplicatoreAttSpec, float moltiplicatoreDifSpec, float moltiplicatoreVelocita, boolean abilitazioneAttacco) {
        this.moltiplicatoreAttacco = moltiplicatoreAttacco;
        this.moltiplicatoreDifesa = moltiplicatoreDifesa;
        this.moltiplicatoreAttSpec = moltiplicatoreAttSpec;
        this.moltiplicatoreDifSpec = moltiplicatoreDifSpec;
        this.moltiplicatoreVelocita = moltiplicatoreVelocita;
        this.abilitazioneAttacco = abilitazioneAttacco;
        this.attacca=false;
        this.difende=false;
        
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
    public float EseguiAttacco(Personaggio p1, Mossa m) {
   
       // return this.implementator.attacca(p1, m);
       // System.out.println(m.getNomeMossa()+"da usare");
       float attacco=0;
       m.setPp(m.getPp()-1);
      
      if(m.getTipologia().equals(Tipologia.Fisico)) attacco=p1.getAttaccoPersonaggio()*moltiplicatoreAttacco;
      else attacco=p1.getAttaccoSpecialePersonaggio()*moltiplicatoreAttSpec;
     /*  System.out.println("in attaccante bridge l'attacco del pokemon e "+attacco);
      System.out.println("in attaccante bridge il danno della mossa e"+m.getDanno());*/
      float danno=m.getDanno()*attacco;
      danno= danno* this.CalcoloModificatore(m, p1);
      //System.out.println("in attaccante bridge il danno e "+danno);
      return  danno;
    }
   
    @Override 
    public boolean Difendi(Personaggio p1, Mossa m, float danno) {
       // return this.implementator.difendi(danno, m, p1);
       float eff=this.efficacia(p1, m);
       danno=danno*eff;
       float difesa=0;
       if(eff==0){
           return false;
           }
       if(m.getTipologia().equals(Tipologia.Fisico)) difesa=p1.getDifesaPersonaggio()*moltiplicatoreDifesa;
       else difesa=p1.getDifesaSpecialePersonaggio()*moltiplicatoreDifSpec;
       danno=danno/difesa;
       if(m.miss()){
       System.out.println("l'attacco fallisce");
       return false;
       }
       else{
       int d= (int) danno;
       if(danno>0)
       System.out.println(p1.getNomePersonaggio()+" perde "+d+" ps");
       p1.setpS(p1.getpS()-d);
       if(p1.getpS()<0)p1.setpS(0);
       if(p1.getpS()==0)p1.Sostituzione();
       return true;}
    }

    ///
    private boolean IsStab(Mossa m, Personaggio p1){
        boolean stab = false;
       /*  for(int i = 0 ; i < 2 ; i++){
            if(m.getTipo() == p1.getTipos().get(i))
             stab = true; 
        }*/
        for(Tipo t: p1.getTipos()){
            if(m.getTipo().getNomeTipo().equals(t.getNomeTipo())){
                stab = true;
            }
        }
  
        return stab;
    }

    private float CalcoloModificatore(Mossa m, Personaggio p1 ){

        float modificatore = 1;
        
        if(m.CheckCritico()){
            modificatore = modificatore * 2f;
        System.out.println("Brutto colpo effettuato");
        }
        
        if(IsStab(m, p1))
            modificatore = modificatore * 1.33f;
        
        

        return modificatore;
    }
///metodi difesa///

private boolean miss(Mossa m){
    if(m.getPrecisione()<new Random().nextInt(100)) return true;
    else return false;
}





private float efficacia(Personaggio p1, Mossa m){
      /*float efficacia = m.getTipo().getEfficacia(p1.getTipos().get(0).getNomeTipo()) ;
      if (p1.getTipos().get(1)!=null) 
      efficacia=efficacia* m.getTipo().getEfficacia(p1.getTipos().get(1).getNomeTipo());*/
      float efficacia = 1;
      for(Tipo t: p1.getTipos()){
        efficacia = efficacia*m.getTipo().getEfficacia(t.getNomeTipo());
       
        }
        if(efficacia==0)System.out.println("Non ha effetto su "+p1.getNomePersonaggio());
        if(efficacia>1)System.out.println("è superefficace");
        if(efficacia<1&&efficacia>0)System.out.println("non è molto efficace");
    
      return efficacia;
      //a
}
////
    ///

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
    public float getVelocitaAttuale(Personaggio p) {
        
        return (float) p.getVelocitaPersonaggio() * moltiplicatoreVelocita;
    }

   
private void reset(){
    
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
    if(this.moltiplicatoreAttacco<6||this.moltiplicatoreAttacco>0.015)this.moltiplicatoreAttacco = this.moltiplicatoreAttacco * moltiplicatore;
    if(this.moltiplicatoreAttacco==6) System.out.println("l'attacco non può aumentare ulteriormente");
    if(this.moltiplicatoreAttacco==0.015) System.out.println("l'attacco non può diminuire ulteriormente");

    
    
}

@Override
public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore) {
    // TODO Auto-generated method stub
    if(this.moltiplicatoreAttSpec<6||this.moltiplicatoreAttSpec>0.015)this.moltiplicatoreAttSpec = this.moltiplicatoreAttSpec * moltiplicatore;
    if(this.moltiplicatoreAttSpec==6) System.out.println("l'attacco speciale non può aumentare ulteriormente");
    if(this.moltiplicatoreAttSpec==0.015) System.out.println("l'attacco speciale non può diminuire ulteriormente");
    
}

@Override
public void aggiungiMoltiplicatoreDifesa(float moltiplicatore) {
    // TODO Auto-generated method stub
    if(this.moltiplicatoreDifesa<6||this.moltiplicatoreDifesa>0.015)this.moltiplicatoreDifesa = this.moltiplicatoreDifesa * moltiplicatore;
    if(this.moltiplicatoreDifesa==6) System.out.println("la difesa non può aumentare ulteriormente");
    if(this.moltiplicatoreDifesa==0.015) System.out.println("la difesa non può diminuire ulteriormente");
    
}

@Override
public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore) {
    // TODO Auto-generated method stub
    if(this.moltiplicatoreDifSpec<6||this.moltiplicatoreDifSpec>0.015)this.moltiplicatoreDifSpec = this.moltiplicatoreDifSpec * moltiplicatore;
    if(this.moltiplicatoreDifSpec==6) System.out.println("la difesa Speciale non può aumentare ulteriormente");
    if(this.moltiplicatoreDifSpec==0.015) System.out.println("la non difesa Speciale può diminuire ulteriormente");
}

@Override
public void aggiungiMoltiplicatoreVelocita(float moltiplicatore) {
    // TODO Auto-generated method stub
    if(this.moltiplicatoreVelocita<6||this.moltiplicatoreVelocita>0.015)this.moltiplicatoreVelocita = this.moltiplicatoreVelocita * moltiplicatore;
    if(this.moltiplicatoreVelocita==6) System.out.println("la velocità non può aumentare ulteriormente");
    if(this.moltiplicatoreVelocita==0.015) System.out.println("la velocità non può diminuire ulteriormente");
    
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

@Override
public boolean isAbilitato() {
    // TODO Auto-generated method stub
    return this.abilitazioneAttacco;
}
@Override
public boolean attacca() {
    // TODO Auto-generated method stub
    return this.attacca;
}
@Override
public boolean difende() {
    // TODO Auto-generated method stub
    return this.difende;
}
@Override
public void setAttacca(boolean a) {
    // TODO Auto-generated method stub
    this.attacca=a;
    
}
@Override
public void setDifende(boolean a) {
    // TODO Auto-generated method stub
    this.difende=a;
    
}

    
}
