package top.tinn.Over200.Problem_1342;

public class Solution {
    public int numberOfSteps (int num) {
        int step = 0;
        while (num != 0){
            if ((num & 1) == 0){
                num >>= 1;
            }else {
                num ^= 1;
            }
            step++;
        }
        return step;
    }
}
