package Entity;

public class AbilitàNeutraBridge implements AbilitàImplementator {
    private static AbilitàNeutraBridge istanza;
    public static AbilitàNeutraBridge getIstanza(){
        if(istanza==null){
            istanza=new AbilitàNeutraBridge();
        }
        
            return istanza;
        

    }
    @Override
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        System.out.println("Si attiva l'abilità "+ utilizzatore.getAbilità().getNome() +" di "+ utilizzatore.getNomePersonaggio());
        utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
        utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        
    }
    
}
