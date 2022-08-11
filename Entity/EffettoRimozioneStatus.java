package Entity;

import java.util.ArrayList;

public class EffettoRimozioneStatus implements EffettoStrumento {
    private StatusStrategy StatusCura;
    private String id_status;
    private String id;
    public EffettoRimozioneStatus(StatusStrategy statusCura, String id_status, String id) {
        StatusCura = statusCura;
        this.id_status = id_status;
        this.id = id;
    }
    public EffettoRimozioneStatus(EffettoRimozioneStatus e){
        this.id_status=e.getId_status();
        this.id=e.getId();
        if(this.id_status.equals("Paralisi"))
        this.StatusCura=ParalisiSingleton.getIstanza();
        if(this.id_status.equals("Avvelenamento"))
        this.StatusCura=AvvelenamentoSingleton.getIstanza();
        if(this.id_status.equals("Sonno"))
        this.StatusCura= new Sonno();
    }
    @Override
    public void ApplicaEffettoStrumento(Personaggio P) {
        if(P.getStatus().getNome()==this.StatusCura.getNome())
        P.setStatus(null);
        System.out.println(P.getNomePersonaggio()+" è stato curato da "+this.StatusCura.getNome());
        
    }
    @Override
    public ArrayList<Personaggio> Utilizzabile(ArrayList<Personaggio> a) {
        ArrayList<Personaggio> u= new ArrayList<>();
        for(Personaggio p: a){
         if(p.getStatus()!=null&&p.getStatus().getNome().equals(this.StatusCura.getNome()))u.add(p);
       else{u.add(null);}
        }
        
          return u;
    }
    public StatusStrategy getStatusCura() {
        return StatusCura;
    }
    public void setStatusCura(StatusStrategy statusCura) {
        StatusCura = statusCura;
    }
    public String getId_status() {
        return id_status;
    }
    public void setId_status(String id_status) {
        this.id_status = id_status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
