package Lesson6.Animals;

import java.util.Random;

public class Cats extends Animals{
    Random random = new Random();

    public Cats(String name, String color) {
        super(name, color);
        this.type = "Кот";
    }

    @Override
    public boolean run(int meter) {
        super.run(meter);
        int maxRun = random.nextInt(200) +50;
        if (meter > maxRun) {
            System.out.println("Но пробежал " + maxRun + "м. и упал от усталости");
            return false;
        }else {
            System.out.println("И успешно добежал до воды!!!");
            return true;
        }
    }

    @Override
    public void swim(int meter) {
        System.out.println(type + " " + getName() + " не любит мочиться, просто попил водички, но не поплыл");
    }
}
