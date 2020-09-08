package top.tinn.NowCoder.Bilibili_0904.Problem_01;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/9/4 19:44
 */
public class Solution {
    int maxLen = 0;
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        int numOfZeros = 0;
        for (int a : arr){
            if (a == 0){
                numOfZeros++;
            }
        }
        if (numOfZeros <= k){
            return arr.length;
        }
        dfs(arr, 0, k);
        return maxLen;
    }

    private void dfs(int[] arr, int i, int k) {
        if (k == 0 || i == arr.length){
            maxLen = Math.max(maxLen, getConsecutiveOnes(arr));
            return;
        }
        if (arr[i] == 1){
            dfs(arr, i + 1, k);
        }else {
            arr[i] = 1;
            dfs(arr, i + 1, k - 1);
            arr[i] = 0;

            dfs(arr, i + 1, k);
        }
    }

    private int getConsecutiveOnes(int[] arr) {
        int max = 0;
        int i = 0;
        while (i < arr.length){
            while (i < arr.length && arr[i] == 0){
                i++;
            }
            int len = 0;
            while (i < arr.length && arr[i] == 1){
                len++;
                i++;
            }
            max = Math.max(max, len);
        }
        return max;
    }

    @Test
    public void test(){
        System.out.println(GetMaxConsecutiveOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}
