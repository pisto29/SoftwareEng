package Entity;



public class Personaggio {
    private String nomePersonaggio;
    private int pS;
    private int attaccoPersonaggio;
    private int difesaPersonaggio;
    private int attaccoSpecialePersonaggio;
    private int difesaSpecialePersonaggio;
    private int velocitàPersonaggio;
    private boolean abilitazioneAttacco;
    private RuoloState ruolo;
    private Mossa[] mossas;
    private Tipo[] tipos;
    
    


    public Personaggio(String nomePersonaggio, int pS, int attaccoPersonaggio, int difesaPersonaggio,
            int attaccoSpecialePersonaggio, int difesaSpecialePersonaggio, int velocitàPersonaggio,
            boolean abilitazioneAttacco, RuoloState ruolo, Mossa[] mossas, Tipo[] tipos) {
        this.nomePersonaggio = nomePersonaggio;
        this.pS = pS;
        this.attaccoPersonaggio = attaccoPersonaggio;
        this.difesaPersonaggio = difesaPersonaggio;
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
        this.velocitàPersonaggio = velocitàPersonaggio;
        this.abilitazioneAttacco = abilitazioneAttacco;
        this.ruolo = ruolo;
        this.mossas = mossas;
        this.tipos = tipos;
    }



    public String getNomePersonaggio() {

        return nomePersonaggio;
    }




    public void setNomePersonaggio(String nomePersonaggio) {

        this.nomePersonaggio = nomePersonaggio;
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




    public boolean isAbilitazioneAttacco() {

        return abilitazioneAttacco;
    }




    public void setAbilitazioneAttacco(boolean abilitazioneAttacco) {

        this.abilitazioneAttacco = abilitazioneAttacco;
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

    

    public void Attacca(String IDmossa){
        
        int pos=0;
        int i=0;
        for (Mossa mossa : mossas) {
            if (mossa.getNomeMossa()==IDmossa)
            pos=i;
            i++;
        }
        this.ruolo.Attacca(this,mossas[i] );
    }



   /*  public void difendi( int danno,Tipo tipo, Tipologia tipologia){
        int dannoSubito=this.ruolo.Difendi(this, danno, tipo, tipologia);
        this.setpS(this.pS-dannoSubito);
    }*/



    

}
