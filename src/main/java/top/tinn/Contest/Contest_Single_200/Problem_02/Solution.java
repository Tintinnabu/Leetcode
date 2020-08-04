package top.tinn.Contest.Contest_Single_200.Problem_02;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length - 1){
            int max = 0;
            for (int a : arr){
                max = Math.max(max, a);
            }
            return max;
        }
        int count = 0;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > pre){
                pre = arr[i];
                count = 1;
            }else{
                count++;
            }
            if (count == k){
                break;
            }
        }
        return pre;
    }
}
