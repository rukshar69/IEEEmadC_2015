package com.example.dipto.ieeemadc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by rukshar on 5/22/2016.
 */
class ChatAdapter extends ArrayAdapter<String> {

    ChatAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_chat ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom_chat, parent, false);

        String singleFoodItem = getItem(position);
        String[] a = singleFoodItem.split("\\$");
        String topic = a[0];
        System.out.println("popo"+topic);
        String description = a[1];
        System.out.println(a[1]);
        TextView topicText = (TextView) customView.findViewById(R.id.userText);
        TextView desText = (TextView) customView.findViewById(R.id.messageText);

        topicText.setText(topic);
        desText.setText(description);
        return customView;
    }
}