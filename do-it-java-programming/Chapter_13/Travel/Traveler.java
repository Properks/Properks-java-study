package Chapter_13.Travel;

/**
 * Traveler
 */
public class Traveler {

    private String name;
    private int age;

    public Traveler() {
        name = null;
        age = 0;
    }
    
    public Traveler(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", Age : " + age;
    }
}