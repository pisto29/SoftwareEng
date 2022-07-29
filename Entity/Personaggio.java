package Entity;



public class Personaggio {

    private String nomePersonaggio;
    private int pS;
    private int attaccoPersonaggio;
    private int difesaPersonaggio;
    private int attaccoSpecialePersonaggio;
    private int difesaSpecialePersonaggio;
    private int velocitàPersonaggio;
    
    private RuoloState ruolo;
    private Mossa[] mossas;
    private Tipo[] tipos;
    private StatusStrategy status;
    private Abilità abilità;
    
    


  


    public Abilità getAbilità() {
        return abilità;
    }



    public void setAbilità(Abilità abilità) {
        this.abilità = abilità;
    }



    public Personaggio(String nomePersonaggio, int pS, int attaccoPersonaggio, int difesaPersonaggio,
            int attaccoSpecialePersonaggio, int difesaSpecialePersonaggio, int velocitàPersonaggio,
            RuoloState ruolo, Mossa[] mossas, Tipo[] tipos, Abilità abilità) {
        this.nomePersonaggio = nomePersonaggio;
        this.pS = pS;
        this.attaccoPersonaggio = attaccoPersonaggio;
        this.difesaPersonaggio = difesaPersonaggio;
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
        this.velocitàPersonaggio = velocitàPersonaggio;
        this.ruolo = ruolo;
        this.mossas = mossas;
        this.tipos = tipos;
        this.status=null;
        this.abilità=abilità;
    }



    public String getNomePersonaggio() {

        return nomePersonaggio;
    }




    public void setNomePersonaggio(String nomePersonaggio) {

        this.nomePersonaggio = nomePersonaggio;
    }

  public StatusStrategy getStatus() {
        return status;
    }



    public void setStatus(StatusStrategy status) {
        this.status = status;
    }



    public int getpS() {

        return pS;
    }




    public void setpS(int pS) {

        this.pS = pS;
    }




    public int getAttaccoPersonaggio() {

        return (int) this.ruolo.getAttacco(this.attaccoPersonaggio);
    }




    public void setAttaccoPersonaggio(int attaccoPersonaggio) {

        this.attaccoPersonaggio = attaccoPersonaggio;
    }




    public int getDifesaPersonaggio() {

        return (int) this.ruolo.getDifesa(this.difesaPersonaggio);
    }




    public void setDifesaPersonaggio(int difesaPersonaggio) {
        this.difesaPersonaggio = difesaPersonaggio;
    }




    public int getAttaccoSpecialePersonaggio() {

        return (int) this.ruolo.getAttaccoSpecile(this.attaccoSpecialePersonaggio);
    }




    public void setAttaccoSpecialePersonaggio(int attaccoSpecialePersonaggio) {
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
    }




    public int getDifesaSpecialePersonaggio() {

        return (int) this.ruolo.getDifesaSpeciale(this.difesaSpecialePersonaggio);
    }




    public void setDifesaSpecialePersonaggio(int difesaSpecialePersonaggio) {

        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
    }




    public int getVelocitàPersonaggio() {

        return (int) this.ruolo.getVelocita(this.velocitàPersonaggio);
    }




    public void setVelocitàPersonaggio(int velocitàPersonaggio) {

        this.velocitàPersonaggio = velocitàPersonaggio;
    }





    public RuoloState getRuolo() {

        return ruolo;
    }




    public void setRuolo(RuoloState ruolo) {

        this.ruolo = ruolo;
    }




    public Mossa[] getMossas() {

        return mossas;
    }




    public void setMossas(Mossa[] mossas) {

        this.mossas = mossas;
    }




    public Tipo[] getTipos() {

        return tipos;
    }




    public void setTipos(Tipo[] tipos) {

        this.tipos = tipos;
    }

    

    public float Attacca(String IDmossa){
        
       
        int i=0;
        for (Mossa mossa : mossas) {
            if (mossa.getNomeMossa()==IDmossa)
            
            i++;
        }
      return  this.ruolo.Attacca(this,mossas[i]);
    }

    public void Difendi(float danno, Mossa m){
        this.ruolo.Difendi(this, m, danno);
    }

    public PersonaggioAttivoImplementator getImplementator(){
        return this.ruolo.getImplementator();
    }

    public void Sostituzione(){
        this.ruolo.Sostituzione(this);
    }

    
    public void aggiungiMoltiplicatoreAttacco(float moltiplicatore) {
        // TODO Auto-generated method stub
        this.ruolo.aggiungiMoltiplicatoreAttacco(moltiplicatore);
    }



    
    public void aggiungiMoltiplicatoreAttaccoSpeciale(float moltiplicatore) {
        // TODO Auto-generated method stub
        this.ruolo.aggiungiMoltiplicatoreAttaccoSpeciale(moltiplicatore);
    }



    
    public void aggiungiMoltiplicatoreDifesa(float moltiplicatore) {
        // TODO Auto-generated method stub
        this.ruolo.aggiungiMoltiplicatoreDifesa(moltiplicatore);
    }



    
    public void aggiungiMoltiplicatoreDifesaSpeciale(float moltiplicatore) {
        // TODO Auto-generated method stub
        this.ruolo.aggiungiMoltiplicatoreDifesaSpeciale(moltiplicatore);
        
    }



    public void aggiungiMoltiplicatoreVelocita(float moltiplicatore) {
        // TODO Auto-generated method stub
        this.ruolo.aggiungiMoltiplicatoreVelocita(moltiplicatore);
        
    }

    public void AbiltaAttacco() {
        
        this.ruolo.AbiltaAttacco();
    }
    
    
    public void DisabiltaAttacco() {
        
        this.ruolo.DisabiltaAttacco();
    }
   
    public void attivastatus(Fase f){
        if(this.status!=null){
            this.status.Attivazione(this,f);
        }
    }

    public void setImplementator(PersonaggioAttivoImplementator implementator){
        this.ruolo.setImplementator(implementator);
    }

    public int getPriorità(){
         return this.ruolo.getPriorità();
    }

    public void setPriorità(int p){
        this.ruolo.setPriorità(p);
    }
}
