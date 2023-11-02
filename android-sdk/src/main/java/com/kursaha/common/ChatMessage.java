package com.kursaha.common;

import java.time.LocalDateTime;

public class ChatMessage {
    private final String message;
    private final String sender;
    private final boolean isSender;
    private final LocalDateTime dateTime;

    public ChatMessage(String message, String sender, boolean isSender, LocalDateTime dateTime) {
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
