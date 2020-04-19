package top.tinn.Problem_202;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:07
 */
public class Solution {

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do{
            slow = cal(slow);
            fast = cal(fast);
            fast = cal(fast);
        }while(slow != fast);
        return slow == 1;
    }

    private int cal(int n) {
        int ret = 0;
        while (n > 0){
            int temp = n % 10;
            n /= 10;
            ret += Math.pow(temp, 2);
        }
        return ret;
    }

    @Test
    public void test(){
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 1; i <= 100; i++){
            map.put(i, isHappy(i));
            if (isHappy(i)) System.out.println(i);
        }
        //System.out.println(isHappy(2));
    }
}
