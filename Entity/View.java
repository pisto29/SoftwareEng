package Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
public class View {

public Personaggio SceltaPersonaggioCampo(Giocatore g,Squadra s){
    int scelta=0;
    do{
    System.out.println(g.getNome()+" scegli un Pokemon da mandare in campo");
    int i=1;
    for ( Personaggio pers : s.getPersonaggios()){
        if(pers.getpS()>0){
        System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
        }
        i++;
    }}
    while(scelta>=1&&scelta<=s.getPersonaggios().size());
    System.out.println(g.getNome()+"manda in campo "+s.getPersonaggios().get(scelta).getNomePersonaggio());
    return s.getPersonaggios().get(scelta);
}

public void Messaggi(String messaggi){
    switch(messaggi){
        case "inizio":
        System.out.println("La partita è iniziata");
        break;
        case "ko":
        System.out.println("pokemon ko");
        default: System.out.println("Cicerone gay");
    }
}

public void ResoConto(Partita p){
    System.out.println(p.getT().getP1().getNomePersonaggio()+" di "+p.getPlayer1().getNome()+" ha "+p.getT().getP1().getpS()+" ps ");
    System.out.println(p.getT().getP2().getNomePersonaggio()+" di "+p.getPlayer2().getNome()+" ha "+p.getT().getP2().getpS()+" ps ");
}

public String SelezionaMossa(Personaggio p) throws IOException{
    System.out.println("Scegli la mossa da utilizzare");
    int i=1;
    for (Mossa m : p.getMossas()){
        System.out.println(i+") "+m.getNomeMossa()+"  DANNO:"+m.getDanno()+"  PP:"+m.getPp());
        i++;
    }
    Boolean mossaScelta = false;
    int Mossa1 = 0;
    while(!mossaScelta){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Mossa1 = Integer.parseInt(s);
    if(p.getMossas().get(Mossa1-1).getPp()== 0){
        System.out.println("Questa mossa ha esaurito i PP");
    }
    else mossaScelta = true;
}
return p.getMossas().get(Mossa1-1).getNomeMossa();
}






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
public int PersonaggioStrumento(ArrayList <Personaggio> p) throws IOException{
    int i=1;
for(Personaggio per:p){
if(per!=null)System.out.println(i+" "+per.getNomePersonaggio()+" PS: "+per.getpS());
i++;
}
int scelta;
do{
    System.out.println("Scegli su chi utilizzare lo strumento");
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
