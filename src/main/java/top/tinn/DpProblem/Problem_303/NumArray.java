package top.tinn.DpProblem.Problem_303;

import org.junit.jupiter.api.Test;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray {
    private int[] sumArray;
    public NumArray(int[] nums) {
        sumArray=new int[nums.length];
        int sum=0;
        for (int i=0;i<sumArray.length;i++){
            sum+=nums[i];
            sumArray[i]=sum;
        }
    }

    public int sumRange(int i, int j) {
        return i==0?sumArray[j]:sumArray[j]-sumArray[i-1];
    }

    public static void main(String[] args) {
        int[] nums=new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray=new NumArray(nums);
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));

    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
