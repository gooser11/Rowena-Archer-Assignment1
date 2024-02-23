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
    //Constants to define the dimensions of character's head

    public static final float headTop = 100f; //y val
    public static final float headLeft = 100f;
    public static final float headRight = 200f;
    public static final float headBottom = 200f;


    //paints and color values to draw diff parts of face
    //colors will be set in a the model class, where we will convert the decimal values to hex

    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint eyeWhites = new Paint();
    Random rand = new Random();

    private FaceModel faceData;

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        randomize();

        //setup palette
        skinPaint.setColor(0x00FF00); // change later
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        eyeWhites.setColor(0xFFFFFF); // plain white
        faceData = new FaceModel();

        setBackgroundColor(Color.WHITE);  //better than black default

    }
    public void randomize(){// randomize all values
        skinColor = rand.nextInt(0xFFFFFF);
        eyeColor = rand.nextInt(0xFFFFFF);
        hairColor = rand.nextInt(0xFFFFFF);
        hairStyle = rand.nextInt(0xFFFFFF);
    }

    public void onDraw(Canvas canvas){
        // draw head
        canvas.drawOval(100f, 100f, 200f, 200f, skinPaint);
        // draw eyes
        for(int i = 0; i < 2; i++){
            canvas.drawOval(0, 0, 0, 0, eyeWhites);
            canvas.drawOval(0, 0, 0, 0, eyePaint);
        }
        // draw hair

    }

    public FaceModel getFaceModel(){
        return this.faceData;
    }

}
