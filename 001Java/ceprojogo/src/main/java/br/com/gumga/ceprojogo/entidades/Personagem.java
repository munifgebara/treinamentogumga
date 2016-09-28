/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.ceprojogo.entidades;

/**
 *
 * @author munif
 */
public class Personagem {
    
    protected String nome;
    protected Integer energia;
    protected Lugar lugar;

    public Personagem(String nome, Integer energia, Lugar lugar) {
        this.nome = nome;
        this.energia = energia;
        this.lugar = lugar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }
    
    
    
    
}
