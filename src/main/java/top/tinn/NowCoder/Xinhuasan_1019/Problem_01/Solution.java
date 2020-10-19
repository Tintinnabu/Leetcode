package top.tinn.NowCoder.Xinhuasan_1019.Problem_01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: Tinn
 * @Date: 2020/10/19 20:23
 */
public class Solution {
    int max = 99;
    int min = 1000;
    public int sub (String input) {
        // write code here
        String[] str = input.split(" ");
        dfs(str, new ArrayList<>(), new boolean[6]);
        if (max == 99 || min == 1000){
            return -1;
        }
        return max - min;
    }

    private void dfs(String[] str, ArrayList<String> temp, boolean[] used) {
        if (temp.size() == 3){
            Integer dig = Integer.parseInt(String.join("", temp));
            if (dig < 100) return;
            if (dig > max){
                max = dig;
            }else if (dig < min){
                min = dig;
            }
            return;
        }
        for (int i = 0; i < 6; i++){
            if (used[i]) continue;
            used[i] = true;
            temp.add(str[i]);
            dfs(str, temp, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    @Test
    public void test(){
        //System.out.println(sub("1 0 3 5 2 7"));
        System.out.println(sub("0 0 0 1 0 0"));
    }
}
