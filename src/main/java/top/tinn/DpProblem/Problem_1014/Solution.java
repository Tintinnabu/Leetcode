package top.tinn.DpProblem.Problem_1014;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/17
 */
public class Solution {
    int ans = Integer.MIN_VALUE;
    int preMax = A[0];
        for (int j = 1; j < A.length; j++){
        ans = Math.max(preMax + A[j] - j, ans);
        preMax = Math.max(preMax, A[j] + j);
    }
        return ans;
}
