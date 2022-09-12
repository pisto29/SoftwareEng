package Foundation;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import Entity.*;
import Entity.EffettoCura;

public class builder {
    //EFFETTI MOSSE
    public static EffettoMultiploComposite creaEffettoMultiploComposite(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoMultiploComposite e =gson.fromJson(br, EffettoMultiploComposite.class); 
        
        return e;

    }
    public static EffettoAnnullaMossa creaEffettoAnnullaMossa(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoAnnullaMossa e = new EffettoAnnullaMossa(gson.fromJson(br, EffettoAnnullaMossa.class)); 
        
        return e;

    }
    public static EffettoModificaAttacco creaEffettoModificaAttacco(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoModificaAttacco e = new EffettoModificaAttacco(gson.fromJson(br, EffettoModificaAttacco.class)); 
        
        return e;

    }
    public static EffettoModificaVelocita creaEffettoModificaVelocita(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoModificaVelocita e = new EffettoModificaVelocita(gson.fromJson(br, EffettoModificaVelocita.class)); 
        
        return e;

    }
    public static EffettoStatus creaEffettoStatus(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoStatus e = new EffettoStatus(gson.fromJson(br, EffettoStatus.class)); 
        
        return e;

    }
    public static EffettoModificaDifesa creaEffettoModificaDifesa(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoModificaDifesa e = new EffettoModificaDifesa(gson.fromJson(br, EffettoModificaDifesa.class)); 
        
        return e;

    }
    public static EffettoModificaAttaccoSpeciale creaEffettoModificaAttaccoSpeciale(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoModificaAttaccoSpeciale e = new EffettoModificaAttaccoSpeciale(gson.fromJson(br, EffettoModificaAttaccoSpeciale.class)); 
        
        return e;

    }
    public static EffettoModificaDifesaSpeciale creaEffettoModificaDifesaSpeciale(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+id+".json"));
        
        EffettoModificaDifesaSpeciale e = new EffettoModificaDifesaSpeciale(gson.fromJson(br, EffettoModificaDifesaSpeciale.class)); 
        
        return e;

    }
/////////////fine effetti mosse/////////////////////////
////////////EFFETTI STRUMENTO//////////////////////////
public static EffettoCura creaEffettoCura(String id) throws FileNotFoundException{
    Gson gson = new Gson();
    
    BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
    
    EffettoCura e =gson.fromJson(br, EffettoCura.class);
    
    return e;

}
public static EffettoRevitalizzante creaEffettoRevitalizzante(String id) throws FileNotFoundException{
    Gson gson = new Gson();
    
    BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
    
    EffettoRevitalizzante e =gson.fromJson(br, EffettoRevitalizzante.class);
    
    return e;

}
public static EffettoRimozioneStatus creaEffettoRimozioneStatus(String id) throws FileNotFoundException{
    Gson gson = new Gson();
    
    BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
    
    EffettoRimozioneStatus e=new EffettoRimozioneStatus(gson.fromJson(br, EffettoRimozioneStatus.class));
    
    return e;

}
//////// fine strumenti/////

    public static Strumento CreaStrumento(String id) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/strumento/"+id+".json"));
        //new File(".").getAbsolutePath();
        Strumento strumento = new Strumento(gson.fromJson(br, Strumento.class)); 
        //strumento.setEffetto();
        return strumento;
       
    }
    public static Mossa CreaMossa(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/mosse/"+id+".json"));
        
        Mossa m= new Mossa(gson.fromJson(br, Mossa.class));
        
        return m;
       
    }

    public static Personaggio CreaPersonaggio(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/personaggio/"+id+".json"));
        
        Personaggio p=gson.fromJson(br, Personaggio.class);
        
        return p;
       
    }

    public static Squadra creaSquadra(String id) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/squadra/"+id+".json"));
        
        Squadra s= gson.fromJson(br, Squadra.class);
        BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/squadra/mapsquadra/S"+id+".json"));
        Type type =new TypeToken<HashMap<String, String[]>>(){}.getType();        
        HashMap<String, String[]> map = gson.fromJson(br2, type);
        s.setId(map);
        //System.out.println(map.entrySet());
        Squadra s2= new Squadra(s);
        return s2;
       
    }

    public static Abilità CreaAbilità(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/abilita/"+id+".json"));
        String nome = id.split("_")[0];
        Abilità a=null;
        switch(nome){
            case "Multiuso":
             a= new AbilitàMultiuso(gson.fromJson(br, AbilitàMultiuso.class));
             break;
             case "Monouso":
             a= new AbilitàMonouso(gson.fromJson(br, AbilitàMonouso.class));
             break;
        }
        
        
        return a;
       
    }


    public static Tipo CreaTipo(String id) throws FileNotFoundException{
        Gson gson = new Gson();
       
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/tipo/"+id+".json"));
        
        Tipo t=gson.fromJson(br, Tipo.class);
        
        BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Efficacia/E"+id+".json"));
        Type type =new TypeToken<HashMap<String, Float>>(){}.getType();        
        HashMap<String, Float> map = gson.fromJson(br2, type);
        t.setEfficacia(map);

        
        return t;
       
    }

    public static  EffettoStrumento CreaEffettoStrumento(String id,String classe) throws FileNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
       
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
        
        String effetto = id.split("_")[0];
        
        EffettoStrumento E = null;
        switch(classe){
            case "EffettoCura" :
                E = gson.fromJson(br, EffettoCura.class);
                break;
            case "EffettoRimozioneStatus" :
                E =new EffettoRimozioneStatus( gson.fromJson(br, EffettoRimozioneStatus.class));
                break;
            case "EffettoRevitalizzante" :
                E = gson.fromJson(br, EffettoRevitalizzante.class);
                break;

        }
        
        return E;
    }

    public static  EffettoStrumento CreaEffettoStrumento2(String id,Class a) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
       
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
        
       
        
        EffettoStrumento E = null;
        
            
        E = (EffettoStrumento) gson.fromJson(br, a);
       
        
        return E;
    }


    public static EffettoComposite CreaEffettoComposite(String idEffettoMossa) throws FileNotFoundException {
        Gson gson = new Gson();
        EffettoComposite E=null;
        if(idEffettoMossa.contains("Multiplo")){
                ArrayList <EffettoComposite> effetti = new ArrayList<>();
            
                BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+idEffettoMossa+".json"));
                EffettoMultiploComposite A = gson.fromJson(br, EffettoMultiploComposite.class);
                A.setEffetti(effetti);
                for (String nomeEffetto : A.getIdEffetti()) {
                    BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+nomeEffetto+".json"));
                    String effetto = nomeEffetto.split("_")[0];
                    switch(effetto){
                        case "EffettoAnnullaMossa":
                        E = new EffettoAnnullaMossa( gson.fromJson(br2, EffettoAnnullaMossa.class));
                        A.Add(E);
                        break;

                        case "EffettoModificaAttacco":
                        E = new EffettoModificaAttacco(gson.fromJson(br2, EffettoModificaAttacco.class));
                        A.Add(E);
                        break;

                        case "EffettoModificaAttaccoSpeciale":
                        E = new EffettoModificaAttaccoSpeciale(gson.fromJson(br2, EffettoModificaAttaccoSpeciale.class));
                        A.Add(E);
                        break;

                        case "EffettoModificaDifesa":
                        E = new EffettoModificaDifesa(gson.fromJson(br2, EffettoModificaDifesa.class));
                        A.Add(E);
                        break;

                        case "EffettoModificaDifesaSpeciale":
                        E = new EffettoModificaDifesaSpeciale(gson.fromJson(br2, EffettoModificaDifesaSpeciale.class));
                        A.Add(E);
                        break;

                        case "EffettoModificaVelocita":
                        E = new EffettoModificaVelocita(gson.fromJson(br2, EffettoModificaVelocita.class));
                        A.Add(E);
                        break;

                        case "EffettoStatus":
                        E =new EffettoStatus( gson.fromJson(br2, EffettoStatus.class));
                        
                        A.Add(E);
                        break;
                        case "NoEffetto":
                        E = gson.fromJson(br2, NoEffetto.class);
                        A.Add(E);
                        break;
                    }
                    
                }
             E = A;
        }
        else{
            BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+idEffettoMossa+".json"));
            String effetto = idEffettoMossa.split("_")[0];
                    switch(effetto){
                        case "EffettoAnnullaMossa":
                        E = new EffettoAnnullaMossa( gson.fromJson(br2, EffettoAnnullaMossa.class));
                        break;

                        case "EffettoModificaAttacco":
                        E = new EffettoModificaAttacco(gson.fromJson(br2, EffettoModificaAttacco.class));
                        break;

                        case "EffettoModificaAttaccoSpeciale":
                        E = new EffettoModificaAttaccoSpeciale(gson.fromJson(br2, EffettoModificaAttaccoSpeciale.class));
                        break;

                        case "EffettoModificaDifesa":
                        E = new EffettoModificaDifesa(gson.fromJson(br2, EffettoModificaDifesa.class));
                        break;

                        case "EffettoModificaDifesaSpeciale":
                        E = new EffettoModificaDifesaSpeciale(gson.fromJson(br2, EffettoModificaDifesaSpeciale.class));
                        break;

                        case "EffettoModificaVelocita":
                        E = new EffettoModificaVelocita(gson.fromJson(br2, EffettoModificaVelocita.class));
                        break;

                        case "EffettoStatus":
                        E =new EffettoStatus( gson.fromJson(br2, EffettoStatus.class));
                        break;

                        case "NoEffetto":
                        E = gson.fromJson(br2, NoEffetto.class);
                       
                        break;
                    }

        }
        return E;

    }

    public static Giocatore CreaGiocatore(String id) throws FileNotFoundException, JsonSyntaxException, JsonIOException, ClassNotFoundException{
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/giocatore/"+id+".json"));
        
        Giocatore g= new Giocatore(gson.fromJson(br, Giocatore.class));


        return g;

    }
    public static RegolamentoComponent creaRegolamentoComposite2(String idRegolamento) throws FileNotFoundException {
        Gson gson = new Gson();
        RegolamentoComponent E=null;
        if(idRegolamento.contains("Multipla")){
                ArrayList <EffettoComposite> effetti = new ArrayList<>();
            
                BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effetto/"+idRegolamento+".json"));
                RegolamentoComposite A = gson.fromJson(br, RegolamentoComposite.class);
                ArrayList<RegolamentoComponent> regole=new ArrayList<>();
                A.setRegole(regole);
                for (String nomeEffetto : A.getIdRegole()) {
                    BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+nomeEffetto+".json"));
                    String effetto = nomeEffetto.split("_")[0];
                    switch(effetto){
                        case "RegolaLimitazioneNPersonaggi":
                        E = new RegolaLimitazioneNPersonaggi( gson.fromJson(br2, RegolaLimitazioneNPersonaggi.class));
                        A.Add(E);
                        break;

                        case "RegolaLimitazioneNStrumento":
                        E = new RegolaLimitazioneNStrumento(gson.fromJson(br2, RegolaLimitazioneNStrumento.class));
                        A.Add(E);
                        break;

                        case "RegolaLimitazioneTipo":
                        E = new RegolaLimitazioneTipo(gson.fromJson(br2, RegolaLimitazioneTipo.class));
                        A.Add(E);
                        break;

                    
                        case "NoRegole":
                        E = gson.fromJson(br2, NoRegole.class);
                        A.Add(E);
                        break;
                    }
                    
                }
             E = A;
        }
        else{
            BufferedReader br2 = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+idRegolamento+".json"));
            String effetto = idRegolamento.split("_")[0];
                    switch(effetto){
                        case "RegolaLimitazioneNPersonaggi":
                        E = new RegolaLimitazioneNPersonaggi( gson.fromJson(br2, RegolaLimitazioneNPersonaggi.class));
                       
                        break;

                        case "RegolaLimitazioneNStrumento":
                        E = new RegolaLimitazioneNStrumento(gson.fromJson(br2, RegolaLimitazioneNStrumento.class));
                        
                        break;

                        case "RegolaLimitazioneTipo":
                        E = new RegolaLimitazioneTipo(gson.fromJson(br2, RegolaLimitazioneTipo.class));
                        
                        break;


                        case "NoRegole":
                        //E = gson.fromJson(br2, NoRegole.class);
                        E= new NoRegole();
                       
                        break;
                    }

        }
        return E;

    }
    //REGOLE//
     
    public static RegolamentoComposite creaRegolamentoComposite(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+id+".json"));
        
        RegolamentoComposite e = gson.fromJson(br, RegolamentoComposite.class); 
        
        return e;

    }
    public static RegolaLimitazioneTipo creaRegolaLimitazioneTipo(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+id+".json"));
        
        RegolaLimitazioneTipo e = new RegolaLimitazioneTipo(gson.fromJson(br, RegolaLimitazioneTipo.class)); 
        
        return e;

    }
    public static RegolaLimitazioneNPersonaggi creaRegolaLimitazionenLimitazioneNPersonaggi(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+id+".json"));
        
        RegolaLimitazioneNPersonaggi e = new RegolaLimitazioneNPersonaggi(gson.fromJson(br, RegolaLimitazioneNPersonaggi.class)); 
        
        return e;

    }

    public static RegolaLimitazioneNStrumento creaRegolaLimitazionenLimitazioneNStrumento(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/"+id+".json"));
        
        RegolaLimitazioneNStrumento e = new RegolaLimitazioneNStrumento(gson.fromJson(br, RegolaLimitazioneNStrumento.class)); 
        
        return e;

    }


    //FINE REGOLE//
    public static void main(String[] args) throws FileNotFoundException {
      /* Mossa a= builder.CreaMossa("azione");
      Tipo t= builder.CreaTipo("Normale");
      System.out.println(t.getNomeTipo());
      System.out.println(t.getEfficacia("Roccia"));
      EffettoComposite EM = builder.CreaEffettoComposite("EffettoStatus_1");
      EM.ApplicaEffetto(null); */
      /* 
      Mossa m= builder.CreaMossa("Tuononda");
      System.out.println(m.getDanno());
      System.out.println(m.getNomeMossa());
      System.out.println(m.getIdEffetti());
      System.out.println(m.getIdTipo());
      System.out.println(m.getPercentualeAttivazzioneEffetto());
      System.out.println(m.getPercentualeCritico());
      System.out.println(m.getPp());
      System.out.println(m.getPrecisione());*/
       // Abilità a=builder.CreaAbilità("Multiuso_statico");
        //System.out.println(a.toString());
       // a.Attivazione(null, null);
       //Squadra s= builder.creaSquadra("squadra1");
       //Giocatore g = builder.CreaGiocatore("G1");
       //System.out.println(g.toString());
      /*for(Personaggio p: s.getPersonaggios()){
        System.out.println(p.toString());
      }*/
      RegolamentoComponent r=builder.creaRegolamentoComposite("RegolaLimitazioneNPersonaggi_3");
      System.out.println(r.toString());
    }
}

