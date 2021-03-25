package com.example.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements EditingFragment.OnFragmentInteractionListener {

    EditingFragment editFrag;
    PlayingFragment playingFrag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFrag = (EditingFragment) getSupportFragmentManager().findFragmentById(R.id.editFrag);
        playingFrag = (PlayingFragment) getSupportFragmentManager().findFragmentById(R.id.playFrag);


    }

    @Override
    public void onButtonClicked(int infoID) {
        if (infoID == 0)
        {
            openPlayScreen();
        }

    }

    public void openPlayScreen()
    {

        Intent intent = new Intent(this, PlayingScreen.class);
        intent.putExtra("musicPick", editFrag.getMusicText());
        intent.putExtra("sound1", editFrag.getSound());
        intent.putExtra("sound2", editFrag.getSound2());
        intent.putExtra("sound3", editFrag.getSound3());
        intent.putExtra("progress1", editFrag.getProgress());
        intent.putExtra("progress2", editFrag.getProgress2());
        intent.putExtra("progress3", editFrag.getProgress3());

        startActivity(intent);
    }
}