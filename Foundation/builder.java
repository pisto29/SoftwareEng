package Foundation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entity.Strumento;
import Entity.Tipo;
import Entity.main;
import Entity.EffettoStrumento;
import Entity.Mossa;
import Entity.EffettoCura;
import Entity.EffettoRevitalizzante;
import Entity.EffettoRimozioneStatus;

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
        
        Mossa m=gson.fromJson(br, Mossa.class);
        
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

    public static void main(String[] args) throws FileNotFoundException {
       //Mossa a= builder.CreaMossa("azione");
      Tipo t= builder.CreaTipo("Normale");
      System.out.println(t.getNomeTipo());
      System.out.println(t.getEfficacia("Roccia"));
       
      
    }
}
