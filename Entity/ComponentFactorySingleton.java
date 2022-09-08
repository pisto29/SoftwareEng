package Entity;

public class ComponentFactorySingleton {
    private static ComponentFactorySingleton istanza;

    public static ComponentFactorySingleton getIstanza() {

        if(istanza==null) {

            istanza=new ComponentFactorySingleton();
        }
     return istanza;
    }

    public Mossa CreateMossa(int id_mossa){
        
    }
    
}
