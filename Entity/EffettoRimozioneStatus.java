package Entity;



public class EffettoRimozioneStatus implements EffettoStrumento {
    private StatusStrategy StatusCura;
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
        if(P.getStatus().getNome()==this.StatusCura.getNome())
        P.setStatus(null);
        
    }
    
}
