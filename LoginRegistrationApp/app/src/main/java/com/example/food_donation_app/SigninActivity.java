package com.example.food_donation_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity {
    TextView btn_signin,btn_signup,btn_forgot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btn_signin=(TextView) findViewById(R.id.btn_signin);
        btn_signup=(TextView) findViewById(R.id.btn_signup);
        btn_forgot=(TextView) findViewById(R.id.forgot_pass);

        /*btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SigninActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });*/

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SigninActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });

        btn_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SigninActivity.this,ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }
}