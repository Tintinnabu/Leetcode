package top.tinn.Contest.Contest_Single_204.Problem_01;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/8/30 10:19
 */
public class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i < arr.length - m + 1; i++){
            if (checked(arr, m, k, i)){
                return true;
            }
        }
        return false;
    }

    private boolean checked(int[] arr, int m, int k, int i) {
        if (arr.length - i < m * k){
            return false;
        }
        for (int modelIndex = i; modelIndex < i + m; modelIndex++){
            int times = k;
            int target = arr[modelIndex];
            while (times > 0){
                if (arr[modelIndex + (times - 1) * m] != target){
                    return false;
                }
                times--;
            }
        }
        return true;
    }

    @Test
    public void test(){
        int[] arr = {1,2,1,2,1,2,1};
        System.out.println(containsPattern(arr, 2, 2));
    }
}
