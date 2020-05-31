package top.tinn.Contest_Double_27.Problem_01;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/30 22:31
 */
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int ret = 0;
        for (int n : target){
            ret ^= n;
        }
        for (int n : arr){
            ret ^= n;
        }
        return ret == 0;
    }
}
