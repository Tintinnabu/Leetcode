package top.tinn.Top200.Problem_057;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 57. 插入区间
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }
        int[] temp = newInterval.clone();
        while (i < intervals.length && newInterval[1] >= intervals[i][0]){
            temp[0] = Math.min(temp[0], intervals[i][0]);
            temp[1] = Math.max(temp[1], intervals[i][1]);
            i++;
        }
        res.add(temp);
        while (i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[0][0]);
    }


    @Test
    public void test(){
        //int[][] intervals=new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] intervals = new int[][]{{1,5}};
        //int[] newInterval={4,8};
        int[] newInterval = {2,7};
        System.out.println(insert(intervals,newInterval));
    }
}
