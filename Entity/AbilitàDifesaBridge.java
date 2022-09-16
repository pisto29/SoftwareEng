package Entity;

public class AbilitàDifesaBridge implements AbilitàImplementator {
    private static AbilitàDifesaBridge istanza;
    public static AbilitàDifesaBridge getIstanza(){
        if(istanza==null){
            istanza=new AbilitàDifesaBridge();
        }
        
            return istanza;
        

    }
    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio,EffettoComposite effetti_self, EffettoComposite effetti) {
        //System.out.println(utilizzatore.getImplementator().getClass().getSimpleName());
      //  if(utilizzatore.getImplementator().getClass().getSimpleName().equals("difensoreBridge"))
      if(utilizzatore.difendi())
      {
            //System.out.println(utilizzatore.getImplementator().getClass().getSimpleName());
            System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
            effetti_self.ApplicaEffetto(utilizzatore);
            effetti.ApplicaEffetto(bersaglio);
        }
    }
    
}
