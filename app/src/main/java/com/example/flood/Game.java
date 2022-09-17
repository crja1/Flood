package com.example.flood;

import android.graphics.Color;

public class Game {
    static int n = 10;
    static int moveNumber = 16;
    boolean is_win = false;
    int color;
    int moves = 0;
    int[][] a = new int[n][n];
    int[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.WHITE, Color.BLACK, Color.GRAY,
            Color.YELLOW, Color.CYAN, Color.MAGENTA};
    static int colorNumber = 9;
    public void newGame(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                a[i][j] = colors[(int) (Math.random() * colorNumber)];
            }
        }
    }
    public void colorer(int i, int j, int old_color){
        a[i][j] = color;
        if (i < n - 1 && a[i + 1][j] == old_color){
            colorer(i + 1, j, old_color);
        }
        if (i > 0 && a[i - 1][j] == old_color){
            colorer(i - 1, j, old_color);
        }
        if (j < n - 1 && a[i][j + 1] == old_color){
            colorer(i, j + 1, old_color);
        }
        if (j > 0 && a[i][j - 1] == old_color){
            colorer(i, j - 1, old_color);
        }
    }
    public void move(){
        if (!is_win && moves < moveNumber) {
            moves = moves + 1;
            colorer(0, 0, a[0][0]);
            is_win = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] != color) {
                        is_win = false;
                    }
                }
            }
        }
    }
    public Game(){
        newGame();
    }
}
