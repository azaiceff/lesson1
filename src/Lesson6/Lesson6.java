package Lesson6;

import Lesson6.Animals.Animals;
import Lesson6.Animals.Cats;
import Lesson6.Animals.Dogs;

import java.util.Random;

public class Lesson6 {
    public static void main(String[] args) {
        Random random = new Random();

        Animals[] catsAndDogs = {
                new Cats("Мурзик", "Белый"),
                new Cats("Барсик", "Черный"),
                new Cats("Рыжик", "Рыжий"),
                new Dogs("Бобик", "Черный"),
                new Dogs("Шарик", "Белый"),
                new Dogs("Тузик","Пятнистый"),
                new Dogs("Мухтар", "Черно-белый")
        };

        int dogs = 0;
        int cats = 0;
        for (Animals runs : catsAndDogs){
            int run = random.nextInt(600) + 10;
            if (runs.run(run)){
                runs.swim(random.nextInt(15) + 5);
                System.out.println();
            }else {
                System.out.println(runs.getName() + " не добежал до воды");
                System.out.println();
            }
            if (runs instanceof Dogs) {
                dogs++;
            }
            if (runs instanceof Cats){
                cats++;
            }
        }
        System.out.println("\nВсего собак " + dogs + "\nИз них утонуло " + Dogs.getDrownedDogs()
                + "\nВсего котов " + cats + "\nВсего животных " + (dogs + cats));
    }
}
