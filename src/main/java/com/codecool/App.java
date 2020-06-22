package com.codecool;


import com.codecool.dao.ConnectorDB;
import com.codecool.dao.MessageDAO;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App {
    public static void main( String[] args ) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/messages", new MessageHandler());
        server.createContext("/welcomepage", new WelcomePageHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server sucessfully started on port 8000");

        MessageDAO messageDAO = new MessageDAO();
        messageDAO.getMessages();
    }
}
