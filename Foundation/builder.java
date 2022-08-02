package Foundation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

import com.google.gson.Gson;

import Entity.Strumento;
import Entity.main;
import Entity.EffettoStrumento;
import Entity.EffettoCura;
import Entity.EffettoRevitalizzante;
import Entity.EffettoRimozioneStatus;

public class builder {
    public static Strumento CreaStrumento(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/"+id+".json"));
        //new File(".").getAbsolutePath();
        Strumento strumento = gson.fromJson(br, Strumento.class); 
        strumento.setEffetto();
        return strumento;
       
    }


    public static  EffettoStrumento CreaEffettoStrumento(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
        System.out.println("Print1");
        BufferedReader br = new BufferedReader(new FileReader(new File(".").getAbsolutePath()+"/Foundation/file/"+id+".json"));
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
        EffettoStrumento EffettoCura = gson.fromJson(br, EffettoCura.class); 
        return EffettoCura;
    }

    public static void main(String[] args) throws FileNotFoundException {
       Strumento a= builder.CreaStrumento("strumento");
       //a.UtilizzaStrumento(null);

       

       
      // new File(".").getAbsolutePath();
    }
}
