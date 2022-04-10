package Lesson4;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static char[][] map;
    static int size = 10; // Можно выбрать размер игрового поля
    static int line = 5; // можно выбрать из скольки элементов будет состоять линия для выигрыша
    static char dot_empty = '•';
    static final char dot_x = 'X';
    static final char dot_o = 'O';
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("СЫГРАЕМ В КРЕСТИКИ-НОЛИКИ? \n        Твой ход!\n");
        initMap();
        map();
        start();
    }

    private static void start(){
        while (true) {
            humanTurn();
            map();
            aiTurn();
            map();
            if (checkWin(dot_x, line)) {
                System.out.println("Человек победил!");
                break;
            }
            if (checkWin(dot_o, line)) {
                System.out.println("Победил ИИ!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
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
        int sizeX = 9;
        for (int i = 0; i < size; i++){
            if (i > sizeX){
                System.out.print((i + 1) + " ");
            }else
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        int sizeY = 8;
        for (int i = 0; i < size; i++){
            if (i > sizeY) {
                System.out.print(i + 1);
            }else
            System.out.print(i + 1 + " ");
            System.out.println(Arrays.toString(map[i]));
        }
    }

    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == dot_empty) return false;
            }
        }
        return true;
    }

    private static void humanTurn(){
        int x,y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y, dot_x));
        map[y][x] = dot_x;
    }

    private static void aiTurn() {
        int x,y;
        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map[x].length);
        }while(isCellValid(x, y, dot_o));
        map[y][x] = dot_o;
        System.out.println("\nИИ сделал ход по координатам: " + "\nx = " + (x + 1) + " y = " + (y + 1));
    }

    private static boolean isCellValid (int x, int y, char symb){
        if (checkWin(dot_x, line - 2) && size > 4 && symb == dot_o) {
            return map[y][x] != dot_x;
        } else {
            return (x < 0 || x >= size || y < 0 || y >= size) || map[y][x] != dot_empty;
        }
    }

    private static int horizontalLine (char symb){
        int maxStr = 0;
        for (char[] chars : map) {
            for (int j = 0; j < chars.length; j++) {
                int str = 1;
                while (j < chars.length - 1 && chars[j] == symb && chars[j + 1] == symb) {
                    j++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    }
                }
            }
        }
        return maxStr;
    }

    private static int verticalLine (char symb){
        int maxStr = 0;
        for (int j = 0; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                int str = 1;
                while (i < map[j].length - 1 && map[i][j] == symb && map[i + 1][j] == symb) {
                    i++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    }
                }
            }
        }
        return maxStr;
    }

    private static int diagonalLineA (char symb){
        int maxStr = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int str = 1;
                while (j < map[i].length - 1 && i < map.length - 1 && map[i][j] == symb && map[i + 1][j + 1] == symb) {
                    i++;
                    j++;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    }
                }
            }
        }
        return maxStr;
    }

    private static int diagonalLineB (char symb){
        int maxStr = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                int str = 1;
                while (j > 0 && i < map.length - 1 && map[i][j] == symb && map[i + 1][j - 1] == symb) {
                    i++;
                    j--;
                    str++;
                    if (maxStr < str) {
                        maxStr = str;
                    }
                }
            }
        }
        return maxStr;
    }

    private static boolean checkWin(char symb, int line){
        return horizontalLine(symb) >= line || verticalLine(symb) >= line
               || diagonalLineA(symb) >= line || diagonalLineB(symb) >= line;

    }
}
