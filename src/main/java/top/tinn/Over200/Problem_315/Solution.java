package top.tinn.Over200.Problem_315;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName solution
 * @Description
 * 315. 计算右侧小于当前元素的个数
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * 示例:
 *
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * @Author Tinn
 * @Date 2020/4/20 10:05
 */
public class Solution {
    private int[] indexes;
    private int[] counter;
    private int[] temp;
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        if (len == 0) return new ArrayList<>();
        temp = new int[len];
        counter = new int[len];
        indexes = new int[len];
        for (int i = 0; i < len; i++)
            indexes[i] = i;
        mergeAndCountSmaller(nums, 0, len - 1);
        return Arrays.stream(counter).boxed().collect(Collectors.toList());
    }

    /**
     * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
     * @param nums
     * @param l
     * @param r
     */
    private void mergeAndCountSmaller(int[] nums, int l, int r){
        if (l == r) return;
        int mid = l + (r - l) / 2;
        mergeAndCountSmaller(nums, l, mid);
        mergeAndCountSmaller(nums, mid + 1, r);
        // 归并排序的优化，同样适用于该问题
        // 如果索引数组有序，就没有必要再继续计算了
        if (nums[indexes[mid]] > nums[indexes[mid + 1]]){
            mergeOfTwoSortedArrAndCountSmaller(nums, l, mid, r);
        }
    }

    /**
     * [l, mid] 是排好序的
     * [mid + 1, r] 是排好序的
     *
     * @param nums
     * @param l
     * @param mid
     * @param r
     */
    private void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int mid, int r) {
        //3, 4  1, 2
        for (int i = l; i <= r; i++)
            temp[i] = indexes[i];
        int i = l;
        int j = mid + 1;
        // 左边出列的时候，计数
        for (int k = l; k <= r; k++){
            if (i > mid){
                indexes[k] = temp[j++];
            }else if (j > r){
                indexes[k] = temp[i++];
                // 此时 j 用完了，[7,8,9 | 1,2,3]
                // 之前的数就和后面的区间长度构成逆序
                counter[indexes[k]] += (r - mid);
            }else if (nums[temp[i]] <= nums[temp[j]]){
                indexes[k] = temp[i++];
                counter[indexes[k]] += (j - mid - 1);
            }else {
                indexes[k] = temp[j++];
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller(nums));
    }
}
