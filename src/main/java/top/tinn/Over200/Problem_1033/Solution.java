package top.tinn.Over200.Problem_1033;

import java.util.Arrays;

public class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] temp = new int[]{a, b, c};
        Arrays.sort(temp);
        if ( temp[1] == temp[0] + 1 && temp[2] == temp[1] + 1){
            return new int[]{0, 0};
        }else if (temp[2] - temp[1] <= 2 || temp[1] - temp[0] <= 2){
            return new int[]{1, temp[2] - temp[0] - 2};
        }
        return new int[]{2, temp[2] - temp[0] - 2};
    }
}
