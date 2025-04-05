package com.petestudy.v12t1;

//Edellisten tehtävien ja kurssimateriaalin pohjalta tehty.
//Kokeiltu asioita harjoitustyö mielessä, mm. omat kuvat kaikille monstereille.

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView scoreText;

    @Override
    protected void onResume() {
        super.onResume();
        int score = GameManager.getInstance().getPlayer().getScore();
        scoreText.setText("Pisteet: " + score);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreText = findViewById(R.id.PlayerScoreText);
    }

    public void switchToFight(View view) {
        Intent intent = new Intent(this, FightMonstersActivity.class);
        startActivity(intent);
    }
}