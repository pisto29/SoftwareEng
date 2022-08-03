package Entity;

import java.util.HashMap;

public class Tipo {
    private String nomeTipo;
    private HashMap<String, Float> efficacia;

    public Tipo(String nomeTipo, HashMap<String, Float> efficacia) {
        this.nomeTipo = nomeTipo;
        this.efficacia = efficacia;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public float getEfficacia(String t){
        return efficacia.get(t);
    }

    public void setEfficacia(HashMap<String, Float> efficacia) {
        this.efficacia = efficacia;
    }

    
    
}
