package br.com.gumga.ceprojogo.entidades;

/**
 * Esta classe é da Polícia
 * @author munif
 */
public class Policia extends Personagem {
    
    private String patente;

    public Policia(String patente, String nome, Integer energia, Lugar lugar) {
        super(nome, energia, lugar);
        this.patente = patente;
    }

    @Override
    public String toString() {
        return patente+" "+nome;
    }

    
    
}
