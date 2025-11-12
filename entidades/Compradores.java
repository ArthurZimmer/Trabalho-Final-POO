package entidades;

import java.util.ArrayList;
import java.util.List;

public class Compradores {
    private List<Comprador> compradores = new ArrayList<>();

    public Compradores(List compradores) {
        this.compradores = compradores;
    }

    public List<Comprador> getCompradores() {
        return compradores;
    }

    public void setCompradores(List<Comprador> compradores) {
        this.compradores = compradores;
    }

    public boolean addComprador(Comprador p){
        for (int i = 0; i < compradores.size(); i++) {
            Comprador comp = compradores.get(i);

            // verifica duplicidade de ID
            if (comp.getCod() == p.getCod())
                throw new IllegalStateException("Código de usuário repetido, tente novamente.");

            // insere já ordenado
            if (p.getCod() < comp.getCod()) {
                compradores.add(i, p);
                return true;
            }
        }

        // se está aqui e nao retornou true, lista vazia. add.
        compradores.add(p);
        return true;
    }

    @Override
    public String toString() {
        return "Compradores{" + "compradores=" + compradores + '}';
    }

    public int size() {
        return compradores.size();
    }


}
