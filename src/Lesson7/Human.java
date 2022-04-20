package Lesson7;

import java.util.Random;

class Human {
    static Random random = new Random();
    private static final int limitPlate = random.nextInt(5) +1;
    static final Plate[] plate = new Plate[limitPlate];

    static int getPlate() {
        int numberPlate = random.nextInt(plate.length);
        while(plate[numberPlate] == null){
            numberPlate = random.nextInt(plate.length);
        }
        return numberPlate;
    }

    private static int numOfReqToCreatePlate = 0;
    static void newPlate(){
        numOfReqToCreatePlate++;
        for (int i = 0; i < plate.length ; i++) {
            if (numOfReqToCreatePlate > plate.length + 3){
                break;
            }
            if (numOfReqToCreatePlate > plate.length + 2){
                System.out.println("Все замучил, больше отвечать не буду!!!\n" +
                        "Подготовили " + plate.length + " тарелок с едой!!!");
                break;
            }
            if (plate[i] == null){
                plate[i] = new Plate(random.nextInt(100));
                break;
            }else if(plate[i] != null && i == plate.length - 1){
                System.out.println("У меня всего " + plate.length + " тарелки! Куда ты больше то лепишь!!!");
            }
        }
    }

    static void overEating(int numberPlate){
        System.out.println("Кот наелся!\n" + "В тарелке № " + (numberPlate + 1) + " осталось "
                +  plate[numberPlate].getFood() + "кг вискоса");
    }

    static void getAmountOfFood(Plate p){
        int newFood = random.nextInt(20) + 20;
        System.out.println("Еда в тарелке закончилась, добавим в нее еще " + newFood + "кг вискоса");
        p.newFood(newFood);
    }
}
