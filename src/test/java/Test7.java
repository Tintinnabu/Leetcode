
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.function.IntFunction;

/**
 * @Author: Tinn
 * @Date: 2020/9/22 8:54
 */
public class Test7 {

    public void xxx(int a){
        System.out.println(a);
    }

    public void xxx(String b){
        System.out.println(b);
    }
    String x = "abc";

    public static void main(String[] args) throws NoSuchFieldException, ExecutionException, InterruptedException {
        Test7 test7 = new Test7();
        test7.xxx(null);
        int c = 0;
        float d = 0;
        System.out.println(c == d);
        c++;
        d++;
        System.out.println(c == d);
        System.out.println(SubClass.value);
        int[] nums = {1,2,3,4};
        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String t1 = o1 + o2;
                String t2 = o2 + o1;
                return t1.compareTo(t2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : str){
            sb.append(s);
        }
        FutureTask<Integer> futureTask = new FutureTask(new Callable() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }

    static class Class {
        static {
            System.out.println("CLASS");
        }
        public static int value = 5;
    }

    static class SubClass extends Class{
        static {
            System.out.println("SUBCLASS");
        }
    }


}
