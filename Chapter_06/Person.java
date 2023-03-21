package Chapter_06;

/**
 * Person
 */
public class Person {

    String name;
    int age;
    int money;

    public Person() {
        this("Don't exist", 0, 0);
    }

    public Person(String name, int age, int money) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public void takeBus(Bus bus) {
        if(this.age < 19 && this.age >= 12)
        {
            checkMoney(this, 1100, bus);
        }
        else if(this.age < 11)
        {
            checkMoney(this, 800, bus);
        }
        else
        {
            checkMoney(this, 1500, bus);
        }
    }

    public void checkMoney(Person name, int money, Bus bus) {
        if(name.money >= money)
        {
            name.money -= money;
            bus.plusMoney(money);
            bus.plusPassenger();
        }
        else
        {
            System.out.println(this.name + "!! Not enough money");
        }
    }

    public void showInfo() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Money : " + money);
    }
}