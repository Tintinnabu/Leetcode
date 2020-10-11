package top.tinn.NowCoder.Youzan_1011.Problem_01;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 19:21
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param A int整型一维数组
     * @param B int整型一维数组
     * @return int整型一维数组
     */
    public int[] fairCandySwap (int[] A, int[] B) {
        // write code here
        int leftSum = 0;
        int rightSum = 0;
        Set<Integer> left = new HashSet<>();
        Set<Integer> right = new HashSet<>();
        for (int a : A){
            leftSum += a;
            left.add(a);
        }
        for (int b : B){
            rightSum += b;
            right.add(b);
        }
        int delta = (leftSum - rightSum) / 2;
        for (int l : left){
            if (right.contains(l - delta)){
                return new int[]{l, l - delta};
            }
        }
        return new int[]{};
    }
}
