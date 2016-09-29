package br.com.gumga.ceprojogo.entidades;

public class Bandido extends Personagem{
    
    private String faccao;

    public Bandido(String faccao, String nome, Integer energia, Lugar lugar) {
        super(nome, energia, lugar);
        this.faccao = faccao;
    }

    @Override
    public String toString() {
        return nome+" "+faccao;
    }
    
    
    
}
