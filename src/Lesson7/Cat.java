package Lesson7;

import static Lesson7.Human.plate;

public class Cat {

    private final int name;
    private int appetite;
    Cat(int name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    void info(){
        System.out.println("Кот № " + name + " хочет съесть " + appetite + "кг вискоса");
    }

    void eat(int numberPlate) {
        eats(numberPlate);
        while(appetite > 0) {
            System.out.println("Кот не наелся, ему еще нужно съесть " + appetite + "кг вискоса");
            Human.getAmountOfFood(plate[numberPlate]);
            eats(numberPlate);
        }
        appetite = 0;
        Human.overEating(numberPlate);
    }
    private void eats(int numberPlate){
        int app = appetite;
        appetite -= plate[numberPlate].getFood();
        plate[numberPlate].decreaseFood(app);
    }
}
