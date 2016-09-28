package br.com.gumga.ceprojogo.entidades;

public enum Direcao {

    NORTE("Norte"),
    SUL("Sul"),
    LESTE("Leste"),
    OESTE("Oeste"),
    CIMA("Para cima"),
    BAIXO("Para baixo");
    
    private String descricao;
    
    Direcao(String s){
        descricao=s;
    }
    
    public String toString(){
        return descricao;
    }
   
    
    
    
}
