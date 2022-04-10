package Lesson6.Animals;

public abstract class Animals {

    private final String name;
    private final String color;
    String type;

    Animals(String name, String color){
        this.name = name;
        this.color = color;

    }

    public String  getName(){return name;}


    public boolean run(int meter){
        System.out.println(color + " " + type + " " + name + " хотел пробежать " + meter + "м.");
        return false;
    }

    public void swim(int meter){
        System.out.println(color + " " + name + " должен проплыть " + meter + "м.");
    }

}
