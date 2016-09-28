/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.ceprojogo.entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author munif
 */
public class Lugar {
    
    private String nome;
    private String descricao;
    private Map<Direcao,Lugar>  vizinhos;
    private Set<Personagem> personagens ;

    public Lugar(String nome) {
        this.nome = nome;
        vizinhos=new HashMap<>();
    }

    public Map<Direcao, Lugar> getVizinhos() {
        return vizinhos;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
