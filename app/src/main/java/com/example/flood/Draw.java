package com.example.flood;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View {
    int n = 10;
    int r;
    int m;
    int color;
    int[][] a = new int[n][n];
    int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.BLACK, Color.GRAY,
            Color.YELLOW, Color.CYAN, Color.MAGENTA};
    public void newGame(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = colors[(int) (Math.random() * colors.length)];
            }
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x > m / 4 && x < m / 4 + m / 2 && y > m / 4 && y < m / 4 + m / 2) {
            color = a[(x - m / 4) / r][(y - m / 4) / r];

        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public Draw(Context context) {
        super(context);
        newGame();
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        Paint paint = new Paint();
        repaint(canvas, paint);
    }
    protected void repaint(Canvas canvas, Paint paint){
        paint.setStyle(Paint.Style.FILL);
        int x = canvas.getWidth();
        int y = canvas.getHeight();
        if (x > y){
            r = y;
        }
        else {
            r = x;
        }
        m = r;
        r = r / 2 / n;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(a[i][j]);
                int bottom = m / 4 + j * r + r;
                int right = m / 4 + i * r + r;
                canvas.drawRect((int)(m / 4) + i * r, (int)(m / 4) + j * r, right, bottom, paint);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                canvas.drawRect((int)(m / 4) + i * r, (int)(m / 4) + j * r, right, bottom, paint);
            }
        }
    }
}
