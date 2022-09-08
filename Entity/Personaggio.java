package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import Foundation.builder;

public class Personaggio {

    private String nomePersonaggio;
    private int pS;
    private int attaccoPersonaggio;
    private int difesaPersonaggio;
    private int attaccoSpecialePersonaggio;
    private int difesaSpecialePersonaggio;
    private int velocitaPersonaggio;
    private RuoloState ruolo;
    private String[] id_mosse;
    private String id_abilita;
    private ArrayList<Mossa> mossas;
    private ArrayList<Tipo> tipos;
    private StatusStrategy status;
    private Abilità abilità;
    private String[] id_tipo;
    
    


  


    public Personaggio(String nomePersonaggio, int pS, int attaccoPersonaggio, int difesaPersonaggio,
            int attaccoSpecialePersonaggio, int difesaSpecialePersonaggio, int velocitaPersonaggio, RuoloState ruolo,
            String[] id_mosse, String id_abilita, Mossa[] mossas, Tipo[] tipos, StatusStrategy status,
            Abilità abilità) {
        this.nomePersonaggio = nomePersonaggio;
        this.pS = pS;
        this.attaccoPersonaggio = attaccoPersonaggio;
        this.difesaPersonaggio = difesaPersonaggio;
        this.attaccoSpecialePersonaggio = attaccoSpecialePersonaggio;
        this.difesaSpecialePersonaggio = difesaSpecialePersonaggio;
        this.velocitaPersonaggio = velocitaPersonaggio;
        this.ruolo = ruolo;
        this.id_mosse = id_mosse;
        this.id_abilita = id_abilita;
       
        this.status = status;
        this.abilità = abilità;
    }

    public Personaggio(Personaggio p) throws FileNotFoundException{
        p.setRuolo(PersonaggioPanchinaSingleton.getIstanza());
        this.nomePersonaggio = p.getNomePersonaggio();
        this.pS = p.getpS();
        this.attaccoPersonaggio = p.getAttaccoPersonaggio();
        this.difesaPersonaggio = p.getDifesaPersonaggio();
        this.attaccoSpecialePersonaggio = p.getAttaccoSpecialePersonaggio();
        this.difesaSpecialePersonaggio = p.getDifesaSpecialePersonaggio();
        this.velocitaPersonaggio = p.getvelocitaPersonaggio();
        
        this.ruolo = PersonaggioPanchinaSingleton.getIstanza();
        
        this.id_mosse = p.getId_mosse();
        this.id_abilita = p.getId_abilita();
        this.id_tipo=p.getId_tipo();
        
        this.mossas=new ArrayList<>();
        this.tipos=new ArrayList<>();
        for(String st: this.id_mosse){
            
            this.mossas.add(builder.CreaMossa(st));
        }
        for(String st: this.id_tipo){
            
            this.tipos.add(TipoFactorySingleton.getIstanza().Create(st));
        }
        this.abilità=builder.CreaAbilità(this.id_abilita);
        this.status = null;
        
        

    }


    public boolean puoattaccare(){
        return this.ruolo.isAbilitato();
    }
   public Abilità getAbilità() {
        return abilità;
    }



    public void setAbilità(Abilità abilità) {
        this.abilità = abilità;
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
        if(this.status!=null){
            this.status.EffettoApplicazione(this);
        }
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




    public int getvelocitaPersonaggio() {
         
        return (int) this.ruolo.getVelocita(this.velocitaPersonaggio);
    }




    public void setvelocitaPersonaggio(int velocitaPersonaggio) {

        this.velocitaPersonaggio = velocitaPersonaggio;
    }





    public RuoloState getRuolo() {

        return ruolo;
    }




    public void setRuolo(RuoloState ruolo) {

        this.ruolo = ruolo;
    }




    public ArrayList<Mossa> getMossas() {

        return mossas;
    }




    public void setMossas(ArrayList<Mossa> mossas) {

        this.mossas = mossas;
    }




    public ArrayList<Tipo> getTipos() {

        return tipos;
    }




    public void setTipos(ArrayList<Tipo> tipos) {

        this.tipos = tipos;
    }

    

    public float Attacca(String IDmossa){
        
       
        int i=0;
        for (Mossa mossa : mossas) {
            if (mossa.getNomeMossa()==IDmossa)
            break;
            i++;
        }
       
      return  this.ruolo.Attacca(this,this.mossas.get(i));
    }

    public boolean Difendi(float danno, Mossa m){
        return this.ruolo.Difendi(this, m, danno);
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



    public String[] getId_mosse() {
        return id_mosse;
    }



    public void setId_mosse(String[] id_mosse) {
        this.id_mosse = id_mosse;
    }



    public String getId_abilita() {
        return id_abilita;
    }



    public void setId_abilita(String id_abilita) {
        this.id_abilita = id_abilita;
    }

    public String[] getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String[] id_tipo) {
        this.id_tipo = id_tipo;
    }
    public boolean attacca(){
        return this.ruolo.attacca();
    }
    public boolean difendi(){
        return this.ruolo.difende();
    }
    public void setAttacca(boolean b){
        this.ruolo.setAttacca(b);
    }
    public void setDifende(boolean a){
        this.ruolo.setDifende(a);
    }
    @Override
    public String toString() {
        return "Personaggio [abilità=" + abilità + ", attaccoPersonaggio=" + attaccoPersonaggio
                + ", attaccoSpecialePersonaggio=" + attaccoSpecialePersonaggio + ", difesaPersonaggio="
                + difesaPersonaggio + ", difesaSpecialePersonaggio=" + difesaSpecialePersonaggio + ", id_abilita="
                + id_abilita + ", id_mosse=" + Arrays.toString(id_mosse) + ", id_tipo=" + Arrays.toString(id_tipo)
                + ", mossas=" + mossas + ", nomePersonaggio=" + nomePersonaggio + ", pS=" + pS + ", ruolo=" + ruolo
                + ", status=" + status + ", tipos=" + tipos + ", velocitaPersonaggio=" + velocitaPersonaggio + "]";
    }
}
