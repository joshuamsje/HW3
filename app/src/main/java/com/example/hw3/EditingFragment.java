package com.example.hw3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class EditingFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button playButton;

    Spinner musicChoice;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    SeekBar seekBar1;
    SeekBar seekBar2;
    SeekBar seekBar3;

    private int p1;
    private int p2;
    private int p3;

    private String s;
    private String sound;
    private String sound2;
    private String sound3;

    private OnFragmentInteractionListener mListener;
    public EditingFragment()
    {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editing_fragment, container, false);
        p1 = 0;
        p2 = 0;
        p3 = 0;

        musicChoice = view.findViewById(R.id.musicSelector);
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);
        spinner3 = view.findViewById(R.id.spinner3);

        seekBar1 = view.findViewById(R.id.seekBar1);
        seekBar2 = view.findViewById(R.id.seekBar2);
        seekBar3 = view.findViewById(R.id.seekBar3);

        playButton = view.findViewById(R.id.playButton);

        playButton.setOnClickListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(), R.array.songs, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        musicChoice.setAdapter(adapter);
        musicChoice.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this.getContext(), R.array.sounds, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);
        spinner1.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this.getContext(), R.array.sounds, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter3);
        spinner2.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this.getContext(), R.array.sounds, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter4);
        spinner3.setOnItemSelectedListener(this);


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p1 = progress;
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
                p2 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p3 = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }

    public int getProgress()
    {

        return p1;
    }

    public int getProgress2()
    {
        return p2;
    }
    public int getProgress3()
    {

        return p3;
    }

    public void onAttach(Context context) {

        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            this.mListener = (OnFragmentInteractionListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + "must implement");
        }
    }

    @Override
    public void onDetach() {

        super.onDetach();

    }


    public void onClick(View v)
    {
        if(v.getId() == playButton.getId())
        {
            mListener.onButtonClicked(0);
        }

    }

    public void setSound(String m)
    {
        sound = m;
    }

    public void setSound2(String m)
    {
        sound2 = m;
    }

    public void setSound3(String m)
    {
        sound3 = m;
    }

    public String getSound()
    {
        return sound;
    }

    public String getSound2()
    {
        return sound2;
    }

    public String getSound3()
    {
        return sound3;
    }

    public void setMusicText(String m)
    {
        if (m.equals("Go Tech Go!"))
        {
            seekBar1.setMax(49);
            seekBar2.setMax(49);
            seekBar3.setMax(49);
        }
        else if (m.equals("Super Mario Bros."))
        {
            seekBar1.setMax(27);
            seekBar2.setMax(27);
            seekBar3.setMax(27);
        }
        else if (m.equals("Tetris"))
        {
            seekBar1.setMax(25);
            seekBar2.setMax(25);
            seekBar3.setMax(25);
        }

        s = m;
    }

    public String getMusicText()
    {
        return s;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        switch(parent.getId())
        {
            case R.id.musicSelector:
                String text = parent.getItemAtPosition(position).toString();
                setMusicText(text);
                break;
            case R.id.spinner1:
                String text2 = parent.getItemAtPosition(position).toString();
                Log.v("HEY", text2);
                setSound(text2);
                break;
            case R.id.spinner2:
                String text3 = parent.getItemAtPosition(position).toString();
                Log.v("HEY2", text3);
                setSound2(text3);
                break;
            case R.id.spinner3:
                String text4 = parent.getItemAtPosition(position).toString();
                Log.v("HEY3", text4);
                setSound3(text4);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        switch(parent.getId())
        {
            case R.id.musicSelector:
                String text = "Go Tech Go!";
                setMusicText(text);
                break;
            case R.id.spinner1:
                String text2 = "Cheering";
                setSound(text2);
                break;
            case R.id.spinner2:
                String text3 = "Cheering";
                setSound2(text3);
                break;
            case R.id.spinner3:
                String text4 = "Cheering";
                setSound3(text4);
                break;
        }

    }

    public interface OnFragmentInteractionListener{
        void onButtonClicked(int infoID);
    }


}
