package top.tinn.InterviewProblem.面试题16_11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[0];
        }
        if (shorter == longer){
            return new int[]{shorter * k};
        }
        int[] ans = new int[k + 1];
        for (int i = 0; i <= k; i++){
            int temp = i * longer + (k - i) * shorter;
            ans[i] = temp;
        }
        return ans;
    }
}
