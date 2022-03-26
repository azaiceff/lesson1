package Lesson3;

//import java.util.Arrays;
import java.util.Random;

public class Lesson3 {
    public static void main(String[] args) {
    mass01();
    mass100();
    massX2();
    }
    static Random random = new Random();
    /*1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1,
0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0*/
    private static void mass01() {
        /*генерируем двухмерный массив и выводим его на печать*/
        System.out.println("Задание 1.\nГенерируем массив");
        int leng1 = random.nextInt(6) + 1;
        int leng2 = random.nextInt(21) + 1;
        int[][] mass01 = new int[leng1][leng2];
        for(int i = 0; i < leng1; i++) {
            for (int j = 0; j < leng2; j++){
                mass01[i][j] = random.nextInt(2);
                System.out.print(mass01[i][j]);
            }
            System.out.println();
        }
        System.out.println("Меняем в массиве 0 на 1 и 1 на 0");// и выводим его на печать
        for(int i = 0; i < leng1; i++) {
            for (int j = 0; j < leng2; j++){
                if(mass01[i][j] == 0){
                    mass01[i][j] = 1;
                    System.out.print(mass01[i][j]);
                }else {
                    mass01[i][j] = 0;
                    System.out.print(mass01[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
/*2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его
значениями 1 2 3 4 5 6 7 8 … 100;*/
    private static void mass100() {
        System.out.println("Задание 2.");
        int[][] mass100 = new int[3][100];
        for(int i = 0; i < mass100.length; i++) {
            int a = 0;
            for (int j = 0; j < mass100[i].length; j++){
                if (j == 51){ // здесь сделал перенос строки, а то не помещается на экран
                    System.out.println();
                }
                mass100[i][j] = a + 1;
                System.out.print(mass100[i][j] + " ");
                a += 1;
            }
            System.out.println("\n");// разделил строки массива для наглядности
        }
    }
/*3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6
умножить на 2*/
    private static void massX2() {
        System.out.println("Задание 3.");
        /*генерируем трехмерный массив, делаем подмену и выводим его на печать
        (подмену уже делал в первом задании, здесь решил пойти немного по другому)*/
        int leng = random.nextInt(6) + 4;
        int [][][] massX2 = new int[Math.abs(leng - 6) + 1][leng - 1][leng];
        //[Math.abs(leng - 6) + 1] здесь я мог получить отрицательное число, поэтому модуль.
        // Так же мог получить ноль, поэтому +1
        for(int i = 0; i < massX2.length; i++){
            for(int j = 0; j < massX2[i].length; j++){
                for(int k = 0; k < massX2[i][j].length; k++){
                    massX2[i][j][k] = random.nextInt(20);
                    if (massX2[i][j][k] <= 6 && massX2[i][j][k] != 0){ //в задании не сказано, включительно 6 или нет
                        System.out.print(massX2[i][j][k] + "\uD83D\uDE00");
                        //добавляю первоначальное значение и смайлик, чтобы в консоли увидеть,
                        // где произошла подмена числа
                        massX2[i][j][k] *= 2;
                    }else if(massX2[i][j][k] == 0){//так как при умножении на ноль
                        // мы получим ноль, рядом с ним оставим просто смайлик
                        System.out.print("\uD83D\uDE00");
                    }
                    System.out.print(massX2[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

}
