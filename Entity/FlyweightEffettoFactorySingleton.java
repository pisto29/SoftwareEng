package Entity;

import java.util.ArrayList;
import java.util.HashMap;

public class FlyweightEffettoFactorySingleton {
    private HashMap<Integer,EffettoComposite > effetti;
   // private ArrayList <EffettoComposite> effetti;
/*public EffettoComposite createEffettoAnnullaMossa(int id_effetto){
   
   for (EffettoComposite effettoComposite : effetti) {
        if(effettoComposite.getId()==id_effetto)
        return effettoComposite;
   }
}*/
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
               EffettoModificaVelocità effetto=new EffettoModificaVelocità(1f,id_effetto);
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

    public EffettoComposite EffettoMultiploComposite createEffettoMultiploComposite(int id_effetto){
            if(effetti.containsKey(id_effetto))return effetti.get(id_effetto);
            else{
               EffettoMultiploComposite effetto = new EffettoMultiploComposite(id_effetto);
               //EFFETTO DA CREARE TRAMITE LETTURA DA FILE O DB VALIDO PER TUTTI GLI EFFETTI
               effetti.put(id_effetto, effetto);
               return effetto;
            }
    }

}
