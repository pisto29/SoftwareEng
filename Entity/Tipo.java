package Entity;

import java.util.HashMap;

public class Tipo {
    private String nomeTipo;
    private HashMap<Tipo, Float> efficacia;

    public Tipo(String nomeTipo, HashMap<Tipo, Float> efficacia) {
        this.nomeTipo = nomeTipo;
        this.efficacia = efficacia;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public float getEfficacia(Tipo t){
        return efficacia.get(t);
    }

    public void setEfficacia(HashMap<Tipo, Float> efficacia) {
        this.efficacia = efficacia;
    }

    
    
}
