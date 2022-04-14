package Lesson6.Animals;

import java.util.Random;

public class Cats extends Animals{
    Random random = new Random();
    public static int count;


    public Cats(String name, String color) {
        super(name, color, "Кот");
        this.maxRun = random.nextInt(200) +50;
        count++;
    }

    public int getMaxRun() {return maxRun;}

    @Override
    public void swim(int meter) {
        System.out.println(getType() + " " + getName() + " не любит мочиться, просто попил водички, но не поплыл");
    }
}
