package com.kursaha;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.kursaha.common.Callback;
import com.kursaha.common.ChatMessage;
import com.kursaha.sdk.KursahaActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class ChatActivity extends KursahaActivity {
    private static final String TAG = "ChatActivity";
    private static final UUID CHAT_IDENTIFIER = UUID.fromString("<Chat-Identifier>");
    private List<com.kursaha.common.ChatMessage> chatMessages;
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

                    ChatMessage message = new ChatMessage(messageText, "sender", true, Calendar.getInstance().getTime()); // You can specify the sender
                    chatMessages.add(message);
                    chatAdapter.notifyDataSetChanged();
                    messageEditText.setText(""); // Clear the input field

                    Kursaha.chatResponseAsync(CHAT_IDENTIFIER, messageText, chatMessages, new Callback<String>() {
                        @Override
                        public void onFailure() {
                            Log.e(TAG, "Failed to get chat response");
                        }
                        @Override
                        public void onSuccess(String result) {
                            chatMessages.add(new ChatMessage(result, "Customer Success Representative", false, Calendar.getInstance().getTime()));
                            chatAdapter.notifyDataSetChanged();
                            Log.d(TAG, "Result of the message: " + result);
                        }
                    });
                }
            }
        });
    }
}
