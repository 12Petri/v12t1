package com.petestudy.v12t1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.petestudy.v12t1.GameManager;
import com.petestudy.v12t1.Monster;
import com.petestudy.v12t1.Player;
import com.petestudy.v12t1.R;

public class ShowMonsterFragment extends Fragment {

    private Monster currentMonster;
    private TextView monsterNameText, monsterLifeText;
    private ImageView monsterImage;
    private ImageButton attackMonsterButton;

    private TextView monsterTypeText;

    public ShowMonsterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_monster, container, false);
        monsterNameText = view.findViewById(R.id.MonsterNameText);
        monsterLifeText = view.findViewById(R.id.MonsterLifeText);
        monsterImage = view.findViewById(R.id.MonsterImage);
        attackMonsterButton = view.findViewById(R.id.AttackMonsterButton);
        monsterTypeText = view.findViewById(R.id.MonsterTypeText);

        generateAndDisplayMonster();

        attackMonsterButton.setOnClickListener( v -> {
            if (currentMonster.getLife() <= 0) {
                return;
            }

            GameManager gm = GameManager.getInstance();
            Player player = gm.getPlayer();
            player.attack(currentMonster);
            updateMonsterUI();

            if (getActivity() instanceof com.petestudy.v12t1.FightMonstersActivity) {
                ((com.petestudy.v12t1.FightMonstersActivity) getActivity()).updateBossButton();
            }
        });

        return view;
    }

    private void generateAndDisplayMonster() {
        GameManager gm = GameManager.getInstance();
        gm.generateMonster();
        currentMonster = gm.getLatestMonster();
        updateMonsterUI();
    }

    private void updateMonsterUI() {
        monsterNameText.setText(currentMonster.getName());
        monsterLifeText.setText(currentMonster.getLife() + "/" + currentMonster.getMaxLife());

        String imageName = currentMonster.getImageName();
        int resId = getResources().getIdentifier(imageName, "drawable", requireContext().getPackageName());


        if (resId != 0) {
            monsterImage.setImageResource(resId);
        } else {
            monsterImage.setImageResource(R.drawable.ic_launcher_foreground);
        }

        if (currentMonster instanceof com.petestudy.v12t1.Skeleton) {
            monsterTypeText.setText("Luuranko");
        }
        else if (currentMonster instanceof com.petestudy.v12t1.Vampire) {
            monsterTypeText.setText("Vampyyri");
        }
        else {
            monsterTypeText.setText("Tuntematon");
        }
    }


}