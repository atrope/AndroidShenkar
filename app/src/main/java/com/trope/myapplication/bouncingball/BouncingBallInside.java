package com.trope.myapplication.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BouncingBallInside extends View {
    private List<Ball> balls = new ArrayList<>();
    public BouncingBallInside(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public BouncingBallInside(Context context) {
        super(context);
    }
    protected void addBall(int x,int y,int size,int speed,int color){
        if (balls.size()==1) balls.remove(0);
        Log.d("addBall" ,"x: " + x + " y: " + y + " size: " + size);
        balls.add(new Ball(x,y,size,speed,color));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Draw the balls
        for(Ball ball : balls){
            //Move first
            ball.move(canvas);
            //Draw them
            canvas.drawOval(ball.oval,ball.paint);
        }
        invalidate(); // See note
    }
}