package Lesson5;

public class Lesson5 {
    public static void main(String[] args){

        Employee[] employee = {
                new Employee(
                        "Ivanov Ivan",
                        "Engineer",
                        "ivivan@mailbox.com",
                        "892312312",
                        30000,
                        41),
                new Employee(
                        "Petrov Igor",
                        "Тракторист",
                        "Petr@mailbox.com",
                        "892332548",
                        25000,
                        25),
                new Employee(
                        "Sidorova Elena",
                        "Доярка",
                        "sido@mailbox.com",
                        "892325482",
                        15000,
                        18),
                new Employee(
                        "Baranov Alex",
                        "Пастух",
                        "barAlex@mailbox.com",
                        "892354821",
                        28000,
                        53),
                new Employee(
                        "Putin Vladimir",
                        "President",
                        "http://www.letters.kremlin.ru/letters/send",
                        "8 495 606 36 02",
                        0,
                        69)
        };

        int minYear = 40;
        for(Employee ages : employee) {
            if (ages.age > minYear){
                if (ages.getFullName().equals("Putin Vladimir")){
                    System.out.println("Президента не трогаем!!!"
                            + "\nПо всем вопросам обращайтесь по тел: " + ages.tel
                            + "\nИли напишите письмо по адресу:\n" + ages.email);
                }else ages.printInfo();
            }
        }
    }
}
