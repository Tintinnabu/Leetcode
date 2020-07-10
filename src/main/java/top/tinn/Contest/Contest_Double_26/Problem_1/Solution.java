package top.tinn.Contest.Contest_Double_26.Problem_1;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 22:31
 */
public class Solution {
    public int maxPower(String s) {
        if (s == null){
            return 0;
        }
        if (s.length() < 2){
            return 1;
        }
        int i = 0;
        int ret = 0;
        while (i < s.length()){
            int temp = 1;
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
                temp++;
                i++;
            }
            i++;
            ret = Math.max(ret, temp);
        }
        return ret;
    }

    @Test
    public void test(){
        System.out.println(maxPower("asssssbbbb"));
    }
}
