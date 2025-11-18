/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthurzimmer
 */
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
                throw new IllegalArgumentException("Código de usuário repetido, tente novamente.");

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
    
    public Fornecedor buscarFornecedorPorNome(String nome){
        System.out.println("[DEBUG] Esse array de fornecedor tem " + fornecedores.size() + " fornecedores");
        System.out.println("[DEBUG] Nome recebido por parâmetro: " + nome);
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println("[DEBUG] Comparando parâmetro com o nome '" + nome + "'");
            if (fornecedor.getNome().equals(nome)) {
                return fornecedor;
            }
        }
        return null;
    }

    public int size() {
        return fornecedores.size();
    }

    public Fornecedor getFirst() {
        return fornecedores.get(0);
    }
    
    public Fornecedor getFornecedor(int i) {
        return fornecedores.get(i);
    }
}
