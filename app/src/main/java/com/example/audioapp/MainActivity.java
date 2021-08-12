package com.example.audioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    Runnable runnable;
    Handler handler = new Handler();
    Runnable runnable1;
    Handler handler1 = new Handler();
    Runnable runnable2;
    Handler handler2 = new Handler();
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    MediaPlayer mediaPlayer2;
    SeekBar seekBar;
    SeekBar seekBar1;
    SeekBar seekBar2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this, R.raw.one);
        mediaPlayer1 = MediaPlayer.create(this, R.raw.two);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.three);
        mediaPlayer.start();
        mediaPlayer1.start();
        mediaPlayer2.start();
        mediaPlayer.pause();
        mediaPlayer1.pause();
        mediaPlayer2.pause();
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button3);
        seekBar = findViewById(R.id.seekBar2);
        seekBar1 = findViewById(R.id.seekBar3);
        seekBar2 = findViewById(R.id.seekBar4);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar1.setMax(mediaPlayer1.getDuration());
        seekBar2.setMax(mediaPlayer2.getDuration());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    mediaPlayer1.pause();
                    mediaPlayer2.pause();
                    button.setText("Pause");
                    button1.setText("Play");
                    button2.setText("Play");
                    updateSeekbar();
                } else {
                    mediaPlayer.pause();
                    button.setText("Play");
                }
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer1.isPlaying()){
                    mediaPlayer1.start();
                    mediaPlayer.pause();
                    mediaPlayer2.pause();
                    button1.setText("Pause");
                    button.setText("Play");
                    button2.setText("Play");
                    updateSeekbar1();
                } else {
                    mediaPlayer1.pause();
                    button1.setText("Play");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mediaPlayer2.isPlaying()){
                    mediaPlayer2.start();
                    mediaPlayer.pause();
                    mediaPlayer1.pause();
                    button2.setText("Pause");
                    button.setText("Play");
                    button1.setText("Play");
                    updateSeekbar2();
                } else {
                    mediaPlayer2.pause();
                    button2.setText("Play");
                }
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                } 
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer1.seekTo(progress);
                    seekBar.setProgress(progress);
                } 
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    mediaPlayer2.seekTo(progress);
                    seekBar.setProgress(progress);
                } 
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateSeekbar() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        seekBar.setProgress(currentPosition);
        runnable = new Runnable() {
            @Override
            public void run() {
                updateSeekbar();
            }
        };
        handler.postDelayed(runnable,1000);
    }
    private void updateSeekbar1() {
        int currentPosition = mediaPlayer1.getCurrentPosition();
        seekBar1.setProgress(currentPosition);
        runnable = new Runnable() {
            @Override
            public void run() {
                updateSeekbar1();
            }
        };
        handler.postDelayed(runnable,1000);
    }
    private void updateSeekbar2() {
        int currentPosition = mediaPlayer2.getCurrentPosition();
        seekBar2.setProgress(currentPosition);
        runnable = new Runnable() {
            @Override
            public void run() {
                updateSeekbar2();
            }
        };
        handler.postDelayed(runnable,1000);
    }
}