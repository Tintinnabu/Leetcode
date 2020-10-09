package top.tinn.NowCoder.Sougou_0925.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/25 19:33
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回一行字符串，表示原文。
     * @param s1 string字符串一维数组 N*N的01矩阵，表示解密纸，0表示透明，1表示涂黑
     * @param s2 string字符串一维数组 字符矩阵，表示密文
     * @return string字符串
     */
    public String rotatePassword (String[] s1, String[] s2) {
        // write code here
        int N = s1.length;
        List<int[]> zuobiao = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (s1[i].charAt(j) == '0'){
                    zuobiao.add(new int[]{i, j});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++){
            Collections.sort(zuobiao, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]){
                        return o1[1] - o2[1];
                    }
                    return o1[0] - o2[0];
                }
            });
            for (int[] zb : zuobiao){
                int x = zb[0];
                int y = zb[1];
                sb.append(s2[x].charAt(y));
                zb[0] = y;
                zb[1] = N - 1 - x;
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String[] s1 = {"1101","1010","1111","1110"};
        String[] s2 = {"ABCD","EFGH","IJKL","MNPQ"};
        System.out.println(rotatePassword(s1, s2));
        System.out.println("CFHQGLMPAIKNBDEJ");
    }
}
