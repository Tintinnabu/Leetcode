package top.tinn.剑指offer.Interview_66;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 20:32
 */
public class Solution {
    public int[] constructArr(int[] a) {
        int[] right = a.clone();
        for (int i = a.length - 2; i >= 0; i--)
            right[i] *= right[i + 1];
        int temp = 1;
        for (int i = 0; i < a.length; i++){
            if (i == 0) right[i] = right[i + 1];
            else if (i == a.length - 1) right[i] = temp;
            else right[i] = temp * right[i + 1];
            temp *= a[i];
        }
        return right;
    }
}
