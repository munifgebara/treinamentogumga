package br.com.gumga.ceprojogo.entidades.app;

import br.com.gumga.ceprojogo.entidades.Direcao;
import br.com.gumga.ceprojogo.entidades.Lugar;
import br.com.gumga.ceprojogo.entidades.Mundo;
import br.com.gumga.ceprojogo.entidades.Policia;
import javax.swing.JOptionPane;

public class Programa {

    public static void main(String[] args) {
        Policia policia = new Policia("Soldado", "Fulano", 100, Mundo.getInstancia().lugarInicial());
        while (true) {
            try {
                String acao = JOptionPane.showInputDialog(policia.descreve());
                if (acao == null) {
                    System.exit(0);
                }
                acao = acao.trim().toLowerCase();
                switch (acao) {
                    case "norte":
                    case "n":
                        policia.anda(Direcao.NORTE);
                        break;
                    case "sul":
                    case "s":
                        policia.anda(Direcao.SUL);
                        break;
                    case "leste":
                    case "l":
                        policia.anda(Direcao.LESTE);
                        break;
                    case "oeste":
                    case "o":
                        policia.anda(Direcao.OESTE);
                        break;
                    default:
                        throw new RuntimeException("Não entendi " + acao);

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),"Aviso",JOptionPane.ERROR_MESSAGE);
            }

        }

    }

}
