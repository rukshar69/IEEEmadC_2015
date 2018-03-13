package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Hashtable;

public class TutorialActivity extends AppCompatActivity {
    TutorialDatabaseHandler handler = new TutorialDatabaseHandler(this);
    Hashtable<String,String> urlList ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        final ListView tutorialList = (ListView) findViewById( R.id.pdfListView);
        final ArrayList<String> planetList = handler.getList();
        System.out.println(planetList);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, planetList);
        tutorialList.setAdapter( listAdapter );
        urlList = handler.getHashTable();

        tutorialList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> arg0, View arg1,int arg2, long arg3)
            {
                String str = ((TextView) arg1).getText().toString();
                String url = urlList.get(str);
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });

    }

    public void addTutorial(View view){
        if(view.getId()==R.id.addPdfButton){
            EditText url = (EditText)findViewById(R.id.urlText);
            EditText tutorialName = (EditText)findViewById(R.id.tutorialNameText);
            String urlString = url.getText().toString();
            if(urlString.contains("http://")==false)urlString="http://"+urlString;
            urlString=urlString+"/";
            handler.insert(tutorialName.getText().toString(),urlString);
        }
    }

}
