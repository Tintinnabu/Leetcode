package top.tinn.Over200.Problem_905;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0, r = A.length - 1, k = 0;
        while (k < r){
            if ((A[k] & 1) == 0){
                swap(A, l, k);
                l++;
                k++;
            }else {
                swap(A, r, k);
                r--;
            }
        }
        return A;
    }

    private void swap(int[] a, int r, int k) {
        int temp = a[r];
        a[r] = a[k];
        a[k] = temp;
    }

    @Test
    public void test(){
        int[] nums = {3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }
}
