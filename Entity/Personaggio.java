package Entity;
// Your First Program

class Personaggio {
    public String NomePersonaggio;
    public int PS;
    public int AttaccoPersonaggio;
    public int DifesaPersonaggio;
    public int AttaccoSpecialePersonaggio;
    public int DifesaSpecialePersonaggio;
    public int VelocitàPersonaggio;
    public boolean AbilitazioneAttacco;


    public Personaggio(String NomePersonaggio, int PS, int AttaccoPersonaggio,  int DifesaPersonaggio, int AttaccoSpecialePersonaggio, int DifesaSpecialePersonaggio, int VelocitàPersonaggio, boolean AbilitazioneAttacco){
        
        this.AttaccoPersonaggio = AttaccoPersonaggio;
        this.DifesaPersonaggio = DifesaPersonaggio;
        this.AttaccoSpecialePersonaggio = AttaccoSpecialePersonaggio;
        this.DifesaSpecialePersonaggio = DifesaSpecialePersonaggio;
        this.VelocitàPersonaggio = VelocitàPersonaggio;
        this.AbilitazioneAttacco = AbilitazioneAttacco; 


    }


    public String getNomePersonaggio(){return this.NomePersonaggio;}


    public void setNomePersonaggio(String nomePersonaggio) {
        NomePersonaggio = nomePersonaggio;
    }


    public int getPS() {
        return this.PS;
    }


    public void setPS(int PS) {
        this.PS = PS;
    }


    public int getAttaccoPersonaggio() {
        return AttaccoPersonaggio;
    }


    public void setAttaccoPersonaggio(int AttaccoPersonaggio) {
        this.AttaccoPersonaggio = AttaccoPersonaggio;
    }


    public int getDifesaPersonaggio() {
        return DifesaPersonaggio;
    }


    public void setDifesaPersonaggio(int DifesaPersonaggio) {
        this.DifesaPersonaggio = DifesaPersonaggio;
    }


    public int getAttaccoSpecialePersonaggio() {
        return AttaccoSpecialePersonaggio;
    }


    public void setAttaccoSpecialePersonaggio(int AttaccoSpecialePersonaggio) {
        this.AttaccoSpecialePersonaggio = AttaccoSpecialePersonaggio;
    }


    public int getDifesaSpecialePersonaggio() {
        return DifesaSpecialePersonaggio;
    }


    public void setDifesaSpecialePersonaggio(int DifesaSpecialePersonaggio) {
        this.DifesaSpecialePersonaggio = DifesaSpecialePersonaggio;
    }


    public int getVelocitàPersonaggio() {
        return VelocitàPersonaggio;
    }


    public void setVelocitàPersonaggio(int VelocitàPersonaggio) {
        this.VelocitàPersonaggio = VelocitàPersonaggio;
    }


    public boolean isAbilitazioneAttacco() {
        return AbilitazioneAttacco;
    }


    public void setAbilitazioneAttacco(boolean AbilitazioneAttacco) {
        this.AbilitazioneAttacco = AbilitazioneAttacco;
    }
    

}
