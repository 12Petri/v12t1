package com.petestudy.v12t1;

import java.util.Random;

public class GameManager {
    private static GameManager instance;
    private Player player;
    private  Monster latestMonster;

    private GameManager() {
        player = new Player();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public Player getPlayer() {
        return player;
    }

    public Monster generateMonster() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            latestMonster = new Skeleton();
        }
        else {
            latestMonster = new Vampire();
        }
        return latestMonster;
    }

    public Monster getLatestMonster() {
        return latestMonster;
    }
}
