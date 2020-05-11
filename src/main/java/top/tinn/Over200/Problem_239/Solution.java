package top.tinn.Over200.Problem_239;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * @Author Tinn
 * @Date 2020/4/18 13:25
 */
public class Solution {
    private ArrayDeque<Integer> deque = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            if (i < k - 1){
                pushNum(nums[i]);
            }else {
                pushNum(nums[i]);
                res[i -  k + 1] = deque.getFirst();
                popNum(nums[i - k + 1]);
            }
        }
        return res;
    }

    private void popNum(int num) {
        if (!deque.isEmpty() && deque.getFirst() == num)
            deque.pollFirst();
    }

    private void pushNum(int num) {
        while (!deque.isEmpty() && deque.getLast() < num)
            deque.pollLast();
        deque.addLast(num);
    }

    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
