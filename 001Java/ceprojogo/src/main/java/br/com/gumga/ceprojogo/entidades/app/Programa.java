package br.com.gumga.ceprojogo.entidades.app;

import br.com.gumga.ceprojogo.entidades.Direcao;
import br.com.gumga.ceprojogo.entidades.Lugar;
import br.com.gumga.ceprojogo.entidades.Mundo;
import br.com.gumga.ceprojogo.entidades.Policia;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Programa {

    public static void initServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/", new DescreveLugar());
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (IOException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Policia policia;

    public static void main(String[] args) {
        policia = new Policia("Soldado", "Fulano", 100, Mundo.getInstancia().lugarInicial());
        initServer();
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
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public static class DescreveLugar implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            String response = policia.descreve();
            he.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

    }

}
