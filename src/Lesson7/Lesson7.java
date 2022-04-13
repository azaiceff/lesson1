package Lesson7;

import java.util.Random;

public class Lesson7 {

    public static void main(String[] args) {
        Random random = new Random();

        Cat[] cat = new Cat[random.nextInt(20) + 1];
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat(i + 1, random.nextInt(50) + 1);
        }

        System.out.println(("Мы захотели накормить бездомных котов.\n" +
                "На улице мы смогли поймать " +cat.length  + " котов\n").toUpperCase());

        Plate plate = new Plate(random.nextInt(100));

        System.out.println("Подготовили тарелку с едой");

        for (Cat a : cat){
            plate.info();
            a.info();
            a.eat(plate);
            System.out.println();
        }

        System.out.println("Все коты накормлены, довольны и снова отпущены на волю))".toUpperCase());
    }
}
