package Entity;

import java.util.ArrayList;

public interface AbilitàImplementator {
    public void ApplicaEffetto(Personaggio utilizzatore, Personaggio bersaglio,ArrayList<Effetto> effetti_self, ArrayList<Effetto> effetti);
}
