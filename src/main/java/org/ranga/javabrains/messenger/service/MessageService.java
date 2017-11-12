package org.ranga.javabrains.messenger.service;

import org.ranga.javabrains.messenger.database.DatabaseClass;
import org.ranga.javabrains.messenger.exceptions.DataNotFoundException;
import org.ranga.javabrains.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ws.rs.QueryParam;

public class MessageService {

    Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "Hello World!", "Ranga"));
        messages.put(2L, new Message(2L, "Hello Jersey!", "Ranga"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(long id) {
        Message message = messages.get(id);
        if(message == null) {
            throw new DataNotFoundException("Message with id " + id + " not found.");
        }
        return message;
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for(Message message : messages.values()) {
            calendar.setTime(calendar.getTime());
            if(calendar.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        List<Message> messagesForPaginated = new ArrayList<>(messages.values());
        if(start + size > messagesForPaginated.size()) {
            return new ArrayList<>();
        }
        return messagesForPaginated.subList(start, size + start);

    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        message.setModified(new Date());
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if(message.getId() <= 0) {
            return null;
        }
        message.setModified(new Date());
        messages.put(message.getId(), message);
        return messages.get(message.getId());
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
