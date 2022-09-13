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
        if (x >= 0 && x < m && y >= 0 && y < m) {
            game.color = game.a[x / r][y / r];
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
        paint.setTextSize(20);
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
        r = r / game.n;
        for (int i = 0; i < game.n; i++){
            for (int j = 0; j < game.n; j++){
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(game.a[i][j]);
                canvas.drawRect(i * r, j * r, i * r + r, j * r + r, paint);
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(Color.BLACK);
                canvas.drawRect(i * r, j * r, i * r + r, j * r + r, paint);
            }
        }
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText( game.moves + " из " + Game.moveNumber + " Ходов", 20, m + 20, paint);
    }
}
