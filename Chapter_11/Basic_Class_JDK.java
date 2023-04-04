package Chapter_11;

/**
 * Basic_Class_JDK
 */
public class Basic_Class_JDK {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        String str1 = new String("Java");
        String str2 = new String("programming");

        System.out.println("==========Using concat==========");
        System.out.println("Hashcode of str1 before using concat (str1 : " + str1 + ") : " + System.identityHashCode(str1));
        str1 = str1.concat(" " + str2);
        // str1 = str1 + str2;
        System.out.println("Hashcode of str1 after using concat (str1 : " + str1 + ") : " + System.identityHashCode(str1) + "\n");
        //Make another memory and change address of str1

        StringBuilder buffer = new StringBuilder(str1);
        System.out.println("==========Using StringBuilder==========");
        System.out.println("Hashcode of str1 before using Stringbuilder (str1 : " + str1 + ") : " + System.identityHashCode(str1));
        buffer.append(" is" + " easy");
        System.out.println("Hashcode of str1 after using Stringbuilder (str1 : " + str1 + ") : " + System.identityHashCode(str1));
        System.out.println("Hashcode of str1 after using Stringbuilder (buffer : " + buffer + ") : " + System.identityHashCode(buffer) + "\n");
        // Doesn't change address of memory
        
        //If you wanna cut string
        String newstr1 = str1.replace(str2, "program");
        String newstr2 = str1.substring(0, 4);// endindex is number of string, not real index 

        System.out.println("==========Using replace and substring==========");
        System.out.println("replace(str2, \"program\") of str1 : " + newstr1);
        System.out.println("Substring(0,3) of str1 : " + newstr2);

    }
}