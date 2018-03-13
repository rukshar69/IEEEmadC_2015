package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;

public class QuestionActivity extends AppCompatActivity {
    private QuestionDatabaseHelper questionDatabaseHelper;
    private Hashtable<String,String> questionAnswer;
    private ArrayList<String> questions;
    private String current;
    private int Score = 0;
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Intent i = getIntent();
        String databaseName=i.getStringExtra("question");
        System.out.println(databaseName);
        questionDatabaseHelper=new QuestionDatabaseHelper(this,databaseName);
        questionAnswer=questionDatabaseHelper.getList();
        questions= Collections.list(questionAnswer.keys());
        System.out.println(questionAnswer);
        show();

    }

    public void show(){
        TextView questionView = (TextView) findViewById(R.id.questionViewId);
        if(index<10) {
            current=questions.get(index);
            questionView.setText(current);
            index++;

        }
        else{
            questionView.setText("Your score is "+Score+" out of 10!");
        }
    }

    public void onNext(View view){
        if(view.getId()==R.id.nextButton){
            EditText answer = (EditText)findViewById(R.id.answerId);
            String check = (String)answer.getText().toString();
            if(check.equals(questionAnswer.get(current)))Score++;
            show();
        }
    }


}
