package Lesson6;

import Lesson6.Animals.Animals;
import Lesson6.Animals.Cats;
import Lesson6.Animals.Dogs;

import java.util.Random;

import static Lesson6.Animals.Animals.count;

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

        for (Animals runs : catsAndDogs){
            int run = random.nextInt(600) + 10;
            int meter = random.nextInt(18) + 5;
            if (runs.run(run, runs.maxRun)){
                runs.swim(meter);
                System.out.println();
            }else {
                System.out.println(runs.getName() + " не добежал до воды");
                System.out.println();
            }
        }
        System.out.println("\nВсего собак " + Dogs.count + "\nИз них утонуло " + Dogs.getDrownedDogs()
                + "\nВсего котов " + Cats.count + "\nВсего животных " + count);
    }
}
