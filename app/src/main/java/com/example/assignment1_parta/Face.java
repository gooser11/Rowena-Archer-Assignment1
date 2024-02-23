package com.example.assignment1_parta;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.WHITE;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
    int randHair; // value used to randomize hair

    // Paints and colors
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint eyeWhites = new Paint();
    Paint mouthPaint = new Paint();

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
        mouthPaint.setColor(BLACK);
        faceData = new FaceModel();

        setBackgroundColor(Color.WHITE);

    }

    public void drawHair(Canvas c){
        hairPaint.setColor(hairColor);

        if (faceData.hairChoice == 0){
            // bald
        }
        else if (faceData.hairChoice == 1){
            // draw bob cut
            RectF bobTop = new RectF(headLeft-50f, headTop-50f, headRight+50f, headTop+300f);

            c.drawArc(bobTop, 90, 340, true, hairPaint);
            //c.drawRect(headLeft-50f, headTop-50f, headRight+50f, headTop+200f, hairPaint);
            c.drawRect(headLeft-50f, headTop, headLeft+100f, headTop+900f, hairPaint);
            c.drawRect(headRight-100f, headTop, headRight+50f, headTop+900f, hairPaint);
        }
        else if (faceData.hairChoice == 2){
            // cropped
            c.drawRect(headLeft-50f, headTop-50f, headRight+50f, headTop+200f, hairPaint);
        }
        else if (faceData.hairChoice == 3){
            // mullet
            c.drawRect(headLeft-50f, headTop-50f, headRight+50f, headTop+200f, hairPaint);
            c.drawRect(headLeft-50f, headTop-50f, headLeft+100f, headTop+900f, hairPaint);
            c.drawRect(headRight-100f, headTop-50f, headRight+50f, headTop+900f, hairPaint);

        }
    }

    public void onDraw(Canvas canvas){
        // draw head
        skinPaint.setColor(skinColor);
        canvas.drawOval(headLeft, headTop, headRight, headBottom, skinPaint);

        // draw eyes
        eyePaint.setColor(eyeColor);
        float incEyes = 200f;//space between eyes
        for(int i = 0; i < 2; i++){
            canvas.drawOval(headLeft + incEyes, headTop + 300f, headLeft + incEyes+140, headTop + 400f, eyeWhites);
            canvas.drawOval(headLeft + incEyes + 100f, headTop + 330f, headLeft + incEyes+50f, headTop + 380f, eyePaint);
            incEyes = incEyes + 200f;
        }

        //draw mouth
        canvas.drawLine(headLeft + incEyes, headTop + 600f, headRight - incEyes, headTop + 600f, mouthPaint);

        // draw hair
        drawHair(canvas);
    }
    public FaceModel getFaceModel(){
        return this.faceData;
    }

    public void randomize(){// randomize all values

        //taken from notes on moodle:
        // https://learning.up.edu/moodle/pluginfile.php/2398437/mod_resource/content/0/Spot.java

        // there is a much prettier way to do this but I am too lazy

        // skin
        int randColor = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        skinColor = randColor;
        // eyes
        randColor = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        eyeColor = randColor;
        // hair
        randColor = Color.rgb((int) (Math.random() * 256),
                (int) (Math.random() * 256),
                (int) (Math.random() * 256));
        hairColor = randColor;

        randHair = (int) (Math.random() * 4); // randomize hairstyle

    }
}
