package programs;

public class JavaTest {
    public static void main(String[] args) {

        String s = new String("ro");
        String s1 = "ro";
        System.out.println(s == s1);  //false

        String s6 = "ro";
        String s7 = new String("ro");
        System.out.println(s6 == s7); //false

        String s4 = "ro";
        String s5 = "ro";
        System.out.println(s4 == s5); //true


    }
}
