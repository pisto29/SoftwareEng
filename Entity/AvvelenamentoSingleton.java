package Entity;

public class AvvelenamentoSingleton implements StatusStrategy {
    private static AvvelenamentoSingleton istanza;
    private String Nome;
    private AvvelenamentoSingleton() {
        this.Nome="Avvelenamento";
    }
    public static AvvelenamentoSingleton getIstanza() {
        
        if(istanza==null){

            istanza=new AvvelenamentoSingleton();
        }
     return istanza;
    }

    @Override
    public void Attivazione(Personaggio p1, Fase f) {
        if(this.checkAttivazione()&& f.equals(Fase.Fine_Turno)){
        p1.setpS(p1.getpS()-(p1.getpS()/8));
        System.out.println(p1.getNomePersonaggio()+" perde "+p1.getpS()/8+" PS a causa dell'avvelenamento");}
        
    }
    @Override
    public boolean checkAttivazione() {
        
        return true;
    }
    @Override
    public void EffettoApplicazione(Personaggio P1) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public String getNome() {
        // TODO Auto-generated method stub
        return this.Nome;
    }
   
    
}
