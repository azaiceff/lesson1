package Lesson1;

public class Main {

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();

    }

    public static  void printThreeWords() {
        /*2. Создайте метод printThreeWords(),
        который при вызове должен отпечатать в столбец
        три слова: Orange, Banana, Apple.
        Orange
        Banana
        Apple*/
        System.out.println("Задание 2");
        System.out.println("Orange\nBanana\nApple");
        System.out.println();
    }

    // здесь генерирую случайное число (можно было сделать по другому
    // и затем определять диапазон
    // в который попадет случайное число в соот. методе,
    // но и так подходит ко всем заданиям)
    public static int random(){
        return (int) (Math.random() * 250) - 100;
    }

    public static  void checkSumSign() {
      /*3. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
        и инициализируйте их любыми значениями, которыми захотите.
        Далее метод должен просуммировать эти переменные,
        и если их сумма больше или равна 0,
        то вывести в консоль сообщение “Сумма положительная”,
        в противном случае - “Сумма отрицательная”;*/
        System.out.println("Задание 3");
        int a = random();
        int b = random();
        int c = a + b;
        System.out.println("a = " + a + "\nb = " + b);
        if (c >= 0) {
            System.out.println("Сумма положительная: " + c);
        }else {
            System.out.println("Сумма отрицательная: " + c);
        }
        System.out.println();
    }

    public static void printColor() {
        /*4. Создайте метод printColor() в теле которого задайте int переменную value
        и инициализируйте ее любым значением. Если value меньше 0 (0 включительно),
        то в консоль метод должен вывести сообщение “Красный”,
        если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно),
        то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”;*/
        System.out.println("Задание 4");
        int value = random();
        System.out.println(value);
        if (value <= 0 ) {
            System.out.println("Красный");
        }else if(value > 100) {
            System.out.println("Зеленый");
        }else {
            System.out.println("Желтый");
        }
        System.out.println();
    }

    public static void compareNumbers() {
        /*5. Создайте метод compareNumbers(),
        в теле которого объявите две int переменные a и b,
        и инициализируйте их любыми значениями, которыми захотите.
        Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
        в противном случае “a < b”;*/
        System.out.println("Задание 5");
        int a = random();
        int b = random();
        System.out.println("a = " + a + "\nb = " + b);
        if (a >= b) {
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

}




