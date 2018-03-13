package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {
    AdvDBHandler handler= new AdvDBHandler(this,null,null,4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void onSend(View view)
    {
        EditText topicInput = (EditText) findViewById(R.id.topicInput);
        String topic =  topicInput.getText().toString();
        EditText desInput = (EditText) findViewById(R.id.desInput);
        String description =  desInput.getText().toString();
        //AdvDBHandler product = new AdvDBHandler(this, null, null, 1);
        handler.addProduct(new Advertisement(topic, description));
        Intent i = new Intent(this, AdvActivity.class);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
