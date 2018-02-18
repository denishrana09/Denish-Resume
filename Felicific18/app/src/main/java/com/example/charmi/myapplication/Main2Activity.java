package com.example.charmi.myapplication;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    CardView card1,card2,card3,card4,card5;
    private DrawerLayout drawerlayout;
    private ActionBarDrawerToggle actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Feilicific");
       // toolbar.setLogo(android.R.drawable.ic_menu_info_details);

        // Finding card

        card1 = (CardView) findViewById(R.id.one);
        card2 = (CardView) findViewById(R.id.two);
        card3 = (CardView) findViewById(R.id.three);
        card4 = (CardView) findViewById(R.id.four);
        card5 = (CardView) findViewById(R.id.five);

        //Add this listner

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
        card5.setOnClickListener(this);


        //adding navigation

        drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        actionbar = new ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(actionbar);
        actionbar.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);






        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionbar.onOptionsItemSelected(item)) {

            return true;

        }

            return super.onOptionsItemSelected(item);


    }


    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId()) {
            case R.id.one: i = new Intent(this,Day1.class);startActivity(i);break;
            case R.id.two: i = new Intent(this,Day2.class);startActivity(i);break;
            case R.id.three: i = new Intent(this,Day3.class);startActivity(i);break;
            case R.id.four: i = new Intent(this,Day4.class);startActivity(i);break;
            case R.id.five: i = new Intent(this,Day5.class);startActivity(i);break;
            default:break;



        }
    }
}