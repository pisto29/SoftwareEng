package Entity;

public class EffettoRevitalizzante implements EffettoStrumento {
private int ps;
    public int getPs() {
    return ps;
}
public void setPs(int ps) {
    this.ps = ps;
}
    public EffettoRevitalizzante(int ps) {
    this.ps = ps;
}
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
       if(P.getRuolo().getClass().getSimpleName().equals("KoSingleton"))
       P.setpS(this.ps);
       P.Sostituzione();
        
    }
    
}
