package com.example.dipto.ieeemadc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp2 extends AppCompatActivity {

    ContactDatabaseHelper helper = new ContactDatabaseHelper(this);
    String  fromPage1, name ,email, contact , job ,education ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        fromPage1 = bundle.getString("fromSignUp");

        String  firstList[] = fromPage1.split("\n");

         name = firstList[0];
         email = firstList[1];
         contact = firstList[2];
         job = firstList[3];
         education = firstList[4];


    }

    public void onRegister(View view)
    {
        if(view.getId()==R.id.registerButton){
            EditText interestInput = (EditText)findViewById(R.id.interestInput);
            EditText sexInput = (EditText)findViewById(R.id.sexInput);
            EditText birthdayInput = (EditText)findViewById(R.id.birthdayInput);
            EditText passInput = (EditText)findViewById(R.id.passInput);
            EditText confirmInput = (EditText)findViewById(R.id.confirmInput);



            String interest = interestInput.getText().toString();
            String sex = sexInput.getText().toString();
            String birthday = birthdayInput.getText().toString();
            String password = passInput.getText().toString();
            String confirm = confirmInput.getText().toString();

            if(password.equals(confirm)){
                Contact newUser = new Contact(name,email,password,contact, job ,education, interest, birthday, sex);
                helper.insertContact(newUser);
                Intent i = new Intent(SignUp2.this,LoginActivity.class);
                startActivity(i);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
            else{
                Toast pass = Toast.makeText(SignUp2.this,"Password do not match",Toast.LENGTH_SHORT);
                pass.show();
            }

        }
    }
}
