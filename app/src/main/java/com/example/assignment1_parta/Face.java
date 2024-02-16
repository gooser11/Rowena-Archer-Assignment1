package com.example.assignment1_parta;

import android.graphics.Canvas;

import java.util.Random;

/**
 * @author Rowena Archer
 * @version 2024 Feb 15
 */

public class Face {
    int skinColor;
    int eyeColor;
    int hairColor;
    int hairStyle;
    Random rand = new Random();

    public Face(){
        randomize();
    }
    public void randomize(){
        skinColor = rand.nextInt(255);
        eyeColor = rand.nextInt(255);
        hairColor = rand.nextInt(255);
        hairStyle = rand.nextInt(3);
    }
    public void onDraw(Canvas canvas){
        //draw face
    }

}
