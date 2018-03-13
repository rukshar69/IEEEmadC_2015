package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AdvActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv);
    }



    public void onPost(View view)
    {
        Intent i = new Intent(this, PostActivity.class);
        startActivity(i);
    }

    public void onSee(View view)
    {
        Intent i = new Intent(this, SeeActivity.class);
        startActivity(i);
    }
}
