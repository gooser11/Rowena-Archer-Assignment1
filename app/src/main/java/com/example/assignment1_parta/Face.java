package com.example.assignment1_parta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import java.util.Random;

/**
 * @author Rowena Archer
 * @version 2024 Feb 15
 */

public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint eyeWhites = new Paint();
    Random rand = new Random();

    public Face(Context context, AttributeSet attrs){
        super(context, attrs); //ctor
        setWillNotDraw(false);
        randomize();

        //setup palette
        skinPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        eyeWhites.setColor(0xFFFFFF); // plain white

    }
    public void randomize(){// randomize all values
        skinColor = rand.nextInt(0xFFFFFF);
        eyeColor = rand.nextInt(0xFFFFFF);
        hairColor = rand.nextInt(0xFFFFFF);
        hairStyle = rand.nextInt(0xFFFFFF);
    }
    public void onDraw(Canvas canvas){
        // draw head

        // draw eyes

        // draw hair
    }

}
