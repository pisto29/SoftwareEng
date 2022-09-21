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
    private ArrayList<String> idEffettiSelf;
    private ArrayList<Effetto> effetti_self;
    private ArrayList<String> idEffetti;
    private ArrayList<Effetto> effetti;
    

    

    public Mossa(String nomeMossa, int danno, int pp, int percentualeCritico, int precisione,
            int percentualeAttivazzioneEffetto, String idTipo, Tipo tipo, Tipologia tipologia,
            ArrayList<String> idEffettiSelf, ArrayList<Effetto> effetti_self, ArrayList<String> idEffetti,
            ArrayList<Effetto> effetti) {
        this.nomeMossa = nomeMossa;
        this.danno = danno;
        this.pp = pp;
        this.percentualeCritico = percentualeCritico;
        this.precisione = precisione;
        this.percentualeAttivazzioneEffetto = percentualeAttivazzioneEffetto;
        this.idTipo = idTipo;
        this.tipo = tipo;
        this.tipologia = tipologia;
        this.idEffettiSelf = idEffettiSelf;
        this.effetti_self = effetti_self;
        this.idEffetti = idEffetti;
        this.effetti = effetti;
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
        this.effetti=new ArrayList<>();
        for(String s: idEffetti)
        this.effetti.add(EffettiFactorySingleton.getIstanza().CreaEffetto(s));
        this.effetti_self=new ArrayList<>();
        for(String s: idEffettiSelf)
        this.effetti_self.add(EffettiFactorySingleton.getIstanza().CreaEffetto(s));
        this.tipo = TipoFactorySingleton.getIstanza().Create(this.idTipo);
       
    }
public void RiportaUtilizzo(){
    this.pp--;
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
        if(this.CheckEffetto()){
            for (Effetto effetto : effetti_self) {
                effetto.ApplicaEffetto(utilizzatore);
            }
            for (Effetto effetto : effetti) {
                effetto.ApplicaEffetto(bersaglio);
            }
        
        }
    }

    public boolean CheckEffetto(){
        int check = new Random().nextInt(100);

        if (check < percentualeAttivazzioneEffetto)
            return true;
        else
        return false;
    }

    public boolean miss(){
        int check = new Random().nextInt(100);

        if (check < precisione)
            return false;
        else
        return true;
    }
  

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }


    public ArrayList<String> getIdEffettiSelf() {
        return idEffettiSelf;
    }


    public void setIdEffettiSelf(ArrayList<String> idEffettiSelf) {
        this.idEffettiSelf = idEffettiSelf;
    }


    public ArrayList<Effetto> getEffetti_self() {
        return effetti_self;
    }


    public void setEffetti_self(ArrayList<Effetto> effetti_self) {
        this.effetti_self = effetti_self;
    }


    public ArrayList<String> getIdEffetti() {
        return idEffetti;
    }


    public void setIdEffetti(ArrayList<String> idEffetti) {
        this.idEffetti = idEffetti;
    }


    public ArrayList<Effetto> getEffetti() {
        return effetti;
    }


    public void setEffetti(ArrayList<Effetto> effetti) {
        this.effetti = effetti;
    }

  
    


}
