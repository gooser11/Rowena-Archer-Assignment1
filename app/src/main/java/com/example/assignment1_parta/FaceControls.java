package com.example.assignment1_parta;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

public class FaceControls implements
        View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener,
        AdapterView.OnItemSelectedListener{

    private Face contrView;
    private FaceModel contrModel;
    private MainActivity myActivity;

    public FaceControls(Face aFaceView, MainActivity initActivity){
        contrView = aFaceView;
        contrModel = contrView.getFaceModel();
        myActivity = initActivity;
    }

    @Override
    public void onClick(View v) {
        Log.d("face", "randomize!");
        contrView.randomize();
        contrModel.hairChoice = contrView.randHair;

        contrView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // set color values in face model to progress bar values
        // Skin
        if ((seekBar.getId() == R.id.redBar) && (contrModel.partChoice == R.id.skinButton)){
            contrModel.redValSkin = progress;
        }
        else if ((seekBar.getId() == R.id.greenBar) && (contrModel.partChoice == R.id.skinButton)){
            contrModel.greenValSkin = progress;
        }
        else if ((seekBar.getId() == R.id.blueBar) && (contrModel.partChoice == R.id.skinButton)){

            contrModel.blueValSkin = progress;
        }
        //Hair
        else if ((seekBar.getId() == R.id.redBar) && (contrModel.partChoice == R.id.hairButton)){
            contrModel.redValHair = progress;

        }
        else if ((seekBar.getId() == R.id.greenBar) && (contrModel.partChoice == R.id.hairButton)){
            contrModel.greenValHair = progress;

        }
        else if ((seekBar.getId() == R.id.blueBar) && (contrModel.partChoice == R.id.hairButton)){
            contrModel.blueValHair = progress;

        }
        //Eyes
        else if ((seekBar.getId() == R.id.redBar) && (contrModel.partChoice == R.id.eyesButton)){
            contrModel.redValEyes = progress;

        }
        else if ((seekBar.getId() == R.id.greenBar) && (contrModel.partChoice == R.id.eyesButton)){
            contrModel.greenValEyes = progress;

        }
        else if ((seekBar.getId() == R.id.blueBar) && (contrModel.partChoice == R.id.eyesButton)){
            contrModel.blueValEyes = progress;

        }
        // send new colors to face view
        contrView.skinColor = contrModel.changeColor(contrModel.redValSkin, contrModel.greenValSkin, contrModel.blueValSkin);
        contrView.hairColor = contrModel.changeColor(contrModel.redValHair, contrModel.greenValHair, contrModel.blueValHair);
        contrView.eyeColor = contrModel.changeColor(contrModel.redValEyes, contrModel.greenValEyes, contrModel.blueValEyes);

        contrView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //nothing
    }

    SeekBar red;
    SeekBar green;
    SeekBar blue;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        contrModel.partChoice = checkedId;

        // when radio button is changed, change progress
        if (checkedId == R.id.hairButton){
            red = myActivity.findViewById(R.id.redBar);
            red.setProgress(contrModel.redValHair);

            green = myActivity.findViewById(R.id.greenBar);
            green.setProgress(contrModel.greenValHair);

            blue = myActivity.findViewById(R.id.blueBar);
            blue.setProgress(contrModel.blueValHair);
        }
        else if (checkedId == R.id.eyesButton){
            red = myActivity.findViewById(R.id.redBar);
            red.setProgress(contrModel.redValEyes);

            green = myActivity.findViewById(R.id.greenBar);
            green.setProgress(contrModel.greenValEyes);

            blue = myActivity.findViewById(R.id.blueBar);
            blue.setProgress(contrModel.blueValEyes);
        }
        else if (checkedId == R.id.skinButton){
            red = myActivity.findViewById(R.id.redBar);
            red.setProgress(contrModel.redValSkin);

            green = myActivity.findViewById(R.id.greenBar);
            green.setProgress(contrModel.greenValSkin);

            blue = myActivity.findViewById(R.id.blueBar);
            blue.setProgress(contrModel.blueValSkin);
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        //nothing
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // code from https://www.youtube.com/watch?v=on_OrrX7Nw4
        // "Text Spinner - Android Studio Tutorial" by Coding in FLow
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
        contrModel.hairChoice = position;
        contrView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
