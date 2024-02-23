package com.example.assignment1_parta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.SeekBar;
import android.widget.Button;


/**
 * @author Rowena Archer
 * @version 2024 Feb 15
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Face myFaceView = findViewById(R.id.faceView);
        FaceControls control = new FaceControls(myFaceView);

        // code from https://www.youtube.com/watch?v=on_OrrX7Nw4
        // "Text Spinner - Android Studio Tutorial" by Coding in FLow
        Spinner spinner = findViewById(R.id.hairOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.hairs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(control);

        //rando
        Button random = findViewById(R.id.randomize);
        random.setOnClickListener(control);

        //Seekbars
        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(control);

        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(control);

        SeekBar blueBar = findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(control);

        //Radio buttons
        RadioButton hair = findViewById(R.id.hairButton);
        hair.setOnCheckedChangeListener(control);

        RadioButton eyes = findViewById(R.id.eyesButton);
        eyes.setOnCheckedChangeListener(control);

        RadioButton skin = findViewById(R.id.skinButton);
        skin.setOnCheckedChangeListener(control);

        // radio group control can check which button the group has changed to!
        RadioGroup groupies = findViewById(R.id.buttonGroup);
        groupies.setOnCheckedChangeListener(control);
    }


}