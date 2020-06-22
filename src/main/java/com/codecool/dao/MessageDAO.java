package com.codecool.dao;

import com.codecool.model.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {
    List<Message> messages;

    public MessageDAO() {

    }

    public List<Message> getMessages() throws Exception {
        messages = new ArrayList<>();
        ConnectorDB connectorDB = new ConnectorDB();
        Connection connection =connectorDB.getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.messages");
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String authorName = rs.getString("author_name");
                Timestamp creationDate = rs.getTimestamp("creation_date");

                String format = "|%1$-3s|%2$-15s|%3$-30s|%4$-8s|%5$-8s|\n";
                System.out.printf(format, id, title, content, authorName, creationDate);

                Message message = new Message();
                message.setId(id)
                        .setTitle(title)
                        .setContent(content)
                        .setAuthorName(authorName)
                        .setCreationDate(creationDate);

                messages.add(message);
            }
            rs.close();
            st.close();
            connection.close();

            return messages;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new Exception("Data not found");
    }
}
