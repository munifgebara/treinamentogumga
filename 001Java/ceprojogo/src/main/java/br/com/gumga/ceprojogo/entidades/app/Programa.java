package br.com.gumga.ceprojogo.entidades.app;

import br.com.gumga.ceprojogo.entidades.Direcao;
import br.com.gumga.ceprojogo.entidades.Lugar;
import br.com.gumga.ceprojogo.entidades.Mundo;
import br.com.gumga.ceprojogo.entidades.Policia;

public class Programa {
    
    
    public static void main(String[] args){
        Policia policia=new Policia("Soldado", "Fulano", 100, Mundo.getInstancia().lugarInicial());
        
        System.out.println (descreve(policia));
    }

    private static String descreve(Policia policia) {
        StringBuilder toReturn=new StringBuilder();
        toReturn.append("Ola "+policia+"!\n");
        Lugar lugarAtual=policia.getLugar();
        toReturn.append("Você esta no(a)"+lugarAtual+"\n");
        toReturn.append("Você pode ir para:");
        for (Direcao direcao:lugarAtual.getVizinhos().keySet()){
            toReturn.append(direcao+":"+lugarAtual.getVizinhos().get(direcao)+"\n");
        }
        return toReturn.toString();
    }
    
}
