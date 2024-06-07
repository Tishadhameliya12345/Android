package com.example.mainor_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView add;
    ArrayList<String> name,phno,location,item,time,day,quntity;
    DbHelper2 DB;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink)));

        add=(ImageView)findViewById(R.id.add_icon);
        DB=new DbHelper2(this);
        name=new ArrayList<>();
        phno=new ArrayList<>();
        location=new ArrayList<>();
        item=new ArrayList<>();
        time=new ArrayList<>();
        day=new ArrayList<>();
        quntity=new ArrayList<>();
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new MyAdapter(this,name,phno,location,item,time,day,quntity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HistoryActivity.this,DonetActivity.class);
                startActivity(intent);
            }
        });
    }

    private void displaydata() {
        Cursor cursor=DB.getdata();
        if(cursor.getCount()==0){
            Toast.makeText(HistoryActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
                while (cursor.moveToNext()){
                    name.add(cursor.getString(0));
                    phno.add(cursor.getString(1));
                    location.add(cursor.getString(2));
                    item.add(cursor.getString(3));
                    time.add(cursor.getString(4));
                    day.add(cursor.getString(5));
                    quntity.add(cursor.getString(6));
                }
        }
    }
}