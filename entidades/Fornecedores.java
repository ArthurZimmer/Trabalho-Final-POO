package entidades;

import java.util.ArrayList;
import java.util.List;

public class Fornecedores {
    private List<Fornecedor> fornecedores = new ArrayList<>();

    public Fornecedores(List fornecedores) {
        this.fornecedores = fornecedores;
    }

    public List getFornecedores() {
        return this.fornecedores;
    }

    public void setFornecedores(List fornecedores) {
        this.fornecedores = fornecedores;
    }

    public boolean addFornecedor(Fornecedor f){
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor forn = fornecedores.get(i);

            // verifica duplicidade de ID
            if (forn.getCod() == f.getCod())
                throw new IllegalStateException("Código de usuário repetido, tente novamente.");

            // insere já ordenado
            if (f.getCod() < forn.getCod()) {
                fornecedores.add(i, f);
                return true;
            }
        }

        // se está aqui e nao retornou true, lista vazia. add.
        fornecedores.add(f);
        return true;
    }

    public Fornecedor buscarFornecedorPorCodigo(int codFornecedor){
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getCod() == codFornecedor) {
                return fornecedor;
            }
        }
        return null;
    }
}
