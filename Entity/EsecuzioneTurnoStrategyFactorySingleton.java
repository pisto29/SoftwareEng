package Entity;

public class EsecuzioneTurnoStrategyFactorySingleton {
private static EsecuzioneTurnoStrategyFactorySingleton istanza;
    private EsecuzioneTurnoStrategyFactorySingleton() {
    }

public static EsecuzioneTurnoStrategyFactorySingleton getIstanza(){
    if(istanza==null)istanza=new EsecuzioneTurnoStrategyFactorySingleton();
    return istanza;
}
public EsecuzioneTurno CreateStrategy(Turno t){
    EsecuzioneTurno strat=null;
    String strat_name=this.FindStrategy(t);
    switch(strat_name){
        case "MossaMossa":
        MossaMossa strat1=new MossaMossa();
        strat=strat1;
        break;
        case "MossaCambio":
        MossaCambio strat2=new MossaCambio();
        strat=strat2;
        break;
        case "MossaStrumento":
        MossaStrumento strat3=new MossaStrumento();
        strat=strat3;
        break;
        case "CambioCambio":
        CambioCambio strat4=new CambioCambio();
        strat=strat4;
        break;
        case "CambioStrumento":
        CambioStrumento strat5=new CambioStrumento();
        strat=strat5;
        break;
        case "CambioMossa":
        CambioMossa strat6=new CambioMossa();
        strat=strat6;
        break;
        case "StrumentoMossa":
        StrumentoMossa strat7=new StrumentoMossa();
        strat=strat7;
        break;
        case "StrumentoCambio":
        StrumentoCambio Strat8=new StrumentoCambio();
        strat=Strat8;
        break;
        case "StrumentoStrumento":
        StrumentoStrumento strat9=new StrumentoStrumento();
        strat=strat9;
        break;
    }
    return strat;
    }


private String FindStrategy(Turno t){
    String st1="";
    String st2="";
    if(t.getMosse().get(0)!=null)
    st1="Mossa";
    if(t.getMosse().get(1)!=null)
    st2="Mossa";
    if(t.getSostituzioni().get(0)!=null)
    st1="Cambio";
    if(t.getSostituzioni().get(1)!=null)
    st2="Cambio";
    if(t.getStrumenti().get(0)!=null)
    st1="Strumento";
    if(t.getStrumenti().get(1)!=null)
    st2="Strumento";
    return st1.concat(st2);
}
}
