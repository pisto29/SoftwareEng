package Entity;

public class EffettoStatus implements Effetto {

    
    private String id;
    private StatusStrategy statusApplicato;
    private String id_status;
    private String msg;
    public EffettoStatus(String id) {
        this.id = id;
        this.msg=" è ora affetto da "+this.statusApplicato.getNome();
    }
    public EffettoStatus(EffettoStatus E){
        this.id=E.getId();
        this.id_status=E.getId_status();
        this.msg=E.getMsg();
        if(this.id_status.equals("Paralisi"))
        this.statusApplicato=ParalisiSingleton.getIstanza();
        if(this.id_status.equals("Avvelenamento"))
        this.statusApplicato=AvvelenamentoSingleton.getIstanza();
        if(this.id_status.equals("Sonno"))
        this.statusApplicato= new Sonno();
        this.msg=" è ora affetto da "+this.statusApplicato.getNome();
    }
    @Override
    public void ApplicaEffetto(Personaggio p1) {
        if(p1.getStatus()!=null){
            System.out.println(p1.getNomePersonaggio()+" è già affetta da "+p1.getStatus().getNome());
        }
        else{
      p1.setStatus(this.statusApplicato);
       System.out.println(p1.getNomePersonaggio()+this.msg);}
      
       
    }

  

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public StatusStrategy getStatusApplicato() {
        return statusApplicato;
    }
    public void setStatusApplicato(StatusStrategy statusApplicato) {
        this.statusApplicato = statusApplicato;
    }
    public String getId_status() {
        return id_status;
    }
    public void setId_status(String id_status) {
        this.id_status = id_status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
