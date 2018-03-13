package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class QuizActivity extends AppCompatActivity {
    QuizDatabaseHelper quizDatabaseHelper = new QuizDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final ListView quizList = (ListView) findViewById( R.id.quizView );
        ArrayList<String> planetList = quizDatabaseHelper.getList();
        System.out.println(planetList);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);
        quizList.setAdapter( listAdapter );

        quizList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                Intent intent = new Intent(QuizActivity.this,QuestionActivity.class);
                intent.putExtra("question", str);
                System.out.println(str);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }




}
