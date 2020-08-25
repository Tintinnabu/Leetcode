package top.tinn.Contest.Contest_Single_203;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author: Tinn
 * @Date: 2020/8/23 11:08
 */
public class Solution {
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m){
            return m;
        }
        char[] chars = new char[arr.length];
        Arrays.fill(chars, '0');
        int ans = -1;
        for (int i = 0; i < arr.length; i++){
            int index = arr[i] - 1;
            chars[index] = '1';
            if (existTarget(chars, m)){
                ans = i + 1;
            }
        }
        return ans;
    }

    private boolean existTarget(char[] chars, int m) {
        int n = 0;
        int l = 0;
        while (l < chars.length){
            while (l < chars.length && chars[l] == '1'){
                l++;
                n++;
            }
            if (n == m){
                return true;
            }
            while (l < chars.length && chars[l] == '0'){
                l++;
            }
            n = 0;
        }
        return false;
    }

    public int findLatestStep2(int[] arr, int m) {
        int[] dp = new int[arr.length + 1];
        int ans = -1;
        for (int i = 0; i < arr.length; i++){
            int index = arr[i];
            dp[index] = dp[index - 1] + 1;
            while (index + 1 <= arr.length && dp[index + 1] > 0){
                dp[index + 1] = dp[index] + 1;
                if (dp[index] == m){
                    ans = i + 1;
                }
                index++;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int m = 2;
        int[] arr = {3, 5, 1,2,4};
        System.out.println(findLatestStep(arr, 1));
    }
}
