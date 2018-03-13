package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SeeProfileActivity extends AppCompatActivity {

    String get;
    ContactDatabaseHelper contactDatabaseHelper = new ContactDatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_profile);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        get = bundle.getString("fromProfile");

        String  query = contactDatabaseHelper.makeQuery(get);
        String foods[] = query.split("\n");

        final SeeProfileActivity mainActivity = this;
        //mainActivity = this;
        ListAdapter buckysAdapter = new ProfileAdapter(this, foods);
        ListView buckysListView = (ListView) findViewById(R.id.profileList);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(SeeProfileActivity.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );


    }
}
