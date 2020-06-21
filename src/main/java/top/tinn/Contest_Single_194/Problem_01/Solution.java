package top.tinn.Contest_Single_194.Problem_01;

public class Solution {
    public int xorOperation(int n, int start) {
        int ans = start;
        for (int i = 1; i < n; i++){
            ans ^= (start + 2 * i);
        }
        return ans;
    }
}
