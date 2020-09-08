package top.tinn.NowCoder.Bilibili_0904.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Tinn
 * @Date: 2020/9/4 19:23
 */
public class Solution {
    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1;
        int u = 0, d = matrix.length - 1;

        while (l <= r && u <= d){
            //从l到r扫描u
            for (int i = l; i <= r; i++){
                ans.add(matrix[u][i]);
            }
            u++;
            if (u > d){
                break;
            }
            for (int i = u; i <= d; i++){
                ans.add(matrix[i][r]);
            }
            r--;

            if (l > r){
                break;
            }
            for (int i = r; i >= l; i--){
                ans.add(matrix[d][i]);
            }
            d--;
            if (u > d){
                break;
            }
            for (int i = d; i >= u; i--){
                ans.add(matrix[i][l]);
            }
            l++;

        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void test(){
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1,2,3,4};
        matrix[1] = new int[]{5,6,7,8};
        matrix[2] = new int[]{9,10,11,12};
        System.out.println(Arrays.toString(SpiralMatrix(matrix)));
    }
}
