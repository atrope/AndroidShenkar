package com.trope.myapplication.bouncingball;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class BouncingBallInside extends View {
    private List<Ball> balls = new ArrayList<>();
    private Rect rectangle = new Rect();
    private Paint paint= new Paint();

    public BouncingBallInside(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public BouncingBallInside(Context context) {
        super(context);
        init();
    }
    protected void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }
    protected void addBall(int x,int y,int size,int speed,int color){
        if (balls.size()==10) balls.remove(0);
        balls.add(new Ball(x,y,size,speed,color));
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rectangle.set(canvas.getWidth()/4,canvas.getHeight()-500,canvas.getWidth()-canvas.getWidth()/4,canvas.getHeight());
        //rectangle.set(0,0,0,0);
        for(Ball ball : balls){
            ball.move(canvas,rectangle);
            canvas.drawOval(ball.oval,ball.paint);
        }
        canvas.drawRect(rectangle, paint);
        invalidate(); // See note
    }
}