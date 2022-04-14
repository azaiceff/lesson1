package Lesson7;

public class Cat {

    private final int name;
    private int appetite;
    Cat(int name, int appetite){
        this.name = name;
        this.appetite = appetite;
    }

    void info(){
        System.out.println("Кот № " + name + " хочет съесть " + appetite + "кг вискоса");
    }

    void eat(Plate p) {
        eats(p);
        while(appetite > 0) {
            System.out.println("Кот не наелся, ему еще нужно съесть " + appetite + "кг вискоса");
            p.newFood();
            eats(p);
        }
        appetite = 0;
        System.out.println("Кот наелся!\n" + "В тарелке осталось " + p.getFood() + "кг вискоса");
    }
    private void eats(Plate p){
        int app = appetite;
        appetite -= p.getFood();
        p.decreaseFood(app);
    }
}
/*Так ООпешней получается? Логика теперь такая получается)) Заходит голодный кошак и видит тарелку с едой.
Начинает есть и убавляет количество еды в тарелке. Если еда в тарелке закончилась, он просит добавки.
Добавка появляется, он снова начинает есть и так до тех пор, пока не утолит свой аппетит.))
*/