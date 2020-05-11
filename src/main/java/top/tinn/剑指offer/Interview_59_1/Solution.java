package top.tinn.剑指offer.Interview_59_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/6 20:03
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++){
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < n; i++){
            if (deque.peekFirst() == nums[i - k]) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) deque.pollLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
