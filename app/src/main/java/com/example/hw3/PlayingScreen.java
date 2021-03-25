package com.example.hw3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class PlayingScreen extends AppCompatActivity {
    PlayingFragment playFrag;

    private String result;
    private String sound1;
    private String sound2;
    private String sound3;

    private int prog1 = 0;
    private int prog2 = 0;
    private int prog3 = 0;

    private Handler handle;

    private Runnable r;
    private Runnable r2;
    private Runnable r3;

    private int counter = 0;
    private Timer timer;
    private TimerTask task;
    private Double time;
    MusicService musicService;
    MusicCompletionReceiver musicCompletionReceiver;
    MediaPlayer player;
    Intent startMusicServiceIntent;

    boolean isBound = false;
    boolean isInitialized = false;

    public static final String INITIALIZE_STATUS = "intialization status";
    public static final String MUSIC_PLAYING = "music playing";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        playFrag = (PlayingFragment) getSupportFragmentManager().findFragmentById(R.id.playFrag);

        timer = new Timer();
        time = 0.0;

        result = getIntent().getExtras().getString("musicPick");

        sound1 = getIntent().getExtras().getString("sound1");
        sound2 = getIntent().getExtras().getString("sound2");
        sound3 = getIntent().getExtras().getString("sound3");

        prog1 = getIntent().getExtras().getInt("progress1");
        prog2 = getIntent().getExtras().getInt("progress2");
        prog3 = getIntent().getExtras().getInt("progress3");

        playFrag.musicResult.setText(result);
        startService(new Intent(this, MusicService.class));
        Log.v("Sound 1: ", sound1);
        Log.v("Sound 2: ", sound2);
        Log.v("Sound 3: ", sound3);
        playFrag.playMusic();

        task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        // Stuff that updates the UI
                        time++;
                        if ((time == (double)prog1) && (prog1 != 0))
                        {
                            playFrag.setImage(sound1);
                            playFrag.playSound(sound1);
                            playFrag.onCompletion();
                        }
                        else if ((time == (double)prog2) && (prog2 != 0))
                        {
                            playFrag.setImage(sound2);
                            playFrag.playSound2(sound2);
                            playFrag.onCompletion2();
                        }
                        else if ((time == (double)prog3) && (prog3 != 0))
                        {
                            playFrag.setImage(sound3);
                            playFrag.playSound3(sound3);
                            playFrag.onCompletion3();
                        }
                    }
                });
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    public void updateName(String musicName) {

        playFrag.musicResult.setText(musicName);
    }

    /**
    @Override
    protected void onResume() {
        super.onResume();

        if(isInitialized && !isBound){
            bindService(startMusicServiceIntent, musicServiceConnection, Context.BIND_AUTO_CREATE);
        }

        registerReceiver(musicCompletionReceiver, new IntentFilter(MusicService.COMPLETE_INTENT));
    }
    **/

    /**
    @Override
    protected void onPause() {
        super.onPause();

        if(isBound){
            unbindService(musicServiceConnection);
            isBound= false;
        }

        unregisterReceiver(musicCompletionReceiver);
    }
     **/

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(INITIALIZE_STATUS, isInitialized);
        outState.putString(MUSIC_PLAYING, playFrag.musicResult.getText().toString());
        super.onSaveInstanceState(outState);
    }


}
