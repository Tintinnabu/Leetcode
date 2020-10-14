/**
 * @Author: Tinn
 * @Date: 2020/10/12 11:11
 */
public class Test8 {
    public static void main(String[] args) {
        Test8 test8 = new Test8();
        System.out.println(test8.test(1));
    }

    public int test(int i){
        try {
            ++i;
            return i++;
        }finally {
            ++i;
            //return i++;
        }
    }
}
