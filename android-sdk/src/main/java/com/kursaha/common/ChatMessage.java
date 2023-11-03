package com.kursaha.common;

import java.util.Date;

public class ChatMessage {
    private final String message;
    private final String sender;
    private final boolean isSender;
    private final Date dateTime;

    public ChatMessage(String message, String sender, boolean isSender, Date dateTime) {
        this.message = message;
        this.sender = sender;
        this.isSender = isSender;
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }

    public boolean getIsSender() {
        return isSender;
    }

    public Date getDateTime() {
        return dateTime;
    }
}
