package Entity;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Foundation.builder;

public class CompetitionFactorySingleton {
    private static CompetitionFactorySingleton istanza;
    private CompetitionFactorySingleton() {
    }
    public static CompetitionFactorySingleton getIstanza(){
        if(istanza==null){
            istanza=new CompetitionFactorySingleton();
        }
        return istanza;
    }

    public Torneo creaTorneo(String formato_torneo, int numeroPartecipanti, boolean accessibilita,String id_regolamento) throws FileNotFoundException{
        Torneo t;
        switch(formato_torneo){
            case "Italiana":
                t = new TorneoItaliana(numeroPartecipanti,accessibilita,id_regolamento);
                break;
            case "Eliminazione":
                t = new TorneoEliminazioneDiretta(numeroPartecipanti,accessibilita,id_regolamento);
                break;
            case "Squadre":
                t = new TorneoSquadre(numeroPartecipanti, accessibilita, id_regolamento);
                break;
            default : t = null;

        }
        return t;
    }
    public  RegolamentoComponent CreaRegolamento(String id) throws FileNotFoundException{
        RegolamentoComponent E=null;
        if(id.contains("Multipla")){
                ArrayList <Effetto> effetti = new ArrayList<>();
            
              
                RegolamentoComposite A = builder.creaRegolamentoComposite(id);
                ArrayList<RegolamentoComponent> regole=new ArrayList<>();
                A.setRegole(regole);
                for (String nomeEffetto : A.getIdRegole()) {
                    
                    String effetto = nomeEffetto.split("_")[0];
                    switch(effetto){
                        case "RegolaLimitazioneNPersonaggi":
                        E = builder.creaRegolaLimitazionenLimitazioneNPersonaggi(id);
                        A.Add(E);
                        break;

                        case "RegolaLimitazioneNStrumento":
                        E = builder.creaRegolaLimitazionenLimitazioneNStrumento(id);
                        A.Add(E);
                        break;

                        case "RegolaLimitazioneTipo":
                        E = builder.creaRegolaLimitazioneTipo(id);
                        A.Add(E);
                        break;

                    
                        case "NoRegole":
                        E = new NoRegole();
                        A.Add(E);
                        break;
                    }
                    
                }
             E = A;
        }
        else{
           
            String classe = id.split("_")[0];
                    switch(classe){
                        case "RegolaLimitazioneNPersonaggi":
                        E = builder.creaRegolaLimitazionenLimitazioneNPersonaggi(id);
                       
                        break;

                        case "RegolaLimitazioneNStrumento":
                        E = builder.creaRegolaLimitazionenLimitazioneNStrumento(id);
                        
                        break;

                        case "RegolaLimitazioneTipo":
                        E = builder.creaRegolaLimitazioneTipo(id);
                        
                        break;


                        case "NoRegole":
                        //E = gson.fromJson(br2, NoRegole.class);
                        E= new NoRegole();
                       
                        break;
                    }

        }
        return E;
    }
    
}
