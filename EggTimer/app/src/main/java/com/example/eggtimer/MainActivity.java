package com.example.eggtimer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView textView;
    Button button;

    CountDownTimer countDownTimer;

    MediaPlayer mediaPlayer;

    int countTime=30;

    boolean playing = false;
    public void countTime(View view) throws InterruptedException {

        if(!playing){

            button.setText("Stop");
            playing = true;

            countDownTimer = new CountDownTimer(countTime*1000,1000){

                @Override
                public void onTick(long millisUntilFinished) {

                    textView.setText(millisUntilFinished/1000 + ":00");
                }

                @Override
                public void onFinish() {

                    textView.setText("Finished");
                    mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.lucifer_theme_song);
                    mediaPlayer.start();
                }
            };

            countDownTimer.start();

        }
        else {

            button.setText("Play");
            playing=false;

            seekBar.setProgress(30);

            textView.setText("30:00");
            countDownTimer.cancel();
        }

    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        seekBar.setMin(10);
        seekBar.setMax(60);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String time = "  " + progress+":00";
                textView.setText(time);
                countTime = progress;
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