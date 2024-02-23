package com.example.assignment1_parta;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

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

    public static final float headTop = 400f; //y val
    public static final float headLeft = 250f;
    public static final float headRight = 1000f;
    public static final float headBottom = 1300f;


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
    Paint mouthPaint = new Paint();
    Random rand = new Random();

    private FaceModel faceData;

    public Face(Context context, AttributeSet attrs){
        super(context, attrs);
        setWillNotDraw(false);
        randomize();

        //setup palette
        skinPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
        eyeWhites.setColor(WHITE);
        mouthPaint.setColor(0xFF000000); // black
        faceData = new FaceModel();

        setBackgroundColor(Color.WHITE);  //better than black default

    }




    public void drawHair(){
        // draw bob

        // cropped

        // mullet



    }
    public void randomize(){// randomize all values
        skinColor = rand.nextInt(0xFFFFFF);
        eyeColor = rand.nextInt(0xFFFFFF);
        hairColor = rand.nextInt(0xFFFFFF);
        hairStyle = rand.nextInt(0xFFFFFF);


        /*int color = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        */
    }


    public void onDraw(Canvas canvas){
        // draw head
        skinPaint.setColor(skinColor);
        canvas.drawOval(250f, 400f, 1000f, 1300f, skinPaint);
        // draw eyes

        float incEyes = 200f;//space between eyes
        for(int i = 0; i < 2; i++){
            canvas.drawOval(headLeft + incEyes, headTop + 300f, headLeft + incEyes+140, headTop + 400f, eyeWhites);
            canvas.drawOval(headLeft + incEyes + 100f, headTop + 330f, headLeft + incEyes+50f, headTop + 380f, eyePaint);
            incEyes = incEyes + 200f;
        }

        //draw mouth
        canvas.drawLine(headLeft + incEyes, headTop + 600f, headRight - incEyes, headTop + 600f, mouthPaint);
        // draw hair
        drawHair();
    }

    public FaceModel getFaceModel(){
        return this.faceData;
    }

}
