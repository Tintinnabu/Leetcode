import java.io.BufferedReader;
import java.net.URL;
import java.util.*;

public class Test4 {
    int a = '2';
    char s = '\u0639';
    Object o = 'f';
    String ss = "helloworld\0";
    Double d = 100d;
    //final int i;
    int j;
    int _123;
    static {
        int x = 5;
    }
    public static Test4 t1 = new Test4();
    {
        System.out.println("blockA");
    }
    static
    {
        System.out.println("blockB");
    }
    public static void main(String[] args)
    {
        Test4 t2 = new Test4();
        System.out.println(-12 % -5);
        //URL url = new URL("http://www.123.com");
        char chr = 127;
        int sum = 200;
        chr += 1;
        System.out.println(sum + chr);
        String s;
        //System.out.println(s);
        
    }

}
