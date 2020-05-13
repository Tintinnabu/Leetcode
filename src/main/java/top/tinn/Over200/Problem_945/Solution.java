package top.tinn.Over200.Problem_945;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/11 21:02
 */
public class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int moves = 0;
        for (int i = 1; i < A.length; i++){
            if (A[i] <= A[i - 1]){
                moves += (A[i - 1] - A[i] + 1);
                A[i] = A[i - 1] + 1;
            }
        }
        return moves;
    }

    private int[] pos = new int[80000];
    public int minIncrementForUnique2(int[] A) {
        Arrays.fill(pos, -1); // -1表示空位
        int move = 0;
        // 遍历每个数字a对其寻地址得到位置b, b比a的增量就是操作数。
        for (int a: A) {
            int b = findPos(a);
            move += b - a;
        }
        return move;
    }

    private int findPos(int a) {
        int b = pos[a];
        // 如果a对应的位置pos[a]是空位，直接放入即可。
        if (b == -1) {
            pos[a] = a;
            return a;
        }
        // 否则向后寻址
        // 因为pos[a]中标记了上次寻址得到的空位，因此从pos[a]+1开始寻址就行了（不需要从a+1开始）。
        b = findPos(b + 1);
        pos[a] = b;
        return b;
    }
}
