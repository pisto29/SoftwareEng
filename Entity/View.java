package Entity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class View {
public void CompletaTorneo(int n){
    System.out.println("Mancano ancora "+n+" partecipanti");
}
public Personaggio SceltaPersonaggioCampo(Giocatore g,Squadra s,Personaggio p) throws IOException{
    int scelta=0;
    do{
    System.out.println(g.getNome()+" scegli un Pokemon da mandare in campo");
    int i=1;
    for ( Personaggio pers : s.getPersonaggios()){
        if(pers.getpS()>0&&!pers.equals(p)){
        System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
        }
        i++;
    }BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st = br.readLine();
    scelta = Integer.parseInt(st);}
    while(!(scelta>=1&&scelta<=s.getPersonaggios().size()));
    System.out.println(g.getNome()+" manda in campo "+s.getPersonaggios().get(scelta-1).getNomePersonaggio());
    return s.getPersonaggios().get(scelta-1);
}
public HashMap<Strumento,Personaggio> ScegliStrumento(Squadra s) throws IOException{
    int scelta=0;
    do{
        System.out.println("Scegli lo strumento da utilizzare");
        int i=1;
        for(Strumento st: s.getStrumentos()){
            if(st.getUtilizzato()!=true){
        System.out.println(i+" "+st.getNomeStrumento());
        i++;
    }}
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String st = br.readLine();
    scelta = Integer.parseInt(st);
    }
    
    

    while(!(scelta>=1&&scelta<=s.getStrumentos().size()));
    
    int scelta2=0;
    do{
        System.out.println("Scegli il pokemon su cui usare lo strumento");
        int i=1;
        
        for(Personaggio p: s.getStrumentos().get(scelta-1).utilizzabile(s.getPersonaggios())){
            if(p!=null)
            System.out.println(i+" "+p.getNomePersonaggio());
            i++;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        scelta2 = Integer.parseInt(st);
    }while(!(scelta2>=1&&scelta<=s.getStrumentos().get(scelta-1).utilizzabile(s.getPersonaggios()).size()));
    HashMap<Strumento,Personaggio> map= new HashMap<>();
    map.put( s.getStrumentos().get(scelta-1),s.getPersonaggios().get(scelta2-1));
    return map;
}
public void pokemonko(String n){
    System.out.println(n+" è andato ko");
}
public void Messaggi(String messaggi){
    switch(messaggi){
        case "inizio":
        System.out.println("La partita è iniziata");
        break;
        case "ko":
        System.out.println("pokemon ko");
        break;
        case "NoSquadre":System.out.println("Non hai squadre adatte a partecipare");
        break;
        case "NoPosti":System.out.println("Posti terminati");
        break;
        case "PartecipantiInsufficienti":
        System.out.println("Il torneo non può partire non ci sono abbastanza partecipanti");
        case "TorneoStart":
        System.out.println("Iscrizioni concluse il torneo ha inizio");
        break;
        case "non giocabile":
        System.out.println("La partita non può essere giocata perchè uno dei due giocatori non ha alcuna squadra conforme");
        default: 
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

    public String CreazioneTorneo() throws IOException{
        System.out.println("Scegli il tipo di torneo:");
        System.out.println("1) Torneo all'Italiana");
        System.out.println("2) Torneo ad eliminazione diretta");
        System.out.println("3) Torneo a Squadre");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        do{
             s = br.readLine();

        }while(Integer.parseInt(s)<1 && Integer.parseInt(s)>3);

        switch(Integer.parseInt(s)){
            case 1 : 
                return "Italiana";
            case 2 :
                return "Eliminazione";
            case 3 :
                return "Squadre";
            default:
                return "Koopmeiners";


        }
    }

    public int NumeroPartecipanti() throws IOException{
        System.out.println("Inserisci il numero di Partecipanti:");
        System.out.println("4");
        System.out.println("8");
        System.out.println("16");
        System.out.println("32");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        do{
            s = br.readLine();

       }while(Integer.parseInt(s)!=4 && Integer.parseInt(s)!=8 && Integer.parseInt(s)!=16 && Integer.parseInt(s)!=32);

       return Integer.parseInt(s);

    }

    public boolean AccessibilitàTorneo() throws IOException{
        
        System.out.println("1) Torneo Pubblico");
        System.out.println("2) Torneo Privato");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        do{
            s = br.readLine();

       }while(Integer.parseInt(s)!=1 && Integer.parseInt(s)!=2);

       if(Integer.parseInt(s)==1){
        return true;
       }
       else{
        return false;
       }

    }
public void inizioIscrizione(String a){
    System.out.println("Benvenuto "+a+" iscrizione in corso");
}

    public String SceltaRegolamento() throws IOException{
        System.out.println("Seleziona un Regolamento: ");
        ArrayList<String> results = new ArrayList<String>();

        String s = new File(".").getAbsolutePath()+"/Foundation/file/Regolamento/";

 
        File[] files = new File(s).listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null. 

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName().replaceAll(".json", ""));
            }   
        }
        int i=1;
        for(String r:results){
            System.out.println(i+" "+r);
            i++;
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;

        do{
            st = br.readLine();

       }while(Integer.parseInt(st)<1 && Integer.parseInt(st)>results.size());
       int a=Integer.parseInt(st);
       return results.get(a-1);

    }
public Integer ScegliSquadra(ArrayList<Squadra>squadre) throws IOException{
    System.out.println("Scegli quale squadra utilizzare");
    int i=1;
    for(Squadra s: squadre){
    if(s!=null)
    System.out.println(i+" "+s.getNomeSquadra());
    i++;}
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st;

        do{
            st = br.readLine();

       }while(Integer.parseInt(st)<1 && Integer.parseInt(st)>squadre.size());
       return Integer.parseInt(st)-1;

}
    public static void main(String[] args) throws IOException {
        View v = new View();
        v.SceltaRegolamento();
    }
    
}
