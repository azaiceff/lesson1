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
    void decreaseFood(int appetite) {
        if(food > appetite){
            food -= appetite;
        }else{
            food = 0;
        }
    }
/*5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку. */
    void newFood(){
        Random random = new Random();
        int newFood = random.nextInt(20) + 20;
        System.out.println("Еда в тарелке закончилась, добавим в нее еще " + newFood + "кг вискоса");
        food += newFood;
    }

    void info() {
        System.out.println("В тарелке " + food + "кг вискоса");
    }
}
