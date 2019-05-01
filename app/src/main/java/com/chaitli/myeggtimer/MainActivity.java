package com.chaitli.myeggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    TextView timerTextview;
    Button button;
    SeekBar timerseekbar;
    Boolean counterActivity = false;
    CountDownTimer countDownTimer;

    public void ButtonClicked(View view) {

        if(counterActivity){

            timerTextview.setText("25:00");
            timerseekbar.setProgress(1500);
            timerseekbar.setEnabled(true);
            countDownTimer.cancel();
            button.setText("go!");
            counterActivity = false;

        } else {

            counterActivity = true;
            timerseekbar.setEnabled(false);

            countDownTimer = new CountDownTimer(timerseekbar.getProgress() * 1000, 1000) {

                @Override
                public void onTick(long l) {

                    UpdateTimer((int) l / 1000);
                    button.setText("stop");


                }

                @Override
                public void onFinish() {

                    Log.i("finished", "timer all done!");
                    timerTextview.setText("25:00");
                    button.setText("go");
                    timerseekbar.setProgress(1500);
                    timerseekbar.setEnabled(true);
                    countDownTimer.cancel();
                    counterActivity = false;


                }
            }.start();
        }

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          timerseekbar= findViewById(R.id.timerseekBar);
          timerTextview = findViewById(R.id.timertextview);
          button = findViewById(R.id.gobutton);
          getSupportActionBar().setTitle("pomodoro timer ");

        timerseekbar.setMax(1500);
        timerseekbar.setProgress(1500);

        timerseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                UpdateTimer (progress);


            }



            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void UpdateTimer ( int Secondsleft){
        int minutes = Secondsleft / 60;
        int seconds = Secondsleft - (minutes * 60);

        String SecondString = Integer.toString(seconds);

        if (seconds <= 9) {
            SecondString = "0" + SecondString ;
        }
        String minuteString = Integer.toString(minutes);
        if(minutes<=9){

            minuteString = "0" + minuteString;

        }

            timerTextview.setText( minuteString + ":" + (SecondString));

    }
}
