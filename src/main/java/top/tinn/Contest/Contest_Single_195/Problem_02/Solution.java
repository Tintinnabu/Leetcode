package top.tinn.Contest.Contest_Single_195.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int sum = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            arr[i] %= k;
            if (arr[i] < 0){
                arr[i] = (arr[i] + k) % k;
            }
            if (arr[i] == 0){
                cnt++;
            }
        }
        if (sum % k != 0 || cnt % 2 == 1){
            return false;
        }
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l < r){
            if (arr[l] == 0){
                l++;
                continue;
            }else if (arr[r] == 0){
                r--;
                continue;
            }
            int temp = arr[l] + arr[r];
            if (temp % k != 0){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Test
    public void test(){
        int[] arr = {-10, 10};
        int k = 2;
        System.out.println(canArrange(arr, k));
    }
}
