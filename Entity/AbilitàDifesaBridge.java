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
        System.out.println(utilizzatore.getImplementator().getClass().getSimpleName());
        if(utilizzatore.getImplementator().getClass().getSimpleName().equals("difensoreBridge")){
            System.out.println(utilizzatore.getImplementator().getClass().getSimpleName());
            utilizzatore.getAbilità().getEffetti_self().ApplicaEffetto(utilizzatore);
            utilizzatore.getAbilità().getEffetti().ApplicaEffetto(bersaglio);
        }
    }
    
}
