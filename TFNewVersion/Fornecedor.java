/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.Date;


/**
 *
 * @author arthurzimmer
 */
public class Fornecedor {
    private Date fundacao;
    private Area area;
    private long cod;
    private String nome;
        
    public Fornecedor(long cod, String nome, Date fundacao, Area area) {
        this.cod = cod;
        this.nome = nome;
        this.fundacao = fundacao;
        this.area = area;
    }

    public Date getFundacao() {
        return fundacao;
    }

    public Area getArea() {
        return area;
    }

    public long getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  "\nData de fundação: " + fundacao + "; \nÁrea: " + area + "; \nID: " + cod + "; \nNome: " + nome;
    }
}
