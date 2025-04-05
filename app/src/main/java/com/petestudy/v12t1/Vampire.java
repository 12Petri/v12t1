package com.petestudy.v12t1;

import java.util.Random;

public class Vampire extends Monster{

    public Vampire() {
        super(new Random().nextInt(15) + 25, "Vampyyri: " + getRandomName());
    }

    private static String getRandomName() {
        String[] names = {"Frodo", "Sam", "Merry", "Pippin"};
        return names[new Random().nextInt(names.length)];
    }

    @Override
    public String getImageName() {
        String name = getName().split(":")[1].trim().toLowerCase();
        return "vamp_" + name;
    }
}
