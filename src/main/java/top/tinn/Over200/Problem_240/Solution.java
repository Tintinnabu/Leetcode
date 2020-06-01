package top.tinn.Over200.Problem_240;

import org.junit.jupiter.api.Test;

/**
 * 240. 搜索二维矩阵 II
 *
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row=matrix.length-1;
        int column=0;
        while (row>=0&&column<matrix[0].length){
            if(matrix[row][column]>target)row--;
            else if(matrix[row][column]<target) column++;
            else return true;
        }
        return false;
    }

    @Test
    public void test(){
        int[][] matrix=new int[5][5];
        matrix[0]=new int[]{1,4,7,11,15};
        matrix[1]=new int[]{2,5,8,12,19};
        matrix[2]=new int[]{3,6,9,16,22};
        matrix[3]=new int[]{10,13,14,17,24};
        matrix[4]=new int[]{18,21,23,26,30};

        System.out.println(searchMatrix2(matrix,5));
    }
}
