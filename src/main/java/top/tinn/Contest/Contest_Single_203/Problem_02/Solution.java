package top.tinn.Contest.Contest_Single_203.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/8/23 11:01
 */
public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length / 3;
        int ans = 0;
        int i = 0;
        while (n > 0){
            ans += piles[piles.length - 2 - i];
            i += 2;
            n--;
        }
        return ans;
    }

    @Test
    public void test(){
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles));
    }
}

