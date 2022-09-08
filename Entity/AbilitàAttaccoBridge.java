package Entity;

public class AbilitàAttaccoBridge implements AbilitàImplementator {
    private static AbilitàAttaccoBridge istanza;
    public static AbilitàAttaccoBridge getIstanza(){
        if(istanza==null){
            istanza=new AbilitàAttaccoBridge();
        }
        
            return istanza;
        

    }

    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        
         //if(utilizzatore.getImplementator().getClass().getSimpleName().equals("attaccanteBridge"))
         if(utilizzatore.attacca())
         {
            System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
            utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
            utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        }
    }

  
    
}
