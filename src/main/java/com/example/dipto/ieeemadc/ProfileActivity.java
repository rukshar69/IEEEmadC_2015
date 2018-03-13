package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    String get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        get = bundle.getString("fromMain");

        TextView userNameOnProfile = (TextView) findViewById(R.id.userNameOnProfile);
        userNameOnProfile.setText(get);
    }

    public void onBackToMain(View view)
    {

        Intent i = new Intent(this, Main_Menu.class);
        //i.putExtra("fromMain", userNameFromLogIn);
        startActivity(i);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }

    public  void onSeeProfile(View view)
    {
        Intent i = new Intent(ProfileActivity.this, SeeProfileActivity.class);
        i.putExtra("fromProfile", get);
        startActivity(i);
    }



}
