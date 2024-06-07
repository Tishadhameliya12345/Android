package com.example.mainor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    EditText username,email,pass1,pass2;
    TextView btnsignup,bk_log;
    DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getSupportActionBar().hide();

        username=(EditText)findViewById(R.id.r_username);
        email=(EditText)findViewById(R.id.r_email);
        pass1=(EditText)findViewById(R.id.r_pass);
        pass2=(EditText)findViewById(R.id.r_pass2);
        btnsignup=(TextView) findViewById(R.id.r_signup);
        bk_log=(TextView)findViewById(R.id.back);
        DB=new DbHelper(this);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user=username.getText().toString();
                String emailid=email.getText().toString();
                String pass=pass1.getText().toString();
                String repass=pass2.getText().toString();

                if(user.equals("")||emailid.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(RegistrationActivity.this, "Please enter all fileds", Toast.LENGTH_SHORT).show();
                else {
                    if(pass.equals(repass)){
                        Boolean ckeckemail = DB.checkemail(emailid);
                        if(ckeckemail==false){
                            Boolean insert=DB.insertData(user,emailid,pass);
                            if(insert==true){
                                Toast.makeText(RegistrationActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(RegistrationActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(RegistrationActivity.this, "user already exists.please sign in..", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(RegistrationActivity.this, "Password not match.,sorry...", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        bk_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}