package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    ContactDatabaseHelper loginHelper = new ContactDatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
    }

    public void loginUser(View view){
        if(view.getId()==R.id.loginButton){
            EditText nameText = (EditText)findViewById(R.id.nameId);

            EditText passwordText = (EditText)findViewById(R.id.passwordId);


            String name = nameText.getText().toString();

            String password = passwordText.getText().toString();

            String data = loginHelper.searchContact(name);

            if(password.equals(data)){
                Intent i = new Intent(LoginActivity.this,Main_Menu.class);
                EditText nameOfUser = (EditText)findViewById(R.id.nameId);
                i.putExtra("put",nameOfUser.getText().toString());
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
            else{
                Toast pass = Toast.makeText(LoginActivity.this,"Password do not match",Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }

    public void createNewUser(View view){
        if(view.getId()==R.id.signupButton){
            Intent i = new Intent(LoginActivity.this,SignupActivity.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
    }

}
