package com.example.dipto.ieeemadc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;


/**
 * Created by Dipto on 10/05/2016.
 */
public class Main_Menu extends Activity {

    String userNameFromLogIn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_2);
        TextView welcome = (TextView) findViewById(R.id.welcomeId);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        String get = bundle.getString("put");
        userNameFromLogIn = bundle.getString("put");
        welcome.setText("Welcome " + get);

        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.mainMenuFlipper);
        Animation animationFlipIn = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.fade_in );
        Animation animationFlipOut = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.fade_out);
        flipper.setInAnimation(animationFlipIn);
        flipper.setOutAnimation(animationFlipOut);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);



    }




    public void onQuizClick(View view) {
        if (view.getId() == R.id.quizButton) {
            Intent i = new Intent(Main_Menu.this, QuizActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }

    }

    public void onTutorialClick(View view) {
        if (view.getId() == R.id.tutorialButton) {
            Intent i = new Intent(Main_Menu.this, TutorialActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }

    public void onAdvClick(View view) {
        if (view.getId() == R.id.advButton) {
            Intent i = new Intent(Main_Menu.this, AdvActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }

    public void onChat(View view) {
        if (view.getId() == R.id.chatButton) {
            Intent i = new Intent(Main_Menu.this, ChatActivity.class);
            i.putExtra("fromMenu", userNameFromLogIn);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }

    public void onProfile(View view) {
        if (view.getId() == R.id.profileButton) {
            Intent i = new Intent(Main_Menu.this, ProfileActivity.class);
            i.putExtra("fromMain", userNameFromLogIn);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }

    public void onGraph(View view) {
        if (view.getId() == R.id.graphButton) {
            Intent i = new Intent(Main_Menu.this, Graph.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }



}
