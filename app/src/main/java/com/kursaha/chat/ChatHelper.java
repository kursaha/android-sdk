package com.kursaha.chat;

import android.util.Log;

import com.kursaha.common.ChatMessage;
import com.kursaha.Kursaha;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

public class ChatHelper implements Callable<String> {
    private static final String TAG = "ChatHelper";
    private UUID chatIdentifier;
    private String requestMessage;
    private List<ChatMessage> chatMessageList;

    public ChatHelper(UUID chatIdentifier, String requestMessage, List<ChatMessage> chatMessageList) {
        this.chatIdentifier = chatIdentifier;
        this.requestMessage = requestMessage;
        this.chatMessageList = chatMessageList;
    }

    @Override
    public String call() {
        return getResponse(chatIdentifier, requestMessage, chatMessageList);
    }

    private String getResponse(UUID chatIdentifier, String request, List<ChatMessage> chatMessages) {
        try {
            Log.d(TAG, "sending message request to chat support : " + request);
            return Kursaha.chatResponse(chatIdentifier, request, chatMessages);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
