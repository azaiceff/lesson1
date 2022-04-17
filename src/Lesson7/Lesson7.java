package Lesson7;

import java.util.Random;

import static Lesson7.Human.plate;


public class Lesson7 {

    public static void main(String[] args) {
        Random random = new Random();

        Cat[] cat = new Cat[random.nextInt(20) + 1];
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat(i + 1, random.nextInt(50) + 1);
        }

        System.out.println(("Мы захотели накормить бездомных котов.\n" +
                "На улице мы смогли поймать " +cat.length  + " котов\n").toUpperCase());

        System.out.println("У нас есть " + plate.length + " тарелок");

        int numberOfNewPlates = random.nextInt(30) + 1;
        System.out.println("Подготовим " + numberOfNewPlates + " тарелок с едой");
        for (int i = 0; i < numberOfNewPlates; i++) {
            Human.newPlate();
        }

        for (Cat a : cat){
            System.out.println();
            int numPlate = Human.getPlate();
            Plate.info(numPlate);
            a.info();
            a.eat(numPlate);
        }

        System.out.println("\nВсе коты накормлены, довольны и снова отпущены на волю))".toUpperCase());
    }
}
