package com.example.flood;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class Draw extends View {
    int r;
    int m;
    Game game;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if (x > m / 4 && x < m / 4 + m / 2 && y > m / 4 && y < m / 4 + m / 2) {
            game.color = game.a[(x - m / 4) / r][(y - m / 4) / r];
            if (game.color != game.a[0][0]){
                game.move();
            }
        }
        invalidate();
        return super.onTouchEvent(event);
    }

    public Draw(Context context) {
        super(context);
        game = new Game();
        game.newGame();
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
        r = r / 2 / game.n;
        for (int i = 0; i < game.n; i++){
            for (int j = 0; j < game.n; j++){
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(game.a[i][j]);
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
