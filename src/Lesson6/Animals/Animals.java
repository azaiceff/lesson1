package Lesson6.Animals;

import java.util.Random;

public abstract class Animals {
    Random random = new Random();

    private final String name;
    private final String color;
    private final String type;
    public static int count = 0;
    public int maxRun;

    Animals(String name, String color, String type){
        this.name = name;
        this.color = color;
        this.type = type;
        count++;
    }

    public String  getName(){return name;}
    public String  getType(){return type;}

    public boolean run(int meter, int maxRun){
        System.out.println(color + " " + type + " " + name + " хотел пробежать " + meter + "м.");
        if (meter > maxRun) {
            System.out.println("Но пробежал " + maxRun + "м. и упал от усталости");
            return false;
        }else {
            System.out.println("И успешно добежал до воды!!!");
        }
        return true;
    }

    public int getMaxDistance(String action){
        if(action.equals("run")){
            return random.nextInt(600) + 10;
        }else return random.nextInt(18) + 5;
    }

    public void swim(int meter){
        System.out.println(color + " " + name + " должен проплыть " + meter + "м.");
    }

}
