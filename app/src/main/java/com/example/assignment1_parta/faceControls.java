package com.example.assignment1_parta;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class faceControls implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

private Face contrView;

// idk if I'll really need a model class
//private Face contrModel;

public faceControls(Face aFaceView){
    contrView = aFaceView;
    //model
}


    @Override
    public void onClick(View v) {
        Log.d("face", "randomize!");
        // randomize face on click of button
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("face", "scroll!");
        contrView.eyeColor = progress;
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
}
