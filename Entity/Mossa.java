package Entity;

import  java.util.*;

public class Mossa {

    private String nomeMossa;
    private int danno;
    private int pp;
    private float percentualeCritico;
    private int precisione;
    private Personaggio bersaglio;
    private float percentualeAttivazzioneEffetto;
    private Tipo tipo;
    private Tipologia tipologia;
   
    

    public Mossa(String nomeMossa, int danno, int pp, float percentualeCritico, int precisione,
            Personaggio bersaglio, float percentualeAttivazzioneEffetto, Tipo tipo, Tipologia tipologia) {
        this.nomeMossa = nomeMossa;
        this.danno = danno;
        this.pp = pp;
        this.percentualeCritico = percentualeCritico;
        this.precisione = precisione;
        this.bersaglio = bersaglio;
        this.percentualeAttivazzioneEffetto = percentualeAttivazzioneEffetto;
        this.tipo = tipo;
        this.tipologia = tipologia;
         
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


    public float getPercentualeCritico() {
        return percentualeCritico;
    }


    public void setPercentualeCritico(float percentualeCritico) {
        this.percentualeCritico = percentualeCritico;
    }


    public int getPrecisione() {
        return precisione;
    }


    public void setPrecisione(int precisione) {
        this.precisione = precisione;
    }


    public Personaggio getBersaglio() {
        return bersaglio;
    }


    public void setBersaglio(Personaggio bersaglio) {
        this.bersaglio = bersaglio;
    }


    public float getPercentualeAttivazzioneEffetto() {
        return percentualeAttivazzioneEffetto;
    }


    public void setPercentualeAttivazzioneEffetto(float percentualeAttivazzioneEffetto) {
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

    public void ApplicaEffettoMossa(){

    }

    public boolean CheckEffetto(){
        int check = new Random().nextInt(100);

        if (check < percentualeAttivazzioneEffetto)
            return true;
        else
        return false;
    }
    


}
