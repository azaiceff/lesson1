package Lesson7;

import java.util.Random;

public class Plate {

    private int food;

    public Plate (int food){
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public int decreaseFood(int appetite) {
        if(food == 0){
            System.out.print("Еда в тарелке закончилась, добавим в нее еще ");
            newFood();
        }
        if(food - appetite > 0) {
            food -= appetite;
            return food;
        }else{
            int app = food - appetite;
            food = 0;
            return app;
        }
    }

    void newFood(){
        Random random = new Random();
        int newFood = random.nextInt(20) + 20;
        System.out.println(newFood + "кг вискоса");
        food += newFood;
    }

    public void info() {
        System.out.println("В тарелке " + food + "кг вискоса");
    }
}
