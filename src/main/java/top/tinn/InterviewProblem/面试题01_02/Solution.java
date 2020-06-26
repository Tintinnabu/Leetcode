package top.tinn.InterviewProblem.面试题01_02;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()){
            return false;
        }
        int[] cnt = new int[128];
        for (char c : s1.toCharArray()){
            cnt[c]++;
        }
        for (char c : s2.toCharArray()){
            if (cnt[c] < 1){
                return false;
            }
            cnt[c]--;
        }
        return true;
    }
}
