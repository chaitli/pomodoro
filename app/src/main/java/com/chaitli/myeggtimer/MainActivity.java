package com.chaitli.myeggtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Log.progress ("button pressed" , "nice!");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timerseekbar = findViewById(R.id.timerseekBar);
        final TextView timerTextview = findViewById(R.id.timertextview);

        timerseekbar.setMax(1500);
        timerseekbar.setProgress(30);

        timerseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress/60;
                int seconds = progress - (minutes * 60);

                String SecondString = Integer.toString(seconds);

                if(SecondString.equals("0")){
                    SecondString = "00";
                }

                timerTextview.setText(Integer.toString(minutes) + ":" + Integer.toString(seconds));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
