package top.tinn.剑指offer.Interview_29;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/7 19:54
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, idx = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            for (int i = l; i <= r; i++) res[idx++] = matrix[t][i];
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[idx++] = matrix[i][r];
            if (l > --r) break;
            for (int i = r; i >= l; i--) res[idx++] = matrix[b][i];
            if (t > --b) break;
            for (int i = b; i >= t; i--) res[idx++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }

    private void printOneCircle(int[][] matrix, int start, List<Integer> res) {
        for (int i = start; i < matrix[0].length - start; i++)
            res.add(matrix[start][i]);
        if (start < matrix.length - start - 1){
            for (int j = start + 1; j < matrix.length - start; j++)
                res.add(matrix[j][matrix[0].length - start - 1]);
            if (start < matrix[0].length - start - 2){
                for (int i = matrix[0].length - start - 2; i >= start; i--)
                    res.add(matrix[matrix.length - start - 1][i]);
                for (int j = matrix.length - start - 2; j >= start + 1; j--)
                    res.add(matrix[j][start]);
            }

        }

    }
}
