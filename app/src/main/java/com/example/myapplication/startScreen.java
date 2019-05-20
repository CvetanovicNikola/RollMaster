package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class startScreen extends AppCompatActivity {

    private MediaPlayer startSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        startSound = MediaPlayer.create(this, R.raw.sword);



    }




       public void startButtonOnClick(View v){
           ImageButton startButton = (ImageButton) v;
           startSound.start();
           startActivity(new Intent(getApplicationContext(), MainActivity.class));
       }







       private class CompositeOnClickListener implements View.OnClickListener{
        List<View.OnClickListener> listeners;

        public CompositeOnClickListener(){
            listeners = new ArrayList<View.OnClickListener>();
        }
        public void addOnClickListener(View.OnClickListener listener){
            listeners.add(listener);
        }
        @Override
        public void onClick(View v){
            for(View.OnClickListener listener : listeners){
                listener.onClick(v);
            }
        }
    }

}
