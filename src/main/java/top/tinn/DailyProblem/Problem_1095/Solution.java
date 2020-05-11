package top.tinn.DailyProblem.Problem_1095;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/29 21:35
 */
public class Solution {
    private int ret = -1;
    public int findInMountainArray(int target, MountainArray mountainArr) {

        int len = mountainArr.length();
        int l = 0, r = len - 1;
        helper(target, mountainArr, l, r);
        return ret;
    }

    public void helper(int target, MountainArray mountainArray, int l, int r){
        if (l > r || ret != -1) return;
        if (l == r) {
            ret = mountainArray.get(l) == target ? l : -1;
            return;
        }
        int mid = l + (r-l)/2;
        int midVal = mountainArray.get(mid);
        if (midVal == target) {
            helper(target, mountainArray, l, mid - 1);
            if (ret == -1) {
                ret = mid;
                return;
            }
        }
        if (midVal > target){
            helper(target, mountainArray, l, mid - 1);
            helper(target, mountainArray, mid + 1, r);
        }else if (mountainArray.get(mid + 1) > midVal){
            helper(target, mountainArray, mid + 1, r);
        }else helper(target, mountainArray, l, mid - 1);
    }

    @Test
    public void test(){
        System.out.println(findInMountainArray(3, new MountainArray() {
            int[] arr = {0,2,3,5,3};
            @Override
            public int get(int index) {
                return arr[index];
            }

            @Override
            public int length() {
                return arr.length;
            }
        }));
    }
}
