package top.tinn.Top200.Problem_054;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 通过次数46,645提交次数119,156
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret=new ArrayList<>();
        helper(matrix,0,ret);
        return ret;
    }

    private void helper(int[][] matrix, int i, List<Integer> ret) {
        int row=matrix.length;
        if (row==0||i>matrix.length-1-i||i>matrix[0].length-1-i) return ;
        for (int j=i;j<matrix[0].length-i;j++)
            ret.add(matrix[i][j]);
        for (int j=i+1;j<matrix.length-i;j++)
            ret.add(matrix[j][matrix[0].length-1-i]);
        for (int j=matrix[0].length-2-i;j>=i&&matrix.length-1-i>i;j--)
            ret.add(matrix[matrix.length-1-i][j]);
        for (int j=matrix.length-2-i;j>i&&matrix[0].length-1-i>i;j--)
            ret.add(matrix[j][i]);
        helper(matrix,i+1,ret);
    }

    @Test
    public void test(){
        int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8}};
        System.out.println(spiralOrder(matrix));
    }
}
