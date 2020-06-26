package top.tinn.InterviewProblem.面试题01_04;

public class Solution {
    public boolean canPermutePalindrome(String s) {
        boolean[] cnt = new boolean[128];
        for (char c : s.toCharArray()){
            cnt[c] = !cnt[c];
        }
        int count = 0;
        for (int i = 0; i < cnt.length; i++){
            if (cnt[i]){
                count++;
            }if (count > 1){
                return false;
            }
        }
        return true;
    }
}
