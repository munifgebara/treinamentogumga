/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gumga.ceprojogo.services;

import br.com.gumga.ceprojogo.entidades.Bandido;
import br.com.gumga.ceprojogo.entidades.Direcao;
import br.com.gumga.ceprojogo.entidades.Mundo;
import br.com.gumga.ceprojogo.entidades.Personagem;
import br.com.gumga.ceprojogo.entidades.app.Programa;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marlon
 */
public class ServicoWeb {

    public static void initServer() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/", new DescreveLugar());
            server.createContext("/novo", new NovoPersonagem());
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (IOException ex) {
            Logger.getLogger(ServicoWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class NovoPersonagem implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            String token = "" + System.currentTimeMillis();
            String nome = he.getRequestURI().toString().split("-")[1];
            System.out.println("-- NOVO -->" + token + " " + nome);
            Bandido b = new Bandido("Curintia", nome, 100, Mundo.getInstancia().lugarInicial());
            Mundo.getInstancia().getPersonagens().put(token, b);
            String response = token;
            he.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    public static class DescreveLugar implements HttpHandler {

        @Override
        public void handle(HttpExchange he) throws IOException {
            System.out.println("---->" + Mundo.getInstancia().getPersonagens());
            Headers requestHeaders = he.getRequestHeaders();
            List<String> tokens = requestHeaders.get("cerproToken");
            Personagem p = null;
            if (tokens == null) {
                p = Programa.personagem;
                System.out.println("-------> SEM TOKEN");

            } else {
                for (String s : tokens) {
                    System.out.println("-------> TOKEN " + s);
                    p = Mundo.getInstancia().getPersonagens().get(s);
                }
            }
            List<String> comandos = requestHeaders.get("comando");
            if (comandos != null) {
                for (String c : comandos) {
                    System.out.println("-------> Comando " + c);
                    p.anda(Direcao.valueOf(c));

                }
            }

            System.out.println("------> EU SOU " + p);
            System.out.println(p.descreve());

            String response = p.descreve();
            he.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }    
}
