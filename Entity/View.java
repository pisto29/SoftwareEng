package Entity;
import java.util.Scanner;
public class View {

    public int ScegliMossa(){
        int scelta;
        do{
            System.out.println("Scegli una mossa");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
        }
        while(scelta<1 || scelta>4);
        return scelta;


    }

    public int ScegliStrumento(int i){
        int scelta;
        do{
            System.out.println("Scegli uno strumento da utilizzare");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
        }
        while(scelta<1 || scelta>i);
        return scelta;
    }

    public int ScegliCambio(int i){
        int scelta;
        do{
            System.out.println("Scegli il Pokemon da mandare in campo");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
        }
        while(scelta<1 || scelta>i);
        return scelta;
    }

    public int ScegliAzione(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli un'azione:");
        System.out.println("1) ATTACCA");
        System.out.println("2) SOSTITUZIONE");
        System.out.println("3) STRUMENTO");
        int scelta = scanner.nextInt();
        scanner.close();
        
        return scelta;

    }
    
}
