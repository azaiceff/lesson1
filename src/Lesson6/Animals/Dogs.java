package Lesson6.Animals;

import java.util.Random;

public class Dogs extends Animals{
    Random random = new Random();
    private final int maxSwim = random.nextInt(10) + 7;
    private static int drownedDogs = 0;
    public static int count;

    public Dogs(String name, String color) {
        super(name, color, "Дог");
        this.maxRun = random.nextInt(500) + 100;
        count++;
    }

    public static int getDrownedDogs() {return drownedDogs;}

    @Override
    public void swim(int meter) {
        super.swim(meter);
        if (meter > maxSwim) {
            System.out.println("Но проплыл " + maxSwim + "м. и утонул");
            drownedDogs++;
        }else System.out.println("Он может проплыть " + maxSwim + "м. и поэтому успешно доплыл!!!");
    }
}
