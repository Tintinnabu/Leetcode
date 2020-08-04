package top.tinn.Contest.Contest_Single_199.Problem_02;

public class Solution {
    public int minFlips(String target) {
        char c = '0';
        int ans = 0;
        for (char cc : target.toCharArray()) {
            if (c != cc) {
                ans++;
                c = cc;
            }
        }
        return ans;
    }
}
