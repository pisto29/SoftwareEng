package Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class View {

    public int ScegliMossa() throws IOException{
        int scelta;
        do{
            System.out.println("Scegli una mossa");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            scelta = Integer.parseInt(s);
        }
        while(scelta<1 || scelta>4);
        return scelta;


    }

    public int ScegliStrumento(int i) throws IOException{
        int scelta;
        do{
            System.out.println("Scegli uno strumento da utilizzare");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            scelta = Integer.parseInt(s);
        }
        while(scelta<1 || scelta>i);
        return scelta;
    }

    public int ScegliCambio(int i) throws IOException{
        int scelta;
        do{
            System.out.println("Scegli il Pokemon da mandare in campo");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            scelta = Integer.parseInt(s);
        }
        while(scelta<1 || scelta>i);
        return scelta-1;
    }

    public int ScegliAzione(Giocatore g) throws IOException{
        
        System.out.println(g.getNome()+" Scegli un'azione:");
        System.out.println("1) ATTACCA");
        System.out.println("2) SOSTITUZIONE");
        System.out.println("3) STRUMENTO");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int scelta = Integer.parseInt(s);
        return scelta;

    }
    
}
