package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/14/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class AdvAdapter extends ArrayAdapter<String> {

    AdvAdapter(Context context, String[] foods) {
        super(context, R.layout.see_row ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.see_row, parent, false);

        String singleFoodItem = getItem(position);
        String[] a = singleFoodItem.split(",");
        String topic = a[0];
        System.out.println(topic);
        String description = a[1];
        System.out.println(a[1]);
        TextView topicText = (TextView) customView.findViewById(R.id.topicText);
        TextView desText = (TextView) customView.findViewById(R.id.desText);

        topicText.setText(topic);
        desText.setText(description);
        return customView;
    }
}