package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CricketActivity extends AppCompatActivity implements View.OnClickListener {
    private String player1 = "";
    private String player2 = "";

    int player1Score = 0;
    int player2Score = 0;

    int currentPlayer = 1;

    private Button score15;
    private Button score16;
    private Button score17;
    private Button score18;
    private Button score19;
    private Button score20;
    private Button scoreBull;
    private Button nextPlayer;

    private int[][] cptPlayer1 = {
            {20, 0},
            {19, 0},
            {18, 0},
            {17, 0},
            {16, 0},
            {15, 0},
            {25, 0}
    };

    private int[][] cptPlayer2 = {
            {20, 0},
            {19, 0},
            {18, 0},
            {17, 0},
            {16, 0},
            {15, 0},
            {25, 0}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cricket);

        score20 = (Button) findViewById(R.id.score20);
        score19 = (Button) findViewById(R.id.score19);
        score18 = (Button) findViewById(R.id.score18);
        score17 = (Button) findViewById(R.id.score17);
        score16 = (Button) findViewById(R.id.score16);
        score15 = (Button) findViewById(R.id.score15);
        scoreBull = (Button) findViewById(R.id.scoreBull);

        nextPlayer = (Button) findViewById(R.id.nextPlayerButton);

        score20.setTag(20);
        score19.setTag(19);
        score18.setTag(18);
        score17.setTag(17);
        score16.setTag(16);
        score15.setTag(15);
        scoreBull.setTag(25);

        nextPlayer.setTag(100);

        score20.setOnClickListener(this);
        score19.setOnClickListener(this);
        score18.setOnClickListener(this);
        score17.setOnClickListener(this);
        score16.setOnClickListener(this);
        score15.setOnClickListener(this);
        scoreBull.setOnClickListener(this);

        nextPlayer.setOnClickListener(this);

        Intent intent = getIntent();
        player1 = intent.getExtras().getString("player1");
        player2 = intent.getExtras().getString("player2");
        TextView displayPlayer1Score = (TextView)findViewById(R.id.scorePlayer1);
        displayPlayer1Score.setText(String.valueOf(player1Score));

        TextView displayPlayer2Score = (TextView)findViewById(R.id.scorePlayer2);
        displayPlayer2Score.setText(String.valueOf(player2Score));

        TextView displayPlayer1Name = (TextView)findViewById(R.id.player1);
        TextView displayPlayer2Name = (TextView)findViewById(R.id.player2);

        displayPlayer1Name.setText(player1);
        displayPlayer2Name.setText(player2);

        TextView displayRound = (TextView)findViewById(R.id.textRoundOfC);
        displayRound.setText("C'est au tour de " + player1);

        displayCounters();
    }


    @Override
    public void onClick(View v) {
        TextView displayRound = (TextView)findViewById(R.id.textRoundOfC);
        if((int) v.getTag() == 100 && currentPlayer == 1){
            currentPlayer = 2;
            displayRound.setText("C'est au tour de " + player2);
        } else if ((int) v.getTag() == 100 && currentPlayer == 2){
            currentPlayer = 1;
            displayRound.setText("C'est au tour de " + player1);
        } else {
            scoreCount((int) v.getTag());
            TextView displayPlayer1Score = (TextView)findViewById(R.id.scorePlayer1);
            TextView displayPlayer2Score = (TextView)findViewById(R.id.scorePlayer2);
            displayPlayer1Score.setText(String.valueOf(player1Score));
            displayPlayer2Score.setText(String.valueOf(player2Score));
        }
    }

    public void scoreCount(int score){
        if (currentPlayer == 1){
            for(int i = 0; i<cptPlayer1.length; i++){
                if (cptPlayer1[i][0] == score){
                    System.out.printf("%d", cptPlayer1[i][0]);
                    if(cptPlayer1[i][1] < 3){
                        cptPlayer1[i][1]++;
                    } else if (cptPlayer2[i][1] < 3) {
                        player1Score += score;
                    }
                }
            }
        } else if (currentPlayer == 2){
            for(int i = 0; i<cptPlayer2.length; i++){
                if (cptPlayer2[i][0] == score){
                    if(cptPlayer2[i][1] < 3){
                        cptPlayer2[i][1]++;
                    } else if (cptPlayer1[i][1] < 3){
                        player2Score += score;
                    }
                }
            }
        }

        displayCounters();

        if(cptPlayer1[0][1] == 3
                && cptPlayer1[1][1] == 3
                && cptPlayer1[2][1] == 3
                && cptPlayer1[3][1] == 3
                && cptPlayer1[4][1] == 3
                && cptPlayer1[5][1] == 3
                && cptPlayer1[6][1] == 3
                && player1Score > player2Score
                ){
            endGame(player1);
        } else if (cptPlayer2[0][1] == 3
                && cptPlayer2[1][1] == 3
                && cptPlayer2[2][1] == 3
                && cptPlayer2[3][1] == 3
                && cptPlayer2[4][1] == 3
                && cptPlayer2[5][1] == 3
                && cptPlayer2[6][1] == 3
                && player2Score > player1Score
        ){
            endGame(player2);
        }
    }

    public void finish(){
        Intent intent = new Intent(this, PlayersActivity.class);
        startActivity(intent);
    }

    public void replay(){
        Intent intent = new Intent(this, CricketActivity.class);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }

    private void endGame(String winner){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("C'est gagné pour " + winner + " ! ")
                .setNegativeButton("Rejouer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        replay();
                    }
                })
                .setPositiveButton("Accueil", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .create()
                .show();
    }

    public void displayCounters(){
        TextView displayScore20Player1 = (TextView)findViewById(R.id.score20Player1);
        displayScore20Player1.setText(String.valueOf(cptPlayer1[0][1]));
        TextView displayScore19Player1 = (TextView)findViewById(R.id.score19Player1);
        displayScore19Player1.setText(String.valueOf(cptPlayer1[1][1]));
        TextView displayScore18Player1 = (TextView)findViewById(R.id.score18Player1);
        displayScore18Player1.setText(String.valueOf(cptPlayer1[2][1]));
        TextView displayScore17Player1 = (TextView)findViewById(R.id.score17Player1);
        displayScore17Player1.setText(String.valueOf(cptPlayer1[3][1]));
        TextView displayScore16Player1 = (TextView)findViewById(R.id.score16Player1);
        displayScore16Player1.setText(String.valueOf(cptPlayer1[4][1]));
        TextView displayScore15Player1 = (TextView)findViewById(R.id.score15Player1);
        displayScore15Player1.setText(String.valueOf(cptPlayer1[5][1]));
        TextView displayScoreBullPlayer1 = (TextView)findViewById(R.id.scoreBullPlayer1);
        displayScoreBullPlayer1.setText(String.valueOf(cptPlayer1[6][1]));

        TextView displayScore20Player2 = (TextView)findViewById(R.id.score20Player2);
        displayScore20Player2.setText(String.valueOf(cptPlayer2[0][1]));
        TextView displayScore19Player2 = (TextView)findViewById(R.id.score19Player2);
        displayScore19Player2.setText(String.valueOf(cptPlayer2[1][1]));
        TextView displayScore18Player2 = (TextView)findViewById(R.id.score18Player2);
        displayScore18Player2.setText(String.valueOf(cptPlayer2[2][1]));
        TextView displayScore17Player2 = (TextView)findViewById(R.id.score17Player2);
        displayScore17Player2.setText(String.valueOf(cptPlayer2[3][1]));
        TextView displayScore16Player2 = (TextView)findViewById(R.id.score16Player2);
        displayScore16Player2.setText(String.valueOf(cptPlayer2[4][1]));
        TextView displayScore15Player2 = (TextView)findViewById(R.id.score15Player2);
        displayScore15Player2.setText(String.valueOf(cptPlayer2[5][1]));
        TextView displayScoreBullPlayer2 = (TextView)findViewById(R.id.scoreBullPlayer2);
        displayScoreBullPlayer2.setText(String.valueOf(cptPlayer2[6][1]));
    }
}
