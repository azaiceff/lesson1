package Lesson7;

import static Lesson7.Human.plate;

class Plate {

    private int food;

    Plate (int food){
        this.food = food;
    }

    int getFood() {
        return food;
    }
/*1. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).*/
    void decreaseFood(int appetite) {
        if(food > appetite){
            food -= appetite;
        }else{
            food = 0;
        }
    }
/*5. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку. */
    void newFood(int newFood){
        food += newFood;
    }

    static void info(int numberPlate) {
        System.out.println("В тарелке №" + (numberPlate + 1) + " " + plate[numberPlate].food + "кг вискоса");
    }
}
