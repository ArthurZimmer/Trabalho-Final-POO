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
public class Venda {
    private Comprador comprador;
    private Tecnologia tecnologia;
    private long num;
    private Date data;

    public Venda(Comprador comprador, Tecnologia tecnologia, long num, Date data) {
        this.comprador = comprador;
        this.tecnologia = tecnologia;
        this.num = num;
        this.data = data;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public long getNum() {
        return num;
    }

    public Date getData() {
        return data;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Venda{" + "comprador=" + comprador + ", tecnologia=" + tecnologia + ", num=" + num + ", data=" + data + '}';
    }
}
