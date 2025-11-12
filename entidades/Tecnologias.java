package entidades;

import java.util.ArrayList;
import java.util.List;

public class Tecnologias {
    private List<Tecnologia> tecnologias = new ArrayList<>();

    public Tecnologias(List tecnologias) {
        this.tecnologias = tecnologias;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public boolean addTecnologia (Tecnologia t) {
        for(int i = 0; i < tecnologias.size(); i++){
            Tecnologia tec = tecnologias.get(i);

            // verifica duplicidade de ID
            if (tec.getId() == t.getId())
                throw new IllegalStateException("Código de usuário repetido, tente novamente.");

            // insere já ordenado
            if (t.getId() < tec.getId()) {
                tecnologias.add(i, t);
                return true;
            }
        }

        tecnologias.add(t);
        return true;
    }

    public int size(){
        return tecnologias.size();
    }

    @Override
    public String toString() {
        return "Tecnologias{" + "tecnologias=" + tecnologias + '}';
    }
}
