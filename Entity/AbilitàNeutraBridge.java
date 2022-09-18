package Entity;

import java.util.ArrayList;

public class AbilitàNeutraBridge implements AbilitàImplementator {
    private static AbilitàNeutraBridge istanza;
    public static AbilitàNeutraBridge getIstanza(){
        if(istanza==null){
            istanza=new AbilitàNeutraBridge();
        }
        
            return istanza;
        

    }
    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio, ArrayList<Effetto> effetti_self, ArrayList<Effetto> effetti) {
        System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
        for(Effetto e: effetti_self)
            e.ApplicaEffetto(utilizzatore);
            for(Effetto e: effetti)
            e.ApplicaEffetto(bersaglio);
        
    }
    
}
