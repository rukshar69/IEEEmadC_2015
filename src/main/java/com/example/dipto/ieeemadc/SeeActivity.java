package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SeeActivity extends AppCompatActivity {
    AdvDBHandler handler = new AdvDBHandler(this,null,null,4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see);
        //delete previous list
        String[] foods = handler.databaseToString().split("\n");
        System.out.println(foods[0]);
        //dbHandler.deleteAll(foods);

        //add current list

        // String[] foods = {"runtime","dynamic","greedy","np","backtrack","divide"};

        //list for new list
         //foods = dbHandler.databaseToString().split(" ");

        final SeeActivity mainActivity = this;
        //mainActivity = this;
        ListAdapter buckysAdapter = new AdvAdapter(this, foods);
        ListView buckysListView = (ListView) findViewById(R.id.buckysListView);
        buckysListView.setAdapter(buckysAdapter);

        buckysListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String food = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(SeeActivity.this, food, Toast.LENGTH_LONG).show();
                    }
                }
        );



        //printDatabase();

}

    public void onBack(View view)
    {
        Intent i = new Intent(this, AdvActivity.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
