package top.tinn.Contest.Contest_Single_202.Problem_01;

/**
 * @Author: Tinn
 * @Date: 2020/8/16 10:31
 */
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++){
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1){
                return true;
            }
        }
        return false;
    }
}
