package com.example.myapplication;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Random rand = new Random();
    private TextView resultTextView;
    private Button d3;
    private Button d4;
    private Button d6;
    private Button d8;
    private Button d10;
    private Button d12;
    private Button d20;
    private Button d100;
    private int diceNo = 1;
    private  Button twoDice;
    private Button threeDice;
    private Button fourDice;
    private Button fiveDice;
    List<Integer> dices = new ArrayList<>();
    private StringBuilder numbers;
    private MediaPlayer diceSound;
    private MediaPlayer dicesSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceSound= MediaPlayer.create(this, R.raw.dice);
        diceSound.setVolume(20, 20);
        dicesSound= MediaPlayer.create(this, R.raw.dices);

        CompositeOnClickListener d3groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d4groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d6groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d8groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d10groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d12groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d20groupListener = new CompositeOnClickListener();
        CompositeOnClickListener d100groupListener = new CompositeOnClickListener();

        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);
        d6 = findViewById(R.id.d6);
        d8 = findViewById(R.id.d8);
        d10 = findViewById(R.id.d10);
        d12 = findViewById(R.id.d12);
        d20 = findViewById(R.id.d20);
        d100 = findViewById(R.id.d100);

        twoDice = findViewById(R.id.button2);
        threeDice = findViewById(R.id.button3);
        fourDice = findViewById(R.id.button4);
        fiveDice = findViewById(R.id.button5);

        resultTextView = findViewById(R.id.textView2);

        twoDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 2;
            }
        });
        threeDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 3;
            }
        });
        fourDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 4;
            }
        });
        fiveDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 5;
            }
        });

        d3groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(3, diceNo);
            }
        });
        d3groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d3.setOnClickListener(d3groupListener);

        d4groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(4, diceNo);
            }
        });
        d4groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d4.setOnClickListener(d4groupListener);

        d6groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(6, diceNo);
            }
        });
        d6groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d6.setOnClickListener(d6groupListener);

        d8groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(8, diceNo);
            }
        });
        d8groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d8.setOnClickListener(d8groupListener);

        d10groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(10, diceNo);
            }
        });
        d10groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d10.setOnClickListener(d10groupListener);

        d12groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(12, diceNo);
            }
        });
        d12groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d12.setOnClickListener(d12groupListener);

        d20groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(20, diceNo);
            }
        });
        d20groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d20.setOnClickListener(d20groupListener);

        d100groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice(100, diceNo);
            }
        });
        d100groupListener.addOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceNo = 1;
            }
        });
        d100.setOnClickListener(d100groupListener);

    }

    private void rollDice(int d, int diceNo){

        numbers = new StringBuilder();

       for(int i=0;i<diceNo;i++){
           int randNum = rand.nextInt(d)+1;
            dices.add(randNum);
       }

       for(Integer i : dices){
           numbers.append(i);
           numbers.append(" ");
       }
       if (diceNo == 1){
            diceSound.start();
       }
       else{
           dicesSound.start();
       }
       resultTextView.setText(numbers.toString());
       startAnimation();
       dices.clear();
       numbers = new StringBuilder();

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

    private void startAnimation(){
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
        resultTextView.startAnimation(animation);
    }
    }

