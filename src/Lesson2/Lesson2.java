package Lesson2;

import java.util.Random;
import java.util.Scanner;

public class Lesson2 {

    public static void main(String[] args) {
        /*Словарь украинских слов для задания 4*/
        String[] task4 = {"Зонтик - парасолька", "Бабочка - метелик", "Лифт - ліфт",
                "Кощей бессмертный - кощій безсмертний", "Телевизор - телевізор",
                "Зеркало - дзеркало", "Киндер-сюрприз - Кіндер-сюрприз", "Соковыжималка - сіковичовалка",
                "Пылесос - пилосос", "Медсестра - медсестра", "Укол - укол", "Чайник - чайник",
                "Стул - стілець", "Штопор - штопор", "Коробка переключения передач - коробка перемикання передач",
                "Змей Горыныч - змій Горинич"};
        /*Массив со списком високосных годов для задания 5*/
        int[] year = {1764, 1768, 1772, 1776, 1780, 1784, 1788, 1792, 1796, 1804, 1808, 1812, 1816, 1820,
                1824, 1828, 1832, 1836, 1840, 1844, 1848, 1852, 1856, 1860, 1864, 1868, 1872, 1876, 1880,
                1884, 1888, 1892, 1896, 1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944,
                1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004,
                2008, 2012, 2016, 2020, 2024, 2028, 2032,2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064,
                2068, 2072, 2080, 2084, 2088, 2092, 2096, 2104, 2108, 2112, 2116, 2120, 2124, 2128, 2132,
                400, 800, 1200, 1600, 2000, 2400};

        Random random = new Random();
        // Здесь формирую меню выбора задания
        for (;;) {
            Scanner sc = new Scanner(System.in);
            menuAll: {
                char choice;
                do {//это текст меню
                    System.out.println("Справка: введите число соот. номеру задания\n\n" +
                    "1: Задание 1. Написать метод, принимающий на вход два целых числа\n" +
                            "и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),\n" +
                            "если да – вернуть true, в противном случае – false.\n\n" +
                    "2: Задание 2. Написать метод, которому в качестве" +
                            " параметра передается целое число, метод должен\n" +
                            "напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль\n" +
                            "считаем положительным числом.\n\n" +
                    "3: Задание 3. Написать метод, которому в качестве параметра " +
                            "передается целое число. Метод должен\n" +
                            "вернуть true, если число отрицательное, и вернуть false если положительное.\n\n" +
                    "4: Задание 4. Написать метод, которому в качестве аргументов " +
                            "передается строка и число, метод должен\n" +
                            "отпечатать в консоль указанную строку, указанное количество раз.\n\n" +
                    "5: Задание 5. Написать метод, который определяет, " +
                            "является ли год високосным, и возвращает boolean\n" +
                            "(високосный - true, не високосный - false). Каждый 4-й год " +
                            "является високосным, кроме каждого\n" +
                            "100-го, при этом каждый 400-й – високосный\n\n" +
                    "6: Рисование *\n" +
                    "q: Завершить программу");

                    choice = sc.next().charAt(0);

                } while (choice < '1' | choice > '6' & choice != 'q');

                if (choice == 'q') break;

                System.out.println("\n");

                switch (choice) {
                    case '1':
                        System.out.println(summ(random.nextInt(21), random.nextInt(21)));
                        System.out.println();
                        break;
                    case '2':
                        System.out.println(strSignOfNum(random.nextInt(21) - 10));
                        System.out.println();
                        break;
                    case '3':
                        System.out.println(boolSignOfNum(random.nextInt(21) - 10));
                        System.out.println();
                        break;
                    case '4':
                        System.out.println("Задание 4");
                        int n = random.nextInt(5) + 1;
                        System.out.println("Количство повторений: " + n);
                        printStringN(task4[random.nextInt(task4.length)], n);
                        System.out.println();
                        break;
                    case '5':
                        System.out.println("Задание 5");
                        for (; ; ) {
                            do {
                                System.out.println("Справка:\n" +
                                        "1. Ввести год с клавиатуры\n" +
                                        "2. Сгенерировать случайный год\n" +
                                        "q. Выход в предыдущее меню");
                                choice = sc.next().charAt(0);
                            } while (choice < '1' | choice > '2' & choice != 'q');

                            if (choice == 'q') break menuAll;

                            switch (choice) {
                                case '1':
                                    Scanner console = new Scanner(System.in);
                                    System.out.println("Введите год");
                                    System.out.println(year(console.nextInt()));
                                    break;
                                case '2':
                                    if (random.nextBoolean()) {
                                        System.out.println(year(year[random.nextInt(year.length)]));
                                    } else {
                                        System.out.println(year(random.nextInt(3000)));
                                    }
                                    System.out.println();
                                    break;
                            }
                        }
                    case '6':
                        painting();
                        System.out.println();
                        break;
                }
            }
        }
    }

/* Задание 1. Написать метод, принимающий на вход два целых числа
и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
если да – вернуть true, в противном случае – false. */
    private static boolean summ(int a, int b){
        System.out.println("Задание 1\na = " + a + "\nb = " + b + "\nsum = " + (a + b));

        int c = a + b;
        return c >= 10 && c <= 20;
    }

/* Задание 2. Написать метод, которому в качестве параметра передается целое число, метод должен
напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
считаем положительным числом.*/
    private static String strSignOfNum(int a) {
        System.out.print("\nЗадание 2\nЧисло: " + a);

        if (a >= 0) {
           return " -- положительное";
        }else return " -- отрицательное";
    }
/* Задание 3. Написать метод, которому в качестве параметра передается целое число. Метод должен
вернуть true, если число отрицательное, и вернуть false если положительное.*/
    private static boolean boolSignOfNum(int a){
        System.out.println("Задание 3\na = " + a);

        return a < 0;
    }
/* Задание 4. Написать метод, которому в качестве аргументов передается строка и число, метод должен
отпечатать в консоль указанную строку, указанное количество раз;*/
    private static void printStringN(String m, int n){

        for (int i = 0; i < n; i++) {
            System.out.println(m);
        }
    }
/* Задание 5. * Написать метод, который определяет, является ли год високосным, и возвращает boolean
(високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого
100-го, при этом каждый 400-й – високосный.*/
    private static boolean year(int year){
        System.out.println(year + "г.");
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    /* Рисование. Бонусное задание из методички - не для ДЗ */
    private static void painting() {
        System.out.println("Рисование\n\nРисунок 1");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++){
                if (i == 0 || i == 5 || j == 0 || j == 5){
                    System.out.print("* ");
                }else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\nРисунок 2");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 0 || i == 5 || j == 0 || j == 5 || i == j) {
                    System.out.print("* ");
                }else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\nРисунок 3");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i == 5 || j == 0 || i == j) {
                    System.out.print("* ");
                }else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\nРисунок 4");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (i < 2 || j < 2 || i > 3 || j > 3) {
                    System.out.print("* ");
                }else System.out.print("  ");
            }
            System.out.println();
        }

        System.out.println("\nРисунок 5");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i < 4 || j > 1) && (i > 1 || j < 4)){
                    System.out.print("* ");
                }else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
