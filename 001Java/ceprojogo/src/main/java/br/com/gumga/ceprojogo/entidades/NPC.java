package br.com.gumga.ceprojogo.entidades;

public class NPC extends Personagem{
    
    private String inteligencia;

    public NPC(String inteligencia, String nome, Integer energia, Lugar lugar) {
        super(nome, energia, lugar);
        this.inteligencia = inteligencia;
    }
    
    
    
}
