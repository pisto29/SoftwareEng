package Entity;

import java.util.Random;

public class difensoreBridge implements PersonaggioAttivoImplementator  {
    private static difensoreBridge istanza;
    public static difensoreBridge getIstanza(){
        if(istanza==null){istanza=new difensoreBridge();}
        return istanza;
    }
    @Override
    public float attacca(Personaggio p1, Mossa m) {
        // TODO Auto-generated method stub
        return 0;
    }

  

    private boolean miss(Mossa m){
        if(m.getPrecisione()<new Random().nextInt(100)) return true;
        else return false;
    }



   

    private float efficacia(Personaggio p1, Mossa m){
          float efficacia = m.getTipo().getEfficacia(p1.getTipos()[0]) ;
          if (p1.getTipos()[1]!=null) efficacia=efficacia* m.getTipo().getEfficacia(p1.getTipos()[1]) ;
          return efficacia;
    }



    @Override
    public void difendi(float danno, Mossa m, Personaggio p1) {
        danno=danno*this.efficacia(p1, m);
        float difesa=0;
        if(m.getTipologia().equals(Tipologia.Fisico)) difesa=p1.getDifesaPersonaggio();
        else difesa=p1.getDifesaSpecialePersonaggio();
        danno=danno/difesa;
        if(this.miss(m))danno=0f;
        int d= (int) danno;
        p1.setpS(p1.getpS()-d);
        if(p1.getpS()<0)p1.setpS(0);

        //if(p1.getpS==0)p1.setRuolo(KoSingleton);

        
    }

   

    
}
