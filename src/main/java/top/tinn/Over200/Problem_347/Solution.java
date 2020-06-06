package top.tinn.Over200.Problem_347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/6 12:01
 */
public class Solution {
    //计数+固定长度单调递增队列
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        int i = 0;
        for (int key : map.keySet()){
            if (queue.size() < k){
                queue.add(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.add(key);
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
