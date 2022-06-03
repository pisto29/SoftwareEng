package Entity;

public class ImplementatorManagerSingleton {
    private static ImplementatorManagerSingleton istanza;
    public static ImplementatorManagerSingleton getIstanza(){
        if(istanza==null){istanza=new ImplementatorManagerSingleton();}
        return istanza;
    }
    public void setattaccante(Personaggio p){
        p.setImplementator(attaccanteBridge.getIstanza());
    }
    public void setDifensore(Personaggio p){
        p.setImplementator(difensoreBridge.getIstanza());
    }
}
