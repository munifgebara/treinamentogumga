package br.com.gumga.ceprojogo.entidades.app;

import br.com.gumga.ceprojogo.entidades.Direcao;
import br.com.gumga.ceprojogo.entidades.Mundo;
import br.com.gumga.ceprojogo.entidades.Personagem;
import br.com.gumga.ceprojogo.entidades.Policia;
import br.com.gumga.ceprojogo.services.ServicoWeb;
import javax.swing.JOptionPane;

public class Programa {

    public static Personagem personagem;

    public static void main(String[] args) {
        personagem = new Policia("Soldado", "Fulano", 100, Mundo.getInstancia().lugarInicial());
        
        ServicoWeb.initServer();
        
        while (true) {
            try {
                String acao = JOptionPane.showInputDialog(personagem.descreve());
                if (acao == null) {
                    System.exit(0);
                }
                acao = acao.trim().toLowerCase();
                switch (acao) {
                    case "norte":
                    case "n":
                        personagem.anda(Direcao.NORTE);
                        break;
                    case "sul":
                    case "s":
                        personagem.anda(Direcao.SUL);
                        break;
                    case "leste":
                    case "l":
                        personagem.anda(Direcao.LESTE);
                        break;
                    case "oeste":
                    case "o":
                        personagem.anda(Direcao.OESTE);
                        break;
                    default:
                        throw new RuntimeException("Não entendi " + acao);

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
