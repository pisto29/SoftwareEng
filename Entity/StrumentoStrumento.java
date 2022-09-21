package Entity;

public class StrumentoStrumento implements EsecuzioneTurno{
public void esecuzione(Turno t){
t.utilizzaStrumento("g1");
t.utilizzaStrumento("g2");
String primo;
String secondo;
if( t.checkVelocità()) {primo="g1";secondo="g2";}
else {primo="g2";secondo="g1";}
t.EseguiAbilità(primo);
t.EseguiAbilità(secondo);
t.setFase(Fase.Fine_Turno);
if(!t.checkKo(primo)){t.EseguiAbilità(primo);}
if(!t.checkKo(secondo)){t.EseguiAbilità(secondo);}

}
 
}
