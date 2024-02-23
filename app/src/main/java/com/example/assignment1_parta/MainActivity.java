package com.example.assignment1_parta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.SeekBar;
import android.widget.Button;


/**
 * @author Rowena Archer
 * @version 2024 Feb 15
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

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
        spinner.setOnItemSelectedListener(this);

        Button random = findViewById(R.id.randomize);
        random.setOnClickListener(control);

        SeekBar redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(control);

        SeekBar greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(control);

        SeekBar blueBar = findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(control);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}