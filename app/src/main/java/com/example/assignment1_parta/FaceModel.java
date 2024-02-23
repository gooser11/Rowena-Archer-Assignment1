package com.example.assignment1_parta;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;

import android.graphics.Color;


public class FaceModel {
    // skin color values
    public int redValSkin;
    public int greenValSkin;
    public int blueValSkin;
    // hair color values
    public int redValHair;
    public int greenValHair;
    public int blueValHair;
    // eye color values
    public int redValEyes;
    public int greenValEyes;
    public int blueValEyes;


    public int hairChoice; // holds the Id of whatever hair is chosen
    public int partChoice;// holds the Id of whatever Radio Button is chosen
    FaceModel() {}

    //taken from notes on moodle:
    // https://learning.up.edu/moodle/pluginfile.php/2398437/mod_resource/content/0/Spot.java
    public int changeColor(int r, int g, int b){
        int newColor = Color.rgb(r,g,b);
        return newColor;
    }
}
