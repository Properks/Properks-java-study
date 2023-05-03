package Chapter_15;

import java.io.Console;
import java.util.Arrays;

/**
 * Java_Input_Output
 */
public class Java_Input_Output {

    public static void main(String[] args) {
        String ID;
        char[] password;
        char[] temp;

        Console console = System.console();// In order to close
        System.out.println("Enter a ID : ");
        ID = console.readLine();

        System.out.println("Enter a password (more than 8): ");
        password = console.readPassword();
        
        System.out.println("Enter a password one more : ");
        temp = console.readPassword();

        try {
            if (!Arrays.equals(password, temp)) {
                throw new Exception("Password entered first and second isn't same");
            }
            else if (password.length < 8) {
                throw new Exception("Password is less than 8");
            }
            System.out.println("Create account successfully");
            System.out.println("Entered ID is " + ID);
        } catch(Exception e) {
            e.printStackTrace();
            System.out.print("Password entered first is ");
            for (int i = 0; i < password.length; i++) {
                System.out.print((i == password.length - 1) ? password[i] + "\n" : password[i]);
            }
            System.out.print("Password entered second is ");
            for (int i = 0; i < temp.length; i++) {
                System.out.print((i == temp.length - 1) ? temp[i] + "\n" : temp[i]);
            }
        }
    }
}