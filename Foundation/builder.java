package Foundation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;

import com.google.gson.Gson;

import Entity.Strumento;
import Entity.main;

public class builder {
    static Strumento CreaStrumento(String id) throws FileNotFoundException{
        Gson gson = new Gson();
        //String filePath = new File("").getAbsolutePath();
        //filePath.concat("path to the property file");
    BufferedReader br = new BufferedReader(new FileReader("C:/Users/alest/Documents/alessandro/SoftwareEng/Foundation/file/strumento.json"));
        //new File(".").getAbsolutePath();
        Strumento strumento = gson.fromJson(br, Strumento.class); 
        return strumento;
       
    }
    public static void main(String[] args) throws FileNotFoundException {
       Strumento a= builder.CreaStrumento("strumento");
       // System.out.println(a.getNomeStrumento());
      // new File(".").getAbsolutePath();
    }
}
