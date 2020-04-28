import java.util.Map;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class Test {
    protected int num;
    public Test(){this.num=100;}

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        String s="sss";
        Vector v=new Vector<>();
        Map<String,Integer> map=new ConcurrentHashMap<>();
    }
}

class Test2 extends Test{
    private int num2;
    public Test2(){
        this.num2=1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Test2 && ((Test2) obj).num2 == num2;
    }

    public static void main(String[] args) {
        Test2 test2=new Test2();
        Test2 test3=new Test2();
        System.out.println(test2.equals(test3));
        /*Stack<Integer> stack = new Stack<>();
        stack.push(null);*/
    }
}

