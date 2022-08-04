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
import com.google.gson.reflect.TypeToken;

import Entity.*;

public class builder {
    public static Strumento CreaStrumento(String id) throws FileNotFoundException{
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

    public static  EffettoStrumento CreaEffettoStrumento(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
        System.out.println("Print1");
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/effettoStrumento/"+id+".json"));
        System.out.println("PRINT2");
        String effetto = id.split("_")[0];
        System.out.println(effetto);
        EffettoStrumento E = null;
        switch(effetto){
            case "effettoCura" :
                E = gson.fromJson(br, EffettoCura.class);
                break;
            case "rimozioneStatus" :
                E = gson.fromJson(br, EffettoRimozioneStatus.class);
                break;
            case "revitalizzante" :
                E = gson.fromJson(br, EffettoRevitalizzante.class);
                break;

        }
        
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

    public static void main(String[] args) throws FileNotFoundException {
      /* Mossa a= builder.CreaMossa("azione");
      Tipo t= builder.CreaTipo("Normale");
      System.out.println(t.getNomeTipo());
      System.out.println(t.getEfficacia("Roccia"));
      EffettoComposite EM = builder.CreaEffettoComposite("EffettoStatus_1");
      EM.ApplicaEffetto(null); */
      Mossa m= builder.CreaMossa("Tuononda");
      System.out.println(m.getDanno());
      System.out.println(m.getNomeMossa());
      System.out.println(m.getIdEffetti());
      System.out.println(m.getIdTipo());
      System.out.println(m.getPercentualeAttivazzioneEffetto());
      System.out.println(m.getPercentualeCritico());
      System.out.println(m.getPp());
      System.out.println(m.getPrecisione());

      
    }
}
