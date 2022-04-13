package Lesson7;

import java.util.Random;

class Plate {

    private int food;

    Plate (int food){
        this.food = food;
    }

    int getFood() {
        return food;
    }
/*1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
В методе decreaseFood как раз реализовано это условие*/
    int decreaseFood(int appetite) {
        if(food == 0){
            System.out.print("Еда в тарелке закончилась, добавим в нее еще ");
            newFood();
        }
        if(food - appetite > 0){
            food -= appetite;
            return food; //здесь не имеет значение что возвращать, главное что бы число было не отрицательно
        }else{
            int app = food - appetite;
            food = 0;
            return app;
        }
    }
/*5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 Вот он, метод newFood() и в методе decreaseFood применяю его*/
    void newFood(){
        Random random = new Random();
        int newFood = random.nextInt(20) + 20;
        System.out.println(newFood + "кг вискоса");
        food += newFood;
    }

    void info() {
        System.out.println("В тарелке " + food + "кг вискоса");
    }
}
