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
            checkMoney(this, bus.fee[1], bus);
        }
        else if(this.age < 11)
        {
            checkMoney(this, bus.fee[2], bus);
        }
        else
        {
            checkMoney(this, bus.fee[0], bus);
        }
    }

    public void checkMoney(Person name, int fee, Bus bus) {
        if(name.money >= fee)
        {
            name.money -= fee;
            bus.plusMoney(fee);
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