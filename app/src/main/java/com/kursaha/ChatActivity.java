package com.kursaha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.kursaha.chat.ChatHelper;
import com.kursaha.sdk.KursahaActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ChatActivity extends KursahaActivity {
    private static final String TAG = "ChatActivity";
    private static final UUID CHAT_IDENTIFIER = UUID.fromString("6b9a2f9d-915d-4061-b9f3-1c8a4cbcdf55");
    private List<ChatMessage> chatMessages;
    private Future<String> chatResponse;
    private ChatAdapter chatAdapter;
    private EditText messageEditText;
    private static ExecutorService chatExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(this, chatMessages);
        ListView chatListView = findViewById(R.id.chatListView);
        chatListView.setAdapter(chatAdapter);

        messageEditText = findViewById(R.id.messageEditText);
        Button sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageEditText.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    // Create a ChatMessage object and add it to the chatMessages list
                    ChatMessage message = new ChatMessage(messageText, "sender"); // You can specify the sender
                    chatMessages.add(message);
                    chatAdapter.notifyDataSetChanged();
                    messageEditText.setText(""); // Clear the input field
                    chatResponse = chatExecutor.submit(new ChatHelper(CHAT_IDENTIFIER, messageText, chatMessages));
                }

                while(chatResponse.isDone()) {
                    try {
                        String result = chatResponse.get();
                        System.out.println("result : " + result);
                    } catch (ExecutionException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }


}