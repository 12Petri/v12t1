package com.petestudy.v12t1;

import java.util.Random;

public class Skeleton extends Monster {

    public Skeleton() {
        super(new Random().nextInt(10) + 20, "Luuranko: " + getRandomName());
    }

    private static String getRandomName() {
        String[] names = {"Leonardo", "Michelangelo", "Donatello", "Raphael"};
        return names[new Random().nextInt(names.length)];
    }

    @Override
    public String getImageName() {
        String name = getName().split(":")[1].trim().toLowerCase();
        return "luu_" + name;
    }
}
