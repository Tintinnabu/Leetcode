package top.tinn.Top200.Problem_149;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * 149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * @Author Tinn
 * @Date 2020/4/20 16:25
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if(points.length < 3){
            return points.length;
        }
        int k = 0;
        //判断所有点是否都相同的特殊情况
        for (; k < points.length - 1; k++) {
            if (points[k][0] != points[k + 1][0] || points[k][1] != points[k + 1][1]) {
                break;
            }
        }
        if (k == points.length - 1) {
            return points.length;
        }
        boolean[][] used = new boolean[len][len];
       int ret = 0;
        for (int i = 0; i < len; i++){
            int temp = 0;
            for (int j = i + 1; j < len; j++){
                if (Arrays.equals(points[j], points[i]))
                    temp++;
                else if (!used[i][j]){
                    ret = Math.max(ret, temp+getMaxPoints(points, i, j, used));
                }
            }
        }
        return ret;
    }

    private int getMaxPoints(int[][] points, int i, int j, boolean[][] used) {
        used[i][j] = true;
        int count = 2;
        for (int k = j + 1; k < points.length; k++){
            if (Arrays.equals(points[k], points[i]) || Arrays.equals(points[k], points[j])) count++;
            else if (isOnOneLine(points[i], points[j], points[k])){
                used[i][k] = true;
                used[j][k] = true;
                count++;
            }
        }
        return count;
    }

    private boolean isOnOneLine(int[] point, int[] point1, int[] point2) {
        int g1 = gcd(point2[1] - point1[1], point2[0] - point1[0]);
        int g2 = gcd(point2[1] - point[1], point2[0] - point[0]);
        return (point2[1] - point1[1]) / g1 == (point2[1] - point[1]) / g2
                && (point2[0] - point1[0]) / g1 == (point2[0] - point[0]) / g2;
    }

    private int gcd(int a, int b) {
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    @Test
    public void test(){
        int[][] points = new int[6][2];
        points[0] = new int[]{1,1};
        points[1] = new int[]{3,2};
        points[2] = new int[]{5,3};
        points[3] = new int[]{1,1};
        points[4] = new int[]{2,3};
        points[5] = new int[]{1,1};
        System.out.println(maxPoints(points));
    }
}