package top.tinn.BitProblem.Problem_405;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/15 16:39
 */
public class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'a','b','c','d','e','f'};
        if (num == 0) return "0";
        while (num != 0 && sb.length()<8){
            int temp = (num & 15);
            num >>=4;
            if (temp<10) sb.append(temp);
            else sb.append(chars[temp - 10]);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        System.out.println(toHex(26));
        System.out.println(toHex(-1));
    }
}
