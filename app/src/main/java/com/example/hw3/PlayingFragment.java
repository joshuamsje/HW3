package com.example.hw3;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class PlayingFragment extends Fragment implements View.OnClickListener{

    Button playPause;
    Button restart;
    ImageView image;
    TextView musicResult;
    int counter = 0;
    int songLength = 0;

    MediaPlayer player;
    MediaPlayer soundPlayer;
    MediaPlayer soundPlayer2;
    MediaPlayer soundPlayer3;

    public PlayingFragment()
    {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.playing_fragment, container, false);

        playPause = view.findViewById(R.id.playPauseButton);
        restart = view.findViewById(R.id.restartButton);
        image = view.findViewById(R.id.imageView);
        musicResult = view.findViewById(R.id.resultSong);

        image.setImageResource(R.drawable.hokie);
        image.setTag(R.drawable.hokie);

        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player != null)
                {
                    if(playPause.getText().equals("Pause"))
                    {
                        player.pause();
                        playPause.setText("Start");
                    }
                    else
                    {
                        player.start();
                        playPause.setText("Pause");
                    }
                }
                if (soundPlayer != null)
                {
                    if(playPause.getText().equals("Pause"))
                    {
                        soundPlayer.start();
                    }
                    else
                    {
                        soundPlayer.pause();
                    }
                }

                if (soundPlayer2 != null)
                {
                    if(playPause.getText().equals("Pause"))
                    {
                        soundPlayer2.start();
                    }
                    else
                    {
                        soundPlayer2.pause();
                    }
                }

                if (soundPlayer3 != null)
                {
                    if(playPause.getText().equals("Pause"))
                    {
                        soundPlayer3.start();
                    }
                    else
                    {
                        soundPlayer3.pause();
                    }
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player != null)
                {
                    player.stop();
                    player.reset();
                    player.release();
                    playMusic();
                }
                if (soundPlayer != null)
                {
                    image.setImageResource(R.drawable.hokie);
                    soundPlayer.stop();
                    soundPlayer.reset();
                    soundPlayer.release();
                }
                if (soundPlayer2 != null)
                {
                    image.setImageResource(R.drawable.hokie);
                    soundPlayer2.stop();
                    soundPlayer2.reset();
                    soundPlayer2.release();
                }
                if (soundPlayer3 != null)
                {
                    image.setImageResource(R.drawable.hokie);
                    soundPlayer3.stop();
                    soundPlayer3.reset();
                    soundPlayer3.release();
                }
            }
        });
        return view;

    }

    public void playMusic()
    {
        if(musicResult.getText().equals("Go Tech Go!"))
        {
            songLength = 49;
            player = MediaPlayer.create(getActivity(), R.raw.gotechgo);
        }
        else if(musicResult.getText().equals("Super Mario Bros."))
        {
            songLength = 27;
            player = MediaPlayer.create(getActivity(), R.raw.mario);
        }
        else if(musicResult.getText().equals("Tetris"))
        {
            songLength = 25;
            player = MediaPlayer.create(getActivity(), R.raw.tetris);
        }

        counter++;
        player.start();
        playPause.setText("Pause");
    }

    public int getSongLength()
    {

        return songLength;
    }

    public void setImage(String s)
    {
        if (s.equals("Clapping"))
        {
            image.setImageResource(R.drawable.clapping);
            image.setTag(R.drawable.clapping);
        }
        else if (s.equals("Cheering"))
        {
            image.setImageResource(R.drawable.cheer);
            image.setTag(R.drawable.cheer);
        }
        else if (s.equals("Lets Go Hokies"))
        {
            image.setImageResource(R.drawable.letsgo);
            image.setTag(R.drawable.letsgo);
        }

    }

    public void playSound(String s)
    {

        if (playPause.getText().equals("Pause"))
        {
            if (s.equals("Clapping"))
            {
                soundPlayer = MediaPlayer.create(getActivity(), R.raw.clapping);
            }
            else if (s.equals("Cheering"))
            {
                soundPlayer = MediaPlayer.create(getActivity(), R.raw.cheering);
            }
            else if (s.equals("Lets Go Hokies"))
            {
                soundPlayer = MediaPlayer.create(getActivity(), R.raw.lestgohokies);
            }

            soundPlayer.start();
        }

    }

    public void playSound2(String s)
    {

        if (playPause.getText().equals("Pause"))
        {
            if (s.equals("Clapping"))
            {
                soundPlayer2 = MediaPlayer.create(getActivity(), R.raw.clapping);
            }
            else if (s.equals("Cheering"))
            {
                soundPlayer2 = MediaPlayer.create(getActivity(), R.raw.cheering);
            }
            else if (s.equals("Lets Go Hokies"))
            {
                soundPlayer2 = MediaPlayer.create(getActivity(), R.raw.lestgohokies);
            }

            soundPlayer2.start();
        }
    }

    public void playSound3(String s)
    {

        if (playPause.getText().equals("Pause"))
        {
            if (s.equals("Clapping"))
            {
                soundPlayer3 = MediaPlayer.create(getActivity(), R.raw.clapping);
            }
            else if (s.equals("Cheering"))
            {
                soundPlayer3 = MediaPlayer.create(getActivity(), R.raw.cheering);
            }
            else if (s.equals("Lets Go Hokies"))
            {
                soundPlayer3 = MediaPlayer.create(getActivity(), R.raw.lestgohokies);
            }

            soundPlayer3.start();
        }
    }


    public void onCompletion()
    {
        soundPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                soundPlayer.stop();
                soundPlayer.release();
                soundPlayer = null;
                image.setImageResource(R.drawable.hokie);
            }
        });
    }

    public void onCompletion2()
    {
        soundPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                soundPlayer2.stop();
                soundPlayer2.release();
                soundPlayer2 = null;
                image.setImageResource(R.drawable.hokie);
            }
        });
    }

    public void onCompletion3()
    {
        soundPlayer3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                soundPlayer3.stop();
                soundPlayer3.release();
                soundPlayer3 = null;
                image.setImageResource(R.drawable.hokie);
            }
        });
    }

    public int getC()
    {
        return counter;
    }

    public void setC(int c)
    {
        counter = c;
    }
    @Override
    public void onClick(View v) {

    }
}
