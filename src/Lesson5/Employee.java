package Lesson5;

class Employee {
    private final String fullName;
    String post;
    String email;
    String tel;
    int salary;
    int age;

    Employee(String fullName, String post, String email, String tel, int salary, int age){
        this.fullName = fullName;
        this.post = post;
        this.email = email;
        this.tel = tel;
        this.salary = salary;
        this.age = age;
    }

    String getFullName() {
        return fullName;
    }

    void printInfo(){
        System.out.println(fullName + " " + post + " Зарплата: " + salary + "р. Возраст: " + age);
    }

}
