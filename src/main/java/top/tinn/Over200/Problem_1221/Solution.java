package top.tinn.Over200.Problem_1221;

public class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0, cur = 0;
        for (char c : s.toCharArray()){
            if (c == 'L'){
                cur++;
            }else {
                cur--;
            }
            if (cur == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
