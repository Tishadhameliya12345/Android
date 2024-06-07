package com.example.mainor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText emailid,password;
    TextView sbtn,lbtn,passforget;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        emailid=(EditText)findViewById(R.id.l_email);
        password=(EditText)findViewById(R.id.l_pass);
        lbtn=(TextView) findViewById(R.id.login);
        sbtn=(TextView) findViewById(R.id.signup);
        passforget=(TextView)findViewById(R.id.forgot_pass);
        DB=new DbHelper(this);

        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=emailid.getText().toString();
                String pass=password.getText().toString();

                if (email.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkemailpassword(email,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(LoginActivity.this,DashbordActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Invalid....", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        sbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        passforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,Forget_Password.class);
                startActivity(intent);
            }
        });
    }
}