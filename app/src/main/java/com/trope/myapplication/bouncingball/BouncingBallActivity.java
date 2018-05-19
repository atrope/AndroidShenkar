package com.trope.myapplication.bouncingball;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.trope.myapplication.R;

import java.util.Random;

public class BouncingBallActivity extends AppCompatActivity{
    protected BouncingBallInside bounceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.bouncing_balls);
        bounceView = findViewById(R.id.bounceView);
        bounceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickScreen(v.getMeasuredWidth(),v.getMeasuredHeight());}
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    protected void onClickScreen(int maxX, int maxY){
        Random rand = new Random();
        int sizeBall = rand.nextInt(150)+50;
        int xPos = rand.nextInt(maxX-(2*sizeBall))+sizeBall;
        int yPos = rand.nextInt(maxY-(2*sizeBall))+sizeBall;
        int speed = rand.nextInt(30)+1;
        bounceView.addBall(xPos, yPos, sizeBall,speed,Color.argb(255, rand.nextInt(256),rand.nextInt(256),rand.nextInt(256)));
    }
}
