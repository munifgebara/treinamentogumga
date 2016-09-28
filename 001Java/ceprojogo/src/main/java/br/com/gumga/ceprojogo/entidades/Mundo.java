package br.com.gumga.ceprojogo.entidades;

import static br.com.gumga.ceprojogo.entidades.Direcao.*;
import java.util.Random;
import java.util.Set;

public class Mundo {
    private static final Mundo instancia = new Mundo();
    private Lugar[][] lugares;
    private Random random=new Random();
    
    public Lugar lugarInicial(){
        return lugares[random.nextInt(4)][random.nextInt(4)];
    }
    

    public static Mundo getInstancia() {
        return instancia;
    }

//    public synchronized static Mundo getInstancia() {
//        if (instancia==null){
//            instancia=new Mundo();
//        }
//        return instancia;
//    }
    private Mundo() {
        criaMapa();
    }

    private void criaMapa() {
        lugares = new Lugar[][]{
            {new Lugar("garagem"), new Lugar("jardim centro"), new Lugar("jardim esquerda"), new Lugar("jardim muro")},
            {new Lugar("area de serviço"), new Lugar("sala"), new Lugar("quarto casal"), new Lugar("banheiro quarto casal")},
            {new Lugar("churraqueira"), new Lugar("copa"), new Lugar("cozinha"), new Lugar("banheiro")},
            {new Lugar("piscina"), new Lugar("sauna"), new Lugar("quadra de tenis"), new Lugar("oficina")}
        };
        adicionaVizinho(0, 0, SUL,LESTE);
        adicionaVizinho(0, 1, SUL,LESTE,OESTE);
        adicionaVizinho(0, 2, LESTE,OESTE);
        adicionaVizinho(0, 3, OESTE);
        
        adicionaVizinho(1, 0, NORTE,SUL,LESTE);
        adicionaVizinho(1, 1, NORTE,SUL,LESTE,OESTE);
        adicionaVizinho(1, 2, LESTE,OESTE);
        adicionaVizinho(1, 3, OESTE);

        adicionaVizinho(2, 0, NORTE,SUL,LESTE);
        adicionaVizinho(2, 1, NORTE,LESTE,OESTE);
        adicionaVizinho(2, 2, LESTE,OESTE);
        adicionaVizinho(2, 3, OESTE);
        
        adicionaVizinho(3, 0, NORTE,LESTE);
        adicionaVizinho(3, 1, LESTE,OESTE);
        adicionaVizinho(3, 2, LESTE,OESTE);
        adicionaVizinho(3, 3, OESTE);
    }

    private void adicionaVizinho(int linha, int coluna, Direcao... direcoes) {
        for (Direcao direcao : direcoes) {
            switch (direcao) {
                case NORTE:
                    lugares[linha][coluna].getVizinhos().put(direcao, lugares[linha - 1][coluna]);
                    break;
                case SUL:
                    lugares[linha][coluna].getVizinhos().put(direcao, lugares[linha + 1][coluna]);
                    break;
                case LESTE:
                    lugares[linha][coluna].getVizinhos().put(direcao, lugares[linha][coluna + 1]);
                    break;
                case OESTE:
                    lugares[linha][coluna].getVizinhos().put(direcao, lugares[linha][coluna - 1]);
                    break;
            }
        }
    }

}
