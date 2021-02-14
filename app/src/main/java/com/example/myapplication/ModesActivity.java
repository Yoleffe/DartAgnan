package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ModesActivity extends AppCompatActivity {
    private String player1 = "";
    private String player2 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modes);
        Intent intent = getIntent();
        player1 = intent.getExtras().getString("player1");
        player2 = intent.getExtras().getString("player2");
    }

    public void choiceThree(View view) {
        Intent intent = new Intent(this, Activity301.class);
        intent.putExtra("gameMode", 301);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }

    public void choiceFive(View view){
        Intent intent = new Intent(this, Activity301.class);
        intent.putExtra("gameMode", 501);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }

    public void choiceCricket(View view){
        Intent intent = new Intent(this, CricketActivity.class);
        intent.putExtra("player1", player1);
        intent.putExtra("player2", player2);
        startActivity(intent);
    }
}
