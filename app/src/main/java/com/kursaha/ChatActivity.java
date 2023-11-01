package com.kursaha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.kursaha.sdk.KursahaActivity;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends KursahaActivity {
    private List<ChatMessage> chatMessages;
    private ChatAdapter chatAdapter;
    private EditText messageEditText;

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

                    // Here, you can also send the message to the receiver or perform any necessary actions.
                }
            }
        });
    }
}
