package com.kursaha;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.kursaha.common.ChatMessage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class ChatAdapter extends ArrayAdapter<com.kursaha.common.ChatMessage> {
    private List<com.kursaha.common.ChatMessage> chatMessages;
    private Context context;

    public ChatAdapter(Context context, List<com.kursaha.common.ChatMessage> chatMessages) {
        super(context, 0, chatMessages);
        this.context = context;
        this.chatMessages = chatMessages;
    }

    @SuppressLint("NewApi")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage message = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chat_message_item, parent, false);
        }

        TextView textView1 = convertView.findViewById(R.id.textView1);
        TextView textView2 = convertView.findViewById(R.id.textView2);

        TextView dateView = convertView.findViewById(R.id.dateView);

        TextView timeView1 = convertView.findViewById(R.id.timeView1);
        TextView timeView2 = convertView.findViewById(R.id.timeView2);

        String time = message.getDateTime().getHour() + ":" + message.getDateTime().getMinute();

        if(message.getIsSender()) {
            textView1.setText(message.getMessage());
            timeView1.setText(time);
            textView2.setVisibility(View.GONE);
            timeView2.setVisibility(View.GONE);
        } else if(!message.getIsSender()) {
            textView2.setText(message.getMessage());
            timeView2.setText(time);
            textView1.setVisibility(View.GONE);
            timeView1.setVisibility(View.GONE);
        }

        if(message.getDateTime().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59)))) {
            dateView.setText(LocalDate.now().getDayOfMonth() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getYear());
        } else {
            convertView.findViewById(R.id.dateView).setVisibility(View.GONE);
        }

        return convertView;
    }
}
