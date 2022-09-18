package Entity;

import java.util.ArrayList;

public class AbilitàAttaccoBridge implements AbilitàImplementator {
    private static AbilitàAttaccoBridge istanza;
    public static AbilitàAttaccoBridge getIstanza(){
        if(istanza==null){
            istanza=new AbilitàAttaccoBridge();
        }
        
            return istanza;
        

    }

    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio, ArrayList<Effetto> effetti_self, ArrayList<Effetto> effetti) {
        
         //if(utilizzatore.getImplementator().getClass().getSimpleName().equals("attaccanteBridge"))
         if(utilizzatore.attacca())
         {
            System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
            for(Effetto e: effetti_self)
            e.ApplicaEffetto(utilizzatore);
            for(Effetto e: effetti)
            e.ApplicaEffetto(bersaglio);
        }
    }

  
    
}
