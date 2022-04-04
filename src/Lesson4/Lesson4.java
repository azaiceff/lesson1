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
        while (true) {//Здесь немного по другому сделал чем в методичке. Даю возможность ИИ в последний момент
            humanTurn();                //подменить крестик на нолик, благодаря чему игра может продолжиться.
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
        for (int i = 0; i < size; i++){
            if (i > 9){
                System.out.print((i + 1) + " ");
            }else
            System.out.print(" " + (i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++){
            if (i > 8) {
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
        } while (isCellValid(x, y));
        map[y][x] = dot_x;

    }

    private static void aiTurn() {
        /*Это то, что касается задания о помощи ИИ в победе.
         С таким режимом ентому негодяю и помогать уже не хочется, обманщик епт, а не ИИ.
         Такой простой метод, а так прикольно с ним играть стало (с другой стороны, если понимаешь как это работает,
         обыграть все равно очень просто).
         Мысль, конечно, как ему помочь (так скажем законным путем) у меня есть. Благодаря тому,
         что я вынес проверки длинны линий в отдельные методы, можно попробовать их так же использовать для определения
         положения формирующийся линии и на основании этого выбрать координаты ответного хода ИИ*/
        int x,y;
        if (checkWin(dot_x, line - 2) /*&& size > 4*/){//можно отключить этот режим на маленьком поле
            do {
                x = random.nextInt(map.length);
                y = random.nextInt(map[x].length);
            }while(/*!isCellValid(x, y) */ map[y][x] != dot_x);
            //Можно поменять условие, будет по легче. Но в любом случае, есл понимаешь то обыграть ИИ легко
            map[y][x] = dot_o;
        }else
        do {
            x = random.nextInt(map.length);
            y = random.nextInt(map[x].length);
        }while(isCellValid(x, y));
        map[y][x] = dot_o;
        System.out.println("\nИИ сделал ход по координатам: " + "\nx = " + (x + 1) + " y = " + (y + 1));
    }

    private static boolean isCellValid (int x, int y){
        return (x < 0 || x >= size || y < 0 || y >= size) || map[y][x] != dot_empty;
    }

    /*Здесь начинаются методы проверки полученной длинны линий
 Пробовал сделать как-то по другому, но... То условия начинают конфликтовать между собой, то явно
  начинает попахивать говно-кодом и тд. Решил, что для меня пока оптимальнее оставить так
  Правильнее конечно пойти было другим путем. Сосредоточиться на методах, которым бы я передавал
  вводимые координаты и относительно них проверял бы длину линий. Но с точки зрения тестирования,
   выбранный мной путь, наверное правильнее (с каждым ходом, я как бы заново проверяю всю карту на случай,
   не произошли ли в ней какие сбои. Причем несколько раз немного разными алгоритмами, что повышает покрытие
   и качество тестирования)*/
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
                    } else if (j < chars.length - 1 && chars[j + 1] != symb) {
                        str = 1;
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
                    } else if (i < map.length - 1 && map[i + 1][j] != symb) {
                        str = 1;
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
                    } else if (j < map[i].length - 1 && i < map.length - 1 && map[i + 1][j + 1] != symb) {
                        str = 1;
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
        return maxStr;
    }

    private static boolean checkWin(char symb, int line){
/*В итоге вышел такой простой метод, резюмирующий все выше изложенные методы.
Чувствую, что здесь как-то более красиво можно написать, но IntelliJ на меня ругаться начала,
поэтому оставил пока так*/
        return horizontalLine(symb) >= line || verticalLine(symb) >= line
               || diagonalLineA(symb) >= line || diagonalLineB(symb) >= line;


    }
}
