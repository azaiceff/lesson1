package Lesson6.Animals;

import java.util.Random;

public class Cats extends Animals{
    Random random = new Random();
    public static int count;


    public Cats(String name, String color) {
        super(name, color, "Кот");
        count++;
    }

    @Override
    public void swim(int meter) {
        System.out.println(getType() + " " + getName() + " не любит мочиться, просто попил водички, но не поплыл");
    }

    @Override
    protected int getMaxRunDistance() {
        return random.nextInt(200) + 50;
    }

    @Override
    protected int getMaxSwimDistance() {
        return -1;
    }
}
