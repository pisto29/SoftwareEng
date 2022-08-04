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
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio) {
        if(utilizzatore.getImplementator().getClass().getSimpleName().equals("difensoreBridge")){
            utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
            utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        }
    }
    
}
