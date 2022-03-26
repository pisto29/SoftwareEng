package Entity;
// Your First Program

class Personaggio {
    private String nomePersonaggio;
    private int pS;
    private int attaccoPersonaggio;
    private int difesaPersonaggio;
    private int attaccoSpecialePersonaggio;
    private int difesaSpecialePersonaggio;
    private int velocitàPersonaggio;
    private boolean abilitazioneAttacco;
    
    
    public Personaggio(String nomePersonaggio, int pS, int attaccoPersonaggio, int difesaPersonaggio,
            int attaccoSpecialePersonaggio, int difesaSpecialePersonaggio, int velocitàPersonaggio,
            boolean abilitazioneAttacco) {
        this.nomePersonaggio = nomePersonaggio;
        this.pS = pS;
        this.attaccoPersonaggio = attaccoPersonaggio;
        this.difesaPersonaggio = difesaPersonaggio;
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
        this.velocitàPersonaggio = velocitàPersonaggio;
        this.abilitazioneAttacco = abilitazioneAttacco;
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
        return attaccoPersonaggio;
    }


    public void setAttaccoPersonaggio(int attaccoPersonaggio) {
        this.attaccoPersonaggio = attaccoPersonaggio;
    }


    public int getDifesaPersonaggio() {
        return difesaPersonaggio;
    }


    public void setDifesaPersonaggio(int difesaPersonaggio) {
        this.difesaPersonaggio = difesaPersonaggio;
    }


    public int getAttaccoSpecialePersonaggio() {
        return attaccoSpecialePersonaggio;
    }


    public void setAttaccoSpecialePersonaggio(int attaccoSpecialePersonaggio) {
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
    }


    public int getDifesaSpecialePersonaggio() {
        return difesaSpecialePersonaggio;
    }


    public void setDifesaSpecialePersonaggio(int difesaSpecialePersonaggio) {
        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
    }


    public int getVelocitàPersonaggio() {
        return velocitàPersonaggio;
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

    



    

}
