package Entity;

import java.io.FileNotFoundException;
import  java.util.*;

public class Mossa {

    private String nomeMossa;
    private int danno;
    private int pp;
    private int percentualeCritico;
    private int precisione;
    private int percentualeAttivazzioneEffetto;
    private String idTipo;
    private Tipo tipo;
    private Tipologia tipologia;
    private String idEffettiSelf;
    private EffettoComposite effetti_self;
    private String idEffetti;
    private EffettoComposite effetti;
    

    public Mossa(String nomeMossa, int danno, int pp, int percentualeCritico, int precisione,
             int percentualeAttivazzioneEffetto, Tipo tipo, Tipologia tipologia,
            EffettoComposite effetti_self,EffettoComposite effetti, String idTipo, String idEffetti, String idEffettiSelf) {
        this.nomeMossa = nomeMossa;
        this.danno = danno;
        this.pp = pp;
        this.percentualeCritico = percentualeCritico;
        this.precisione = precisione;
        this.percentualeAttivazzioneEffetto = percentualeAttivazzioneEffetto;
        this.tipo = tipo;
        this.tipologia = tipologia;
        this.effetti_self= effetti_self;
        this.effetti= effetti;
        this.idTipo = idTipo;
        this.idEffetti = idEffetti;
        this.idEffettiSelf = idEffettiSelf;
         
    }

    public Mossa(Mossa m) throws FileNotFoundException {
        this.nomeMossa = m.getNomeMossa();
        this.danno = m.getDanno();
        this.pp = m.getPp();
        this.percentualeCritico = m.getPercentualeCritico();
        this.precisione = m.getPrecisione();
        this.percentualeAttivazzioneEffetto = m.getPercentualeAttivazzioneEffetto();
        this.tipologia = m.getTipologia();
        this.idTipo = m.getIdTipo();
        this.idEffetti = m.getIdEffetti();
        this.idEffettiSelf = m.getIdEffettiSelf();
        this.effetti = FlyweightEffettoFactorySingleton.getIstanza().createEffetto(this.idEffetti);
        this.effetti_self = FlyweightEffettoFactorySingleton.getIstanza().createEffetto(this.idEffettiSelf);
        this.tipo = TipoFactorySingleton.getIstanza().Create(this.idTipo);
    }

    
    public String getNomeMossa() {
        return nomeMossa;
    }


    public void setNomeMossa(String nomeMossa) {
        this.nomeMossa = nomeMossa;
    }


    public int getDanno() {
        return danno;
    }


    public void setDanno(int danno) {
        this.danno = danno;
    }


    public int getPp() {
        return pp;
    }


    public void setPp(int pp) {
        this.pp = pp;
    }


    public int getPercentualeCritico() {
        return percentualeCritico;
    }


    public void setPercentualeCritico(int percentualeCritico) {
        this.percentualeCritico = percentualeCritico;
    }


    public int getPrecisione() {
        return precisione;
    }


    public void setPrecisione(int precisione) {
        this.precisione = precisione;
    }


   


    public int getPercentualeAttivazzioneEffetto() {
        return percentualeAttivazzioneEffetto;
    }


    public void setPercentualeAttivazzioneEffetto(int percentualeAttivazzioneEffetto) {
        this.percentualeAttivazzioneEffetto = percentualeAttivazzioneEffetto;
    }


    public Tipo getTipo() {
        return tipo;
    }


    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }


    public Tipologia getTipologia() {
        return tipologia;
    }


    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }
    
    public boolean CheckCritico(){

        int check = new Random().nextInt(100);

        if (check < percentualeCritico)
            return true;
        else
        return false;
    }

    public void ApplicaEffettoMossa(Personaggio utilizzatore, Personaggio bersaglio){
        this.effetti_self.ApplicaEffetto(utilizzatore);
        this.effetti.ApplicaEffetto(bersaglio);
    }

    public boolean CheckEffetto(){
        int check = new Random().nextInt(100);

        if (check < percentualeAttivazzioneEffetto)
            return true;
        else
        return false;
    }


    public EffettoComposite getEffetti_self() {
        return effetti_self;
    }


    public void setEffetti_self(EffettoComposite effetti_self) {
        this.effetti_self = effetti_self;
    }


    public EffettoComposite getEffetti() {
        return effetti;
    }


    public void setEffetti(EffettoComposite effetti) {
        this.effetti = effetti;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getIdEffettiSelf() {
        return idEffettiSelf;
    }

    public void setIdEffettiSelf(String idEffettiSelf) {
        this.idEffettiSelf = idEffettiSelf;
    }

    public String getIdEffetti() {
        return idEffetti;
    }

    public void setIdEffetti(String idEffetti) {
        this.idEffetti = idEffetti;
    }
    


}
