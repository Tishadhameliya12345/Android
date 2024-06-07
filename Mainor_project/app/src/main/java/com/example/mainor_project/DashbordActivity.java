package com.example.mainor_project;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class DashbordActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
//    NavigationView navigationview;
//    Toolbar toolbar;
    CardView card1,card2,card3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.pink)));
        //getSupportActionBar().hide();

        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);
        //navigationview=(NavigationView) findViewById(R.id.navigation);
        card1=(CardView)findViewById(R.id.cardView);
        card2=(CardView)findViewById(R.id.cardView2);
        card3=(CardView)findViewById(R.id.cardView3);
        //toolbar=(Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,R.string.navigation_close);
        //drawerLayout.addDrawerListener(toggle);
        //toggle.syncState();

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashbordActivity.this,DonetActivity.class);
                startActivity(intent);
            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashbordActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DashbordActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}