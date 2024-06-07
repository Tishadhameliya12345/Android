package com.example.mainor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Forget_Password extends AppCompatActivity {
    EditText f_email,f_pass,f_retry_pass;
    TextView reset,back;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getSupportActionBar().hide();

        f_email=(EditText) findViewById(R.id.forget_email);
        f_pass=(EditText) findViewById(R.id.forget_password);
        f_retry_pass=(EditText)findViewById(R.id.forget_confirmPass);
        reset=(TextView) findViewById(R.id.reset_pass);
        back=(TextView)findViewById(R.id.back_login);
        DB=new DbHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email,pass,repass;
                try {
                    email=f_email.getText().toString();
                    pass=f_pass.getText().toString();
                    repass=f_retry_pass.getText().toString();

                    if(email.equals("")||pass.equals("")||repass.equals(""))
                    {
                        Toast.makeText(Forget_Password.this, "Fill the filled Please", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(pass.equals(repass))
                        {
                            int updatpass=DB.update(email,pass);
                            if(updatpass==1)
                            {
                                f_email.setText("");
                                f_pass.setText("");
                                f_retry_pass.setText("");
                                Toast.makeText(Forget_Password.this, "Password is updated.", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Forget_Password.this,LoginActivity.class);
                                startActivity(intent);
                            }
                            else
                            {
                                Toast.makeText(Forget_Password.this, "invalid Email.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Forget_Password.this, "Password is mismatch.", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                catch (Exception e){
                    Toast.makeText(Forget_Password.this, "Out of bound"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Forget_Password.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}