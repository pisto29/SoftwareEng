package Entity;
import Foundation.*;
import java.util.ArrayList;
import java.util.HashMap;

public class FlyweightEffettoFactorySingleton {
    private HashMap<String,EffettoComposite > effetti;
    private static FlyweightEffettoFactorySingleton istanza;
   // private ArrayList <EffettoComposite> effetti;


public static FlyweightEffettoFactorySingleton getIstanza() {

   if(istanza==null) {

       istanza=new FlyweightEffettoFactorySingleton();
   }
return istanza;
}

public EffettoComposite createEffettoAnnullaMossa(String id_effetto){
   
 if( this.effetti.containsKey(id_effetto)){
   return this.effetti.get(id_effetto)
 }
 else{
builder.CreaEffettoComposite(id_effetto);

 }
   }
}
/* 
public EffettoComposite createEffettoAnnullaMossa(int id_effetto){
    if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
    else{
       EffettoAnnullaMossa effetto=new EffettoAnnullaMossa(id_effetto);
       //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
       effetti.put(id_effetto, effetto);
       return effetto;}
     
    }

    public EffettoComposite createEffettoModificaAttacco(int id_effetto){
        if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
        else{
           EffettoModificaAttacco effetto=new EffettoModificaAttacco(1f,id_effetto);
           //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
           effetti.put(id_effetto, effetto);
           return effetto;}
         
        }

    public EffettoComposite createEffettoModificaAttaccoSpeciale(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoModificaAttaccoSpeciale effetto=new EffettoModificaAttaccoSpeciale(1f,id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;
             
            }
}
    public EffettoComposite createEffettoModificaDifesa(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoModificaDifesa effetto=new EffettoModificaDifesa(1f,id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;}
}

    public EffettoComposite createEffettoModificaDifesaSpeciale(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoModificaDifesaSpeciale effetto=new EffettoModificaDifesaSpeciale(1f,id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;}
}
    public EffettoComposite createEffettoModificaVelocità(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoModificaVelocita effetto=new EffettoModificaVelocita(1f,id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;}
}

    public EffettoComposite createEffettoStatus(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoStatus effetto = new EffettoStatus(id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;
            }
    }

    public EffettoComposite  createEffettoMultiploComposite(int id_effetto){
      ArrayList <EffettoComposite> eff= new ArrayList<>();
            if(effetti.containsKey(id_effetto))
            return effetti.get(id_effetto);
            else{
               EffettoMultiploComposite effetto = new EffettoMultiploComposite(id_effetto, eff);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;
            }
    }*/

}
