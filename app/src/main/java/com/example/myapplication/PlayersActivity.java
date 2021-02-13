package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayersActivity extends AppCompatActivity {

    private String player1 = "";
    private String player2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
    }

    public void validatePlayers(View view) {
        getPlayers();
        Intent intent = new Intent(this, ModesActivity.class);
        intent.putExtra("player1 ", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }

    public void getPlayers(){
        EditText et1 = (EditText) findViewById(R.id.inputPlayer1);
        EditText et2 = (EditText) findViewById(R.id.inputPlayer2);

        player1 = et1.getText().toString();
        player2 = et2.getText().toString();
    }

}