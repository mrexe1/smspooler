package org.telegram.messenger;

/**
 * Created by sachinsr on 14/07/16.
 */
public class Message {

    private Integer message_id;
    private Chat chat;
    private Integer date;
    private String text;

    public Integer messageId() {
        return message_id;
    }

    public Integer date() {
        return date;
    }

    public Chat chat() {
        return chat;
    }

    public String text() {
        return text;
    }

    @Override
    public int hashCode() {
        return message_id != null ? message_id.hashCode() : 0;
    }
}