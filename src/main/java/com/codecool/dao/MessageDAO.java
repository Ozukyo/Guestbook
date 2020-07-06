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
        Connection connection = connectorDB.getConnection();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM public.messages ORDER BY creation_date");
            while(rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");
                String authorName = rs.getString("author_name");
                String creationDate = rs.getString("creation_date");

                String format = "|%1$-3s|%2$-15s|%3$-30s|%4$-8s|%5$-8s|\n";
                System.out.printf(format, id, title, content, authorName, creationDate);

                Message message = new Message();
                message.setId(id)
                        .setTitle(title)
                        .setContent(content)
                        .setAuthorName(authorName)
                        .setCreationDate(); // TODO: insert argument into setter later

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

    public void setMessage(Message message) throws ClassNotFoundException {
        ConnectorDB connectorDB = new ConnectorDB();
        Connection connection = connectorDB.getConnection();
//        System.out.println(message.getCreationDate());
//        message.convertStringToTimestamp();
//        System.out.println(message.getConvertedDate());
        message.setCreationDate();

        try {

            PreparedStatement ps = null;
            ps = connection.prepareStatement("INSERT INTO public.messages (title, content, author_name, creation_date)" +
                    "VALUES (?, ?, ?, ?)");

            ps.setString(1, message.getTitle());
            ps.setString(2, message.getContent());
            ps.setString(3, message.getAuthorName());
            ps.setString(4, message.getCreationDate());
            ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
