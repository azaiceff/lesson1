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
        int maxRunDistance = getMaxRunDistance();
        System.out.println(color + " " + type + " " + name + " хотел пробежать " + meter + "м.");
        if (meter > maxRunDistance) {
            System.out.println("Но пробежал " + maxRunDistance + "м. и упал от усталости");
            return false;
        }else {
            System.out.println("И успешно добежал до воды!!!");
        }
        return true;
    }

    public void swim(int meter){
        System.out.println(color + " " + name + " должен проплыть " + meter + "м.");
    }

    protected abstract int getMaxRunDistance();
    protected abstract int getMaxSwimDistance();
}
