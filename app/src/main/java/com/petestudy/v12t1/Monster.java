package com.petestudy.v12t1;

public abstract class Monster {
    protected String name;
    protected int life;
    protected int maxLife;

    public Monster(int maxLife, String name) {
        this.name = name;
        this.maxLife = maxLife;
        this.life = maxLife;
    }

    public void takeDamage(int dmg) {
        life -= dmg;
        if (life < 0) {
            life = 0;
        }
    }

    public int getLife() {
        return life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public String getName() {
        return name;
    }

    public abstract String getImageName();
}
