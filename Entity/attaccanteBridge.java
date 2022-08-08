package Entity;

public class attaccanteBridge implements PersonaggioAttivoImplementator {
 private static attaccanteBridge istanza;
 public static attaccanteBridge getIstanza(){
     if(istanza==null){istanza=new attaccanteBridge();}
     return istanza;
 }
    @Override
    public float attacca(Personaggio p1, Mossa m) {
       // System.out.println(m.getNomeMossa()+"da usare");
        float attacco=0;
       if(m.getTipologia().equals(Tipologia.Fisico)) attacco=p1.getAttaccoPersonaggio();
       else attacco=p1.getAttaccoSpecialePersonaggio();
      /*  System.out.println("in attaccante bridge l'attacco del pokemon e "+attacco);
       System.out.println("in attaccante bridge il danno della mossa e"+m.getDanno());*/
       float danno=m.getDanno()*attacco;
       danno= danno* this.CalcoloModificatore(m, p1);
       //System.out.println("in attaccante bridge il danno e "+danno);
       return  danno; 
    }

    
   
    private boolean IsStab(Mossa m, Personaggio p1){
        boolean stab = false;
       /*  for(int i = 0 ; i < 2 ; i++){
            if(m.getTipo() == p1.getTipos().get(i))
             stab = true; 
        }*/
        for(Tipo t: p1.getTipos()){
            if(m.getTipo().getNomeTipo().equals(t.getNomeTipo())){
                stab = true;
            }
        }
  
        return stab;
    }

    private float CalcoloModificatore(Mossa m, Personaggio p1 ){

        float modificatore = 1;
        
        if(m.CheckCritico()){
            modificatore = modificatore * 2f;
        System.out.println("Brutto colpo effettuato");
        }
        
        if(IsStab(m, p1))
            modificatore = modificatore * 1.33f;
        
        

        return modificatore;
    }



    @Override
    public boolean difendi(float danno, Mossa m, Personaggio p1) {
        // TODO Auto-generated method stub
        return false;
        
    }

   
}
