/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author arthurzimmer
 */
public class Tecnologia {
    private long id;
    private String modelo;
    private String descricao;
    private double valorBase;
    private double peso;
    private double temperatura;
    private Fornecedor fornecedor;
    private boolean foiVendida;
    
    public Tecnologia(long id, String modelo, String descricao, double valorBase, double peso, double temperatura, Fornecedor fornecedor) {
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.peso = peso;
        this.temperatura = temperatura;
        this.fornecedor = fornecedor;
        this.foiVendida = false;
    }

    public long getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double getPeso() {
        return peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "\nID: " + id + "; \nModelo: " + modelo + "; \nDescrição: " + descricao + "; \nValor base: " + valorBase + "; \nPeso: " + peso + "; \nTemperatura: " + temperatura + "; \nFornecedor: " + fornecedor;
    }
}
