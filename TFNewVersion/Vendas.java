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
public class Vendas {
    private List<Venda> vendas = new ArrayList<Venda>();

    public Vendas(List vendas) {
        this.vendas = vendas;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    @Override
    public String toString() {
        return "Vendas{" + "vendas=" + vendas + '}';
    }
    
    
}
