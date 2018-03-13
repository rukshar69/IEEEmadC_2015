package com.example.dipto.ieeemadc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dipto on 10/05/2016.
 */
public class SignupActivity extends Activity {
    ContactDatabaseHelper helper = new ContactDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onPage2(View view){
        if(view.getId()==R.id.page2Button){
            EditText nameText = (EditText)findViewById(R.id.inputNameId);
            EditText emailText = (EditText)findViewById(R.id.inputEmailId);
            EditText contactNo = (EditText)findViewById(R.id.inputContact);
            EditText inputJobId = (EditText)findViewById(R.id.inputJobId);
            EditText inputEducation = (EditText)findViewById(R.id.inputEducationId);



            String name = nameText.getText().toString();
            String email = emailText.getText().toString();
            String contact = contactNo.getText().toString();
            String job = inputJobId.getText().toString();
            String education = inputEducation.getText().toString();

            Intent i = new Intent(this, SignUp2.class);

            i.putExtra("fromSignUp",name+"\n"+email+"\n"+contact+"\n"+job+"\n"+education );

            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

        }
    }
}
