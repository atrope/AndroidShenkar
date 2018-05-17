package com.trope.myapplication.bouncingball;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;

import com.trope.myapplication.R;

import java.util.Random;

public class BouncingBallActivity extends AppCompatActivity{
    protected BouncingBallInside bounceView;
    protected Display display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.bouncing_balls);
        display = getWindowManager().getDefaultDisplay();
        bounceView = findViewById(R.id.bounceView);
        bounceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onClickScreen();}
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    protected void onClickScreen(){
        Point size = new Point();
        display.getSize(size);
        Random rand = new Random();
        int xPos = rand.nextInt(size.x)+1;
        int yPos = rand.nextInt(size.y)+1;
        int sizeBall = rand.nextInt(150)+50;
        int speed = rand.nextInt(30)+1;
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        bounceView.addBall(xPos, yPos, sizeBall,speed,Color.argb(255, r,g,b));
    }
}
