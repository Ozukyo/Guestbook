package com.codecool;


import com.codecool.dao.MessageDAO;
import com.codecool.handlers.MessageHandler;
import com.codecool.handlers.GuestbookHandler;
import com.codecool.handlers.Static;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class App {
    public static void main( String[] args ) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/messages", new MessageHandler());
        server.createContext("/guestbook_form", new GuestbookHandler());
        server.createContext("/static", new Static());
        server.setExecutor(null);
        server.start();

        System.out.println("Server sucessfully started on port 8000");

        MessageDAO messageDAO = new MessageDAO();
        messageDAO.getMessages();
    }
}
