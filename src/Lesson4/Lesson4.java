package Lesson4;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static char[][] map;
    static int size = 9;
    static int line = 4;
    static char dot_empty = '•';
    static final char dot_x = 'X';
    static final char dot_o = 'O';
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        map();
        start();

    }

    private static void start(){
        while (true) {

            humanTurn();
            aiTurn();
            map();
            if (checkWin(dot_x, line)) {
                System.out.println("Человек победил");
                break;
            }
            if (checkWin(dot_o, line)) {
                System.out.println("Победил ИИ!");
                break;
            }
        }
    }

    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                map[i][j] = dot_empty;
            }
        }

    }

    private static void map(){
        System.out.print("YX");
        for (int i = 0; i< size; i++){
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++){
            System.out.print(i + 1 + " ");
            System.out.println(Arrays.toString(map[i]));

        }
    }

    private static void humanTurn(){
        int x,y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y));
        map[y][x] = dot_x;

    }

    private static void aiTurn() {
        int x,y;
        if (checkWin(dot_x, line - 2)){
            do {
                x = random.nextInt(map.length);
                y = random.nextInt(map[x].length);
            }while(!isCellValid(x, y));
            map[y][x] = dot_o;
        }else
        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map[x].length);
        }while(isCellValid(x, y));
        map[y][x] = dot_o;
        System.out.println("\nx = " + (x + 1) + " y = " + (y + 1));
    }

    private static boolean isCellValid (int x, int y){
        return (x < 0 || x >= size || y < 0 || y >= size) || map[y][x] != dot_empty;
    }

    private static boolean checkWin(char symb, int line){

        int str;
        int maxStr = 0;

        for (char[] chars : map) {
            for (int j = 0; j < chars.length; j++) {

                str = 1;
                while (j < chars.length - 1 && chars[j] == symb && chars[j + 1] == symb) {
                    j++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    } else if (j < chars.length - 1 && chars[j + 1] != symb) {
                        str = 1;
                    }
                }
            }
        }

        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                str = 1;
                while (i < map.length - 1 && map[i][j] == symb && map[i + 1][j] == symb) {
                    i++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    } else if (i < map.length - 1 && map[i + 1][j] != symb) {
                        str = 1;
                    }
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                str = 1;
                while (j < map[i].length - 1 && i < map.length - 1 && map[i][j] == symb && map[i + 1][j + 1] == symb) {
                    i++;
                    j++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    } else if (j < map[i].length - 1 && i < map.length - 1 && map[i + 1][j + 1] != symb) {
                        str = 1;
                    }
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                str = 1;
                while (j != 0 && i < map.length - 1 && map[i][j] == symb && map[i + 1][j - 1] == symb) {
                    i++;
                    j--;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    }
                    if (j != 0 && i < map.length - 1 && map[i + 1][j - 1] != symb) {
                        str = 1;
                    }
                }
            }
        }

        System.out.println(maxStr + " final str");
        return maxStr >= line;

    }
}
