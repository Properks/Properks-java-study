package Chapter_06;

/**
 * Person
 */
public class Person {

    String name;
    int age;

    public Person() {
        this("Don't exist", 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printData() {
        System.out.println("Name : " + this.name);
        System.out.println("Age : " + this.age);
    }
}