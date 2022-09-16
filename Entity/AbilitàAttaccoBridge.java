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
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio, EffettoComposite effetti_self, EffettoComposite effetti) {
        
         //if(utilizzatore.getImplementator().getClass().getSimpleName().equals("attaccanteBridge"))
         if(utilizzatore.attacca())
         {
            System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
            effetti_self.ApplicaEffetto(utilizzatore);
            effetti.ApplicaEffetto(bersaglio);
        }
    }

  
    
}
