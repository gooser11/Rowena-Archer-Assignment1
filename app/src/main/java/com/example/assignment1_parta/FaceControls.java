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

    public FaceControls(Face aFaceView){
        contrView = aFaceView;
        contrModel = contrView.getFaceModel();
    }

    @Override
    public void onClick(View v) {
        Log.d("face", "randomize!");
        contrView.randomize();

        contrView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int xmlRedBar = R.id.redBar;
        int xmlGreenBar = R.id.greenBar;
        int xmlBlueBar = R.id.blueBar;

        int currSeekbar = seekBar.getId();

        // Skin
        if ((currSeekbar == xmlRedBar) && (contrModel.partChoice == R.id.skinButton)){
            contrModel.redValSkin = progress;
        }
        else if ((currSeekbar == xmlGreenBar) && (contrModel.partChoice == R.id.skinButton)){
            contrModel.greenValSkin = progress;
        }
        else if ((currSeekbar == xmlBlueBar) && (contrModel.partChoice == R.id.skinButton)){
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

        contrView.skinColor = contrModel.changeColor(contrModel.redValSkin, contrModel.greenValSkin, contrModel.blueValSkin);
        contrView.hairColor = contrModel.changeColor(contrModel.redValHair, contrModel.greenValHair, contrModel.blueValHair);
        contrView.eyeColor = contrModel.changeColor(contrModel.redValEyes, contrModel.greenValEyes, contrModel.blueValEyes);

        System.out.println(contrView.skinColor);
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        contrModel.partChoice = checkedId;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        //nothing
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
