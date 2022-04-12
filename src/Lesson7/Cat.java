package Lesson7;

public class Cat {

    private final int name;
    private int appetite;
    public Cat(int name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    void info(){
        System.out.println("Кот № " + name + " хочет съесть " + appetite + "кг вискоса");
    }

    public void eat(Plate p) {
        int app = p.decreaseFood(appetite);
        while(app < 0){
            appetite = Math.abs(app);
            System.out.println("Кот не наелся, ему еще нужно съесть " + appetite + "кг вискоса");
            app = p.decreaseFood(appetite);

        }
            appetite = 0;
            System.out.println("Кот наелся!\n" + "В тарелке осталось " + p.getFood() + "кг вискоса");
    }
}
