package Chapter_07;

/**
 * Array
 */
public class Array {

    public static void main(String[] args) {
        int[] data = new int[10];
        char[] alphabet = new char[26];
        char ch = 'A';

        for (int i = 0; i < data.length; i++) { // input number
            data[i] = i;
        }
        
        for (int j = 0; j < data.length; j++) { // print number
            System.out.print(data[j]);
        }
        System.out.println();

        for (int k = 0; k < alphabet.length; k++) { // input alphabet
            alphabet[k] = ch++;
        }

        for (int l = 0; l < alphabet.length; l++) { // print alphabet
            System.out.print(alphabet[l]);
        }
        System.out.println();
    }
}