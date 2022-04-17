package Lesson6;

import Lesson6.Animals.Animals;
import Lesson6.Animals.Cats;
import Lesson6.Animals.Dogs;

import static Lesson6.Animals.Animals.count;

public class Lesson6 {
    public static void main(String[] args) {

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
            if (runs.run(runs.getMaxDistance("run"), runs.maxRun)){
                runs.swim(runs.getMaxDistance("swim"));
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
