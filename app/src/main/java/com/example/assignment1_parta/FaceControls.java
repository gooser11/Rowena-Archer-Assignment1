package com.example.assignment1_parta;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

public class FaceControls implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    private Face contrView;

    private FaceModel contrModel;

    public FaceControls(Face aFaceView){
        contrView = aFaceView;
        contrModel = contrView.getFaceModel();
    }


    @Override
    public void onClick(View v) {
        Log.d("face", "randomize!");

        // randomize face on click of button

        contrView.invalidate();
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
