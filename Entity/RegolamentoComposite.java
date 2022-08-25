package Entity;

import java.util.ArrayList;

public class RegolamentoComposite implements RegolamentoComponent {
    private String id;
    private ArrayList <RegolamentoComponent> regole;
    private String[] idRegole;
    @Override
    public boolean VerificaRegolamento(Squadra s) {
       boolean check=true;
       for(RegolamentoComponent r: regole)
       check=r.VerificaRegolamento(s);
       return check;
    }

    public void Add(RegolamentoComponent e) {
        // TODO Auto-generated method stub
        this.regole.add(e);
    }

    public RegolamentoComponent getChild(int a) {
        // TODO Auto-generated method stub
        return this.regole.get(a);
    }
}
