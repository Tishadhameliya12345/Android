package com.example.mainor_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DonetActivity extends AppCompatActivity {
    EditText name,phno,loc,item,time,day,qunt;
    TextView sub;
    CheckBox checkBox;
    Dialog dialog;
    Calendar calendar;
    DbHelper2 DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donet);
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink)));
        getSupportActionBar().hide();

        name=(EditText) findViewById(R.id.name);
        phno=(EditText) findViewById(R.id.phono);
        loc=(EditText) findViewById(R.id.location);
        item=(EditText) findViewById(R.id.item);
        time=(EditText) findViewById(R.id.perfect_time);
        day=(EditText) findViewById(R.id.day);
        qunt=(EditText) findViewById(R.id.quantity);
//        checkBox=(CheckBox)findViewById(R.id.check);
        sub=(TextView) findViewById(R.id.btnsub);
        dialog=new Dialog(this);
        DB=new DbHelper2(this);

//        if(checkBox.isChecked()){
//            sub.setEnabled(true);
//        }
//        else if(!checkBox.isChecked()) {
//            sub.setEnabled(false);
//        }

        //////datepicker/////
        Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                updateCalender();
            }

            private void updateCalender(){
                String Format="MM/dd/yy";
                SimpleDateFormat sdf=new SimpleDateFormat(Format, Locale.US);

                day.setText(sdf.format(calendar.getTime()));
            }
        };
        day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new  DatePickerDialog(DonetActivity.this,date,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        ////////////////////////////////////////////////////////////////////////
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt=name.getText().toString();
                String phnotxt=phno.getText().toString();
                String loctxt=loc.getText().toString();
                String itemtxt=item.getText().toString();
                String timetxt=time.getText().toString();
                String daytxt=day.getText().toString();
                String quntxt=qunt.getText().toString();

                if(nametxt.equals("")||phnotxt.equals("")||loctxt.equals("")||itemtxt.equals("")||timetxt.equals("")||daytxt.equals("")||quntxt.equals(""))
                {
                    Toast.makeText(DonetActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkinsertdata = DB.insertdata(nametxt, phnotxt, loctxt, itemtxt, timetxt, daytxt, quntxt);
                    if (checkinsertdata == true) {
                        Toast.makeText(DonetActivity.this, "Susses", Toast.LENGTH_SHORT).show();
                        openDialog();
                    } else {
                        Toast.makeText(DonetActivity.this, "Error! Please Try Again..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void openDialog() {
        dialog.setContentView(R.layout.thanks_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //ImageView imageViewClose=dialog.findViewById(R.id.imageclose);
        TextView history=dialog.findViewById(R.id.textView3);
        Button btnOk=dialog.findViewById(R.id.btnOk);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DonetActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

        /*imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });*/
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}