package Entity;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Foundation.builder;
public class main {

    public static void main(String[] args) throws IOException {
        
        int i=1;
        int azione1;
        int azione2;
        String MossaG1=null;
        Strumento StrumentoG1=null;
        Personaggio SostituzioneG1=null;
        String MossaG2=null;
        Strumento StrumentoG2=null;
        Personaggio SostituzioneG2=null;
        View v = new View();
        Giocatore g1 = builder.CreaGiocatore("G1");
        Giocatore g2 = builder.CreaGiocatore("G2");
        Partita p = new Partita(g1, g2);
        System.out.println("il turno è"+p.getT());
        System.out.println(p.WinG1()+"qui");
        if(p.getT().getNumturno()==0){
            p.getPlayer1().getSquadra().getPersonaggios().get(0).Sostituzione();
            p.getT().setP1( p.getPlayer1().getSquadra().getPersonaggios().get(0));
            p.getPlayer2().getSquadra().getPersonaggios().get(0).Sostituzione();
            p.getT().setP2( p.getPlayer2().getSquadra().getPersonaggios().get(0));
        }
        while(!p.WinG1()&&!p.WinG2()){
            

            if(p.getT().checkKoP1()){
                System.out.println("Pokemon KO, scegli un Pokemon da mandare in campo");
                for ( Personaggio pers : p.getPlayer1().getSquadra().getPersonaggios()){
                    if(pers.getpS()>0){
                    System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
                    }
                    i++;
                }
                int Sostituzione1 = v.ScegliCambio(i-1);
                MossaG1=null;
                StrumentoG1=null;
                SostituzioneG1 = p.getPlayer1().getSquadra().getPersonaggios().get(Sostituzione1-1);
                p.CambioPerKoP1(SostituzioneG1);
            }

            if(p.getT().checkKoP2()){
                System.out.println("Pokemon KO, scegli un Pokemon da mandare in campo");
                for ( Personaggio pers : p.getPlayer2().getSquadra().getPersonaggios()){
                    if(pers.getpS()>0){
                    System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
                    }
                    i++;
                }
                int Sostituzione2 = v.ScegliCambio(i-1);
                MossaG2=null;
                StrumentoG2=null;
                SostituzioneG2 = p.getPlayer2().getSquadra().getPersonaggios().get(Sostituzione2-1);
                p.CambioPerKoP1(SostituzioneG2);
            }
            
            
            do{azione1 = v.ScegliAzione();}
            while(azione1<1 || azione1>3);
            
            i= 1;
            switch(azione1){

                case 1: 
                    
                    System.out.println("Scegli la mossa da utilizzare");

                    for (Mossa m : p.getT().getP1().getMossas()){
                        System.out.println(i+") "+m.getNomeMossa()+"  DANNO:"+m.getDanno()+"  PP:"+m.getPp());
                        i++;
                    }
                    int Mossa1 = v.ScegliMossa();
                    MossaG1 = p.getT().getP1().getMossas().get(Mossa1-1).getNomeMossa();
                    StrumentoG1 = null;
                    SostituzioneG1 = null;
                    break;
                
                case 2:
                    System.out.println("Scegli il Pokemon da mettere in campo");

                    for ( Personaggio pers : p.getPlayer1().getSquadra().getPersonaggios()){
                        if(pers.getpS()>0){
                        System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
                        }
                        i++;
                    }
                    int Sostituzione1 = v.ScegliCambio(i-1);
                    MossaG1=null;
                    StrumentoG1=null;
                    SostituzioneG1 = p.getPlayer1().getSquadra().getPersonaggios().get(Sostituzione1-1);
                    break;
                
                case 3:
                    System.out.println("Scegli lo strumento da utilizzare");

                    for (Strumento s : p.getPlayer1().getSquadra().getStrumentos()){
                        System.out.println(i+") "+s.getNomeStrumento());
                        i++;
                        }
                    int Strumento1 = v.ScegliStrumento(i-1);
                    MossaG1 = null;
                    SostituzioneG1=null;
                    StrumentoG1 = p.getPlayer1().getSquadra().getStrumentos().get(Strumento1-1);
                    break;
                    }

            
                    do{azione2= v.ScegliAzione();}
                    while(azione2<1 || azione1>3);
                    i=1;
                    switch(azione2){
        
                        case 1: 
                            
                            System.out.println("Scegli la mossa da utilizzare");
        
                            for (Mossa m : p.getT().getP2().getMossas()){
                                System.out.println(i+") "+m.getNomeMossa()+"  DANNO:"+m.getDanno()+"  PP:"+m.getPp());
                                i++;
                            }
                            int Mossa2 = v.ScegliMossa();
                            MossaG2 = p.getT().getP2().getMossas().get(Mossa2-1).getNomeMossa();
                            StrumentoG2 = null;
                            SostituzioneG2 = null;
                            break;
                        
                        case 2:
                            System.out.println("Scegli il Pokemon da mettere in campo");
        
                            for ( Personaggio pers : p.getPlayer2().getSquadra().getPersonaggios()){
                                if(pers.getpS()>0){
                                System.out.println(i+") "+pers.getNomePersonaggio()+" PS:"+pers.getpS());
                                }
                                i++;
                            }
                            int Sostituzione2 = v.ScegliCambio(i-1);
                            MossaG2=null;
                            StrumentoG2=null;
                            SostituzioneG2 = p.getPlayer2().getSquadra().getPersonaggios().get(Sostituzione2-1);
                            break;
                        
                        case 3:
                            System.out.println("Scegli lo strumento da utilizzare");
        
                            for (Strumento s : p.getPlayer2().getSquadra().getStrumentos()){
                                System.out.println(i+") "+s.getNomeStrumento());
                                i++;
                                }
                            int Strumento2 = v.ScegliStrumento(i-1);
                            MossaG2 = null;
                            SostituzioneG2=null;
                            StrumentoG2 = p.getPlayer2().getSquadra().getStrumentos().get(Strumento2-1);
                            break;
                            }

                        
                            
                        p.gioca(MossaG1, MossaG2, SostituzioneG1, SostituzioneG2, StrumentoG1, StrumentoG2);
                        
                        
                        

                    




        }

        if(p.WinG1()==true){
            System.out.println("IL GIOCATORE1 HA VINTO");
        }
        else{
            System.out.println("IL GIOCATORE2 HA VINTO");
        }

            




        }

        
    
    public int ScegliMossa(){
        int scelta;
        do{
            System.out.println("Scegli una mossa");
            Scanner scanner = new Scanner(System.in);
            scelta = scanner.nextInt();
        }
        while(scelta<1 || scelta>3);
        return scelta;


    }
    
}
