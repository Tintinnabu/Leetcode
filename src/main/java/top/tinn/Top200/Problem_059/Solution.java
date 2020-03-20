package top.tinn.Top200.Problem_059;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 59. 螺旋矩阵 II
 *
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ret=new int[n][n];
        helper(ret,0,1,n);
        return ret;
    }

    private void helper(int[][] matrix, int i,int n,int target) {
        if (n>target*target) return ;
        for (int j=i;j<matrix[0].length-i;j++)
            matrix[i][j]=n++;
        for (int j=i+1;j<matrix.length-i;j++)
            matrix[j][matrix[0].length-1-i]=n++;
        for (int j=matrix[0].length-2-i;j>=i&&matrix.length-1-i>i;j--)
            matrix[matrix.length-1-i][j]=n++;
        for (int j=matrix.length-2-i;j>i&&matrix[0].length-1-i>i;j--)
            matrix[j][i]=n++;
        helper(matrix,i+1,n,target);
    }


    @Test
    public void test(){
        int[][] ret=generateMatrix(1);
        System.out.println(ret);
    }
}
