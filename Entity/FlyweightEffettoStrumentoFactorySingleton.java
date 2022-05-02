package Entity;

public class FlyweightEffettoStrumentoFactorySingleton {
    private static FlyweightEffettoStrumentoFactorySingleton istanza;

    public static FlyweightEffettoStrumentoFactorySingleton getIstanza() {

        if(istanza==null) {

            istanza=new FlyweightEffettoStrumentoFactorySingleton();
        }
     return istanza;
    }
    
}
