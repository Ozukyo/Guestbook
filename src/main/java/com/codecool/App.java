package com.codecool;


import com.codecool.dao.ConnectorDB;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class App
{
    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/messages", new MessageHandler());
        server.setExecutor(null);
        server.start();

        System.out.println("Server sucessfully started on port 8000");

        ConnectorDB connectorDB = new ConnectorDB();
    }
}
