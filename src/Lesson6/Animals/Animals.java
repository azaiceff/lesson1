package Lesson6.Animals;

public abstract class Animals {

    private final String name;
    private final String color;
    private final String type;
    public static int count = 0;

    Animals(String name, String color, String type){
        this.name = name;
        this.color = color;
        this.type = type;
        count++;
    }

    public String  getName(){return name;}
    public String  getType(){return type;}

    public boolean run(int meter){
        System.out.println(color + " " + type + " " + name + " хотел пробежать " + meter + "м.");
        return false;
    }

    public void swim(int meter){
        System.out.println(color + " " + name + " должен проплыть " + meter + "м.");
    }

}
