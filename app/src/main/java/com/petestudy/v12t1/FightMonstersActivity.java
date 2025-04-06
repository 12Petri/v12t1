package com.petestudy.v12t1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.petestudy.v12t1.fragments.BossFightFragment;
import com.petestudy.v12t1.fragments.ShowMonsterFragment;

public class FightMonstersActivity extends AppCompatActivity {

    private Button bossButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fight_monsters);

        bossButton = findViewById(R.id.BossFightFragmentButton);
        bossButton.setEnabled(GameManager.getInstance().getPlayer().getScore() >= 100);
    }

    public void showMonster(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.FightMonstersFrame, new ShowMonsterFragment()).commit();
    }

    public void showBoss(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.FightMonstersFrame, new BossFightFragment()).commit();
    }

    public void returnToMain(View view) {
        finish();
    }

    public void updateBossButton() {
        if (bossButton != null) {
            bossButton.setEnabled(GameManager.getInstance().getPlayer().getScore() >= 100);
        }
    }

}
