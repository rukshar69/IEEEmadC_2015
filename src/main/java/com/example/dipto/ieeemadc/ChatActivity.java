package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

public class ChatActivity extends AppCompatActivity {

    String get;
    ChatDB chatDB = new ChatDB(this, null);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        get = bundle.getString("fromMenu");

        String messages = chatDB.databaseToString();

        String list[] = messages.split("\n");

        if(!list[0].equals("")) {
            final ChatActivity mainActivity = this;
            //mainActivity = this;
            ListAdapter buckysAdapter = new ChatAdapter(this, list);
            ListView buckysListView = (ListView) findViewById(R.id.chatList);
            buckysListView.setAdapter(buckysAdapter);

            buckysListView.setOnItemClickListener(
                    new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String food = String.valueOf(parent.getItemAtPosition(position));
                            Toast.makeText(ChatActivity.this, food, Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }
    }

    public void onPost(View view)
    {
        EditText sentence = (EditText) findViewById(R.id.sentence) ;
        chatDB.addProduct(new Chat(get, sentence.getText().toString()));
    }
}
