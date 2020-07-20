import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

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
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
        int i1=0;
        Integer j1 = new Integer(0);
        System.out.println(i1==j1);
        Object o = new Object();
        long a = 123L;
        try {
            URL u =new URL("http://www.123.com"); System.out.println(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {

        }

        PrintWriter out = new PrintWriter(
                new java.io.OutputStreamWriter(System.out), true);
        StringBuilder sb = new StringBuilder();
        StringBuffer s1=new StringBuffer(10);s1.append("1234");
        System.out.println(s1.length());
        System.out.println(s1.capacity());
        byte b1=1,b2=2,b3,b6,b8;
        final byte b4=4,b5=6,b7;
        //b3=(b1+b2);  /*语句1*/
        b6=b4+b5;    /*语句2*/
        //b8=(b1+b4);  /*语句3*/
        //b7=(b2+b5);  /*语句4*/
        //System.out.println(b3+b6);

    }

    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized(Thread.currentThread())
        {
            obj.wait();
            obj.notify();
        }
    }

}
