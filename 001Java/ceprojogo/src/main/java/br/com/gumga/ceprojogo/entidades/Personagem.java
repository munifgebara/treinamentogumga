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
        lugar.getPersonagens().add(this);
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

    public void anda(Direcao direcao) {
        if (!lugar.getVizinhos().containsKey(direcao)) {
            throw new RuntimeException("Não é possível ir para " + direcao);
        }
        lugar.getPersonagens().remove(this);
        lugar = lugar.getVizinhos().get(direcao);
        lugar.getPersonagens().add(this);
    }

    public String descreve() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("Ola " + this + "!\n");
        toReturn.append(lugar);
        return toReturn.toString();
    }

    @Override
    public String toString() {
        return "Personagem{" + "nome=" + nome + ", energia=" + energia + ", lugar=" + lugar + '}';
    }


}
