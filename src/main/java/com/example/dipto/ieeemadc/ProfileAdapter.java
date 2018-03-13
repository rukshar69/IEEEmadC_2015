package com.example.dipto.ieeemadc;

/**
 * Created by rukshar on 5/22/2016.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class ProfileAdapter extends ArrayAdapter<String> {

    ProfileAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_info ,foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater buckysInflater = LayoutInflater.from(getContext());
        View customView = buckysInflater.inflate(R.layout.custom_info, parent, false);

        String singleFoodItem = getItem(position);

        TextView infoField = (TextView) customView.findViewById(R.id.infoField);
        infoField.setText(singleFoodItem);
        return customView;
    }
}