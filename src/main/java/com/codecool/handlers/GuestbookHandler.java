package com.codecool.handlers;

import com.codecool.dao.MessageDAO;
import com.codecool.model.Message;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GuestbookHandler implements HttpHandler {
    private MessageDAO messageDao;

    public GuestbookHandler(){
        messageDao = new MessageDAO();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        String response = "";
        String method = exchange.getRequestMethod(); // albo "POST" albo "GET"

        if(method.equals("POST")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            Map <String, String> data = parseFormData(br.readLine());

            Message message = new Message();
            message.setTitle(data.get("title"))
                    .setAuthorName(data.get("author"))
//                    TODO: insert argument into setcreationdate later
                    .setCreationDate()
                    .setContent(data.get("content"));

            System.out.println(message.toString());
            try {
                messageDao.setMessage(message);

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            response = "data saved";
        }


        exchange.sendResponseHeaders(200, response.length());
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private static Map<String, String> parseFormData(String formData) throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");
        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            // We have to decode the value because it's urlencoded. see: https://en.wikipedia.org/wiki/POST_(HTTP)#Use_for_submitting_web_forms
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }
}
