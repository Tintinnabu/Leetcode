package top.tinn.Sort.Problem_912._九种排序算法.桶排序;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 16:30
 */
public class Solution {
    private static final int OFFSET = 50000;
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++){
            nums[i] += OFFSET;
        }
        int step = 1000;
        int bucketLen = 10_0000 / step;
        int[][] temp = new int[bucketLen + 1][len];
        //记录每个桶内的数量
        int[] next = new int[bucketLen + 1];

        for (int num : nums){
            int bucketIndex = num / step;
            temp[bucketIndex][next[bucketIndex]] = num;
            next[bucketIndex]++;
        }
        for (int i = 0; i < bucketLen + 1; i++){
            insertSort(temp[i], next[i] - 1);
        }
        // 第 5 步：从桶里依次取出来
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < bucketLen + 1; i++) {
            int curLen = next[i];
            for (int j = 0; j < curLen; j++) {
                res[index] = temp[i][j] - OFFSET;
                index++;
            }
        }
        return res;
    }

    private void insertSort(int[] arr, int endIndex) {
        for (int i = 1; i <= endIndex; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 2, 3, 1, 9, 6, 7, 8};
        int[] res = sortArray(nums);
        System.out.println(Arrays.toString(res));
    }
}
