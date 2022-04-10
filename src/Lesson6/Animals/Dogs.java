package Lesson6.Animals;

import java.util.Random;

public class Dogs extends Animals{
    Random random = new Random();
    private static int drownedDogs = 0;

    public Dogs(String name, String color) {
        super(name, color);
        this.type = "Dog";
    }

    public static int getDrownedDogs() {return drownedDogs;}

    @Override
    public boolean run(int meter) {
        super.run(meter);
        int maxRun = random.nextInt(500) + 100;
        if (meter > maxRun) {
            System.out.println("Но пробежал " + maxRun + "м. и запыхавшись остановился");
            return false;
        }else System.out.println("И успешно добежал до воды!!!");
        return true;
    }

    @Override
    public void swim(int meter) {
        super.swim(meter);
        int maxSwim = random.nextInt(10) + 5;
        if (meter > maxSwim) {
            System.out.println("Но проплыл " + maxSwim + "м. и утонул");
            drownedDogs++;
        }else System.out.println("И успешно доплыл!!!");
    }
}
