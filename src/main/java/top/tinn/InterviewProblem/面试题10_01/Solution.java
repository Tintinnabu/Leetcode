package top.tinn.InterviewProblem.面试题10_01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 16:45
 */
public class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (k >= 0){
            if (i < 0) {
                A[k--] = B[j--];
                continue;
            }
            if (j < 0) {
                A[k--] = A[i--];
                continue;
            }
            if (A[i] <= B[j]) A[k--] = B[j--];
            else A[k--] = A[i--];
        }
    }

    @Test
    public void test(){
        int[] A = {1,2,3,0,0,0};
        int[] B = {2,5,6};
        merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
}
