package com.codecool.handlers;

import com.codecool.dao.MessageDAO;
import com.codecool.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;

public class MessageHandler implements HttpHandler {
    private MessageDAO messageDAO;

    public MessageHandler() {
        messageDAO = new MessageDAO();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";

        try {
            List <Message> messages = messageDAO.getMessages();
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.writeValueAsString(messages);

            exchange.getResponseHeaders().put("Content type", Collections.singletonList("application/json"));
            exchange.getResponseHeaders().put("Access-Control-Allow-Origin", Collections.singletonList("*"));
            exchange.sendResponseHeaders(200, response.getBytes().length);

        } catch (Exception e) {
            exchange.sendResponseHeaders(404, response.getBytes().length);
        }
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
