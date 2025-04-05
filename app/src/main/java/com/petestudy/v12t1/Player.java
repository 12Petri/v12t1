package com.petestudy.v12t1;

public class Player {
    private int damage = 5;
    private int score = 0;

    public Player() {}

    public void attack(Monster monster) {
        int monsterLifeBefore = monster.getLife();
        monster.takeDamage(damage);
        int actualDamage = monsterLifeBefore - monster.getLife();
        if (actualDamage > 0) {
            score += actualDamage;
        }
    }

    public int getScore() {
        return score;
    }
}

