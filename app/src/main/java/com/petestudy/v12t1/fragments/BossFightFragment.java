package com.petestudy.v12t1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.petestudy.v12t1.GameManager;
import com.petestudy.v12t1.Monster;
import com.petestudy.v12t1.Player;
import com.petestudy.v12t1.R;


public class BossFightFragment extends Fragment {

    private Monster boss;
    private boolean revived = false;

    private TextView bossText;
    private ImageView bossImage;
    private ImageButton attackButton;

    public BossFightFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_boss_fight, container, false);

        bossText = view.findViewById(R.id.BossText);
        bossImage = view.findViewById(R.id.BossImage);
        attackButton = view.findViewById(R.id.AttackBossButton);

        boss = new Monster(100, "Pekka Velho") {
            @Override
            public void takeDamage(int dmg) {
                if (!revived && life - dmg < (getMaxLife() / 2)) {
                    life = getMaxLife();
                    revived = true;
                }
                else {
                    super.takeDamage(dmg);
                    }
                }

                public String getImageName() {
                    return "boss_pekka";
                }
            };

        updateUI();

        attackButton.setOnClickListener(v ->{
            Player player = GameManager.getInstance().getPlayer();
            player.attack(boss);
            updateUI();
        });

        return view;
    }

    private void updateUI() {
        bossText.setText(boss.getName() + ": " + boss.getLife() + "/" +boss.getMaxLife());


        int resId = getResources().getIdentifier(boss.getImageName(), "drawable", requireContext().getPackageName());
        if (resId != 0) {
            bossImage.setImageResource(resId);
        }
        else {
            bossImage.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }



}