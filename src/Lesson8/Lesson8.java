package Lesson8;

import java.util.Random;
import java.util.Scanner;

public class Lesson8 {

    static Random random = new Random();
    static String[] words = {
            "apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic",
            "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut",
            "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"
    };

    public static void main(String[] args) {
        //new MyWindow(0);

        Scanner console = new Scanner(System.in);
        String hiddenWord = hidingWord();
        System.out.println("ИИ загадал слово - отгадайте его");

        StringBuilder word;
        String wordSC;
        int maxTrail = 5;
        do {
            System.out.println("У Вас осталось " + maxTrail + " попыток!");
            System.out.println("Введите загаданное слово");
            wordSC = console.nextLine().toLowerCase();
            if (!hiddenWord.equals(wordSC)) {
                word = getRandomNumberOfChars();
                for (int i = 0; i < hiddenWord.length(); i++) {
                    start:{
                        for (int j = 0; j < wordSC.length(); j++) {
                            if (hiddenWord.charAt(i) == wordSC.charAt(j)) {
                                word.append(wordSC.charAt(j));
                                break start;
                            }
                        }
                        word.append("*");
                    }
                }
                word.append(getRandomNumberOfChars());
                System.out.println(word);
            }
            maxTrail--;
        } while (!hiddenWord.equals(wordSC) && maxTrail > 0);

        if(maxTrail == 0 && !hiddenWord.equals(wordSC)){
            System.out.println("Вы проиграли! Загаданное слово " + hiddenWord);
        }else {
            System.out.println("Поздравляю! Вы угадали слово!");
        }

        char choice;
        do {
            System.out.println("Хотите съиграть еще?\ny - Да n - Нет");
            choice = Character.toLowerCase(console.next().charAt(0));
        } while (choice != 'y' && choice != 'n');
        switch (choice) {
            case 'y': main(null);
            case 'n': break;
        }
        System.out.println("Спасибо за игру!");
    }
    private static String hidingWord() {
        return words[random.nextInt(words.length)];
    }
    private static StringBuilder getRandomNumberOfChars(){
        StringBuilder sym = new StringBuilder();
        for (int i = 0; i < random.nextInt(5) +1; i++) {
            sym.append("*");
        }
        return sym;
    }
}
