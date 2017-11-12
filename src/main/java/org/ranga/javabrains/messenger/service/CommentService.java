package org.ranga.javabrains.messenger.service;

import org.ranga.javabrains.messenger.database.DatabaseClass;
import org.ranga.javabrains.messenger.model.Comment;
import org.ranga.javabrains.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CommentService {

    Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId, Comment comment) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        if(comment.getId() <= 0) {
            return null;
        }
        comment.setModified(new Date());
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Message message = messages.get(messageId);
        Map<Long, Comment> comments = message.getComments();
        return comments.remove(commentId);
    }
}
