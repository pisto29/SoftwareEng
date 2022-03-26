package Entity;

public interface RuoloState {
    public void Attacca(Personaggio P1, Mossa mossa);
    public void Sostituzione();
    public int Difendi(Personaggio P1,int danno, Tipo tipo, Tipologia tipologia);
}
