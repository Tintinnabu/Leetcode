package top.tinn.Contest.Contest_Single_203.Problem_01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Tinn
 * @Date: 2020/8/23 10:46
 */
public class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n];
        int pre = rounds[0];
        int pre2 = rounds[0];
        for (int i = 1; i < rounds.length; i++){
            int cur = rounds[i];
            if (cur == pre2){
                pre += n;
            }else if (pre2 < cur){
                pre += (cur - pre2);
            }else {
                pre += (cur + n - pre2);
            }
            pre2 = cur;
        }
        int k = (pre - rounds[0] + 1) % n;
        int start = rounds[0];
        List<Integer> ans = new ArrayList<>();
        if (k == 0){
            int ii = 1;
            while (ii <= n){
                ans.add(ii++);
            }
            return ans;
        }
        while (k > 0){
            ans.add((start - 1) % n + 1);
            start++;
            k--;
        }
        Collections.sort(ans);
        return ans;
    }

    @Test
    public void test(){
        int[] rounds = {1,3,1,2};
        int n = 4;
        System.out.println(mostVisited(n, rounds));
    }
}
