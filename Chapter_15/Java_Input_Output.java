package Chapter_15;

import java.util.Scanner;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {
        String name;
        int age;
        double grade;

        try (Scanner scanner = new Scanner(System.in)) { // In order to close
            System.out.println("Enter a name : ");
            name = scanner.nextLine();

            System.out.println("Enter a age : ");
            age = scanner.nextInt();

            System.out.println("Enter a grade(0.0 ~ 4.5) : ");
            grade = scanner.nextDouble();
        }

        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
        System.out.println("Grade : " + grade);
    }
}