package com.kursaha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kursaha.common.ChatMessage;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<com.kursaha.common.ChatMessage> {
    private List<com.kursaha.common.ChatMessage> chatMessages;
    private Context context;

    public ChatAdapter(Context context, List<com.kursaha.common.ChatMessage> chatMessages) {
        super(context, 0, chatMessages);
        this.context = context;
        this.chatMessages = chatMessages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chat_message_item, parent, false);
        }

        TextView messageText = convertView.findViewById(R.id.messageText);
        messageText.setText(message.getMessage());

        return convertView;
    }
}
