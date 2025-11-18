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
public class Comprador {
    private String pais;
    private String email;
    private long cod;
    private String nome;
        
    public Comprador(long cod, String nome, String pais, String email) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public String getPais() {
        return pais;
    }

    public long getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPais(String Pais) {
        this.pais = pais;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nID: " + cod + "; \nNome: " + nome + "; \nEmail: " + email + "; \nPaís: " + pais;
    }
}
