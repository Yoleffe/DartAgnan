package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity301 extends AppCompatActivity implements View.OnClickListener{

    int player1Score = 301;
    int player2Score = 301;

    int currentPlayer = 1;

    private Button score1;
    private Button score2;
    private Button score3;
    private Button score4;
    private Button score5;
    private Button score6;
    private Button score7;
    private Button score8;
    private Button score9;
    private Button score10;
    private Button score11;
    private Button score12;
    private Button score13;
    private Button score14;
    private Button score15;
    private Button score16;
    private Button score17;
    private Button score18;
    private Button score19;
    private Button score20;
    private Button scoreBull;
    private Button nextPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_301);

        score20 = (Button) findViewById(R.id.button20);
        score19 = (Button) findViewById(R.id.button19);
        score18 = (Button) findViewById(R.id.button18);
        score17 = (Button) findViewById(R.id.button17);
        score16 = (Button) findViewById(R.id.button16);
        score15 = (Button) findViewById(R.id.button15);
        score14 = (Button) findViewById(R.id.button14);
        score13 = (Button) findViewById(R.id.button13);
        score12 = (Button) findViewById(R.id.button12);
        score11 = (Button) findViewById(R.id.button11);
        score10 = (Button) findViewById(R.id.button10);
        score9 = (Button) findViewById(R.id.button9);
        score8 = (Button) findViewById(R.id.button8);
        score7 = (Button) findViewById(R.id.button7);
        score6 = (Button) findViewById(R.id.button6);
        score5 = (Button) findViewById(R.id.button5);
        score4 = (Button) findViewById(R.id.button4);
        score3 = (Button) findViewById(R.id.button3);
        score2 = (Button) findViewById(R.id.button2);
        score1 = (Button) findViewById(R.id.button1);
        scoreBull = (Button) findViewById(R.id.buttonBull);

        nextPlayer = (Button) findViewById(R.id.buttonNextPlayer);

        score20.setTag(20);
        score19.setTag(19);
        score18.setTag(18);
        score17.setTag(17);
        score16.setTag(16);
        score15.setTag(15);
        score14.setTag(14);
        score13.setTag(13);
        score12.setTag(12);
        score11.setTag(11);
        score10.setTag(10);
        score9.setTag(9);
        score8.setTag(8);
        score7.setTag(7);
        score6.setTag(6);
        score5.setTag(5);
        score4.setTag(4);
        score3.setTag(3);
        score2.setTag(2);
        score1.setTag(1);
        scoreBull.setTag(25);

        nextPlayer.setTag(100);

        score20.setOnClickListener(this);
        score19.setOnClickListener(this);
        score18.setOnClickListener(this);
        score17.setOnClickListener(this);
        score16.setOnClickListener(this);
        score15.setOnClickListener(this);
        score14.setOnClickListener(this);
        score13.setOnClickListener(this);
        score12.setOnClickListener(this);
        score11.setOnClickListener(this);
        score10.setOnClickListener(this);
        score9.setOnClickListener(this);
        score8.setOnClickListener(this);
        score7.setOnClickListener(this);
        score6.setOnClickListener(this);
        score5.setOnClickListener(this);
        score4.setOnClickListener(this);
        score3.setOnClickListener(this);
        score2.setOnClickListener(this);
        score1.setOnClickListener(this);
        scoreBull.setOnClickListener(this);

        nextPlayer.setOnClickListener(this);

        TextView displayPlayer1Score = (TextView)findViewById(R.id.score1);
        displayPlayer1Score.setText(String.valueOf(player1Score));
        TextView displayPlayer2Score = (TextView)findViewById(R.id.score2);
        displayPlayer2Score.setText(String.valueOf(player2Score));

    }


    @Override
    public void onClick(View v) {
        if((int) v.getTag() == 100 && currentPlayer == 1){
            currentPlayer = 2;
        } else if ((int) v.getTag() == 100 && currentPlayer == 2){
            currentPlayer = 1;
        } else {
            substract((int) v.getTag());
            TextView displayPlayer1Score = (TextView)findViewById(R.id.score1);
            TextView displayPlayer2Score = (TextView)findViewById(R.id.score2);
            displayPlayer1Score.setText(String.valueOf(player1Score));
            displayPlayer2Score.setText(String.valueOf(player2Score));
        }
    }

    public void substract(int score){
        if(currentPlayer == 1){
            player1Score = player1Score - score;
        } else if(currentPlayer == 2) {
            player2Score = player2Score - score;
        }

    }

}