/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.ceprojogo.entidades;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author munif
 */
public class Lugar {

    private String nome;
    private String descricao;
    private Map<Direcao, Lugar> vizinhos;
    private Set<Personagem> personagens;

    public Lugar(String nome) {
        this.nome = nome;
        vizinhos = new HashMap<>();
        personagens = new HashSet<>();
    }

    public Map<Direcao, Lugar> getVizinhos() {
        return vizinhos;
    }

    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append("Você esta no(a)" + nome + "\n");
        toReturn.append("Personagens que estão aqui:"+personagens+"\n");
        toReturn.append("Você pode ir para:\n");
        for (Direcao direcao : vizinhos.keySet()) {
            toReturn.append(direcao + ":" + vizinhos.get(direcao).nome + "\n");
        }
        return toReturn.toString();
    }

    public Set<Personagem> getPersonagens() {
        return personagens;
    }

}
