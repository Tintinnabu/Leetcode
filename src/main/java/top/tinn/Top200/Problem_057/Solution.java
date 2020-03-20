package top.tinn.Top200.Problem_057;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
        if (intervals.length==0) return new int[][]{newInterval};
        List<int[]> list=new ArrayList<>();
        boolean flag=false;
        for (int[] itvl:intervals){
            if ((itvl[1]>=newInterval[0]&&itvl[0]<newInterval[1])||(itvl[0]<=newInterval[1]&&newInterval[0]<itvl[1])){
                flag=true;
                newInterval[0]=Math.min(itvl[0],newInterval[0]);
                newInterval[1]=Math.max(itvl[1],newInterval[1]);
            }else {
                if (flag) {
                    list.add(newInterval);
                    flag=false;
                }
                list.add(itvl);
            }
        }
        return list.toArray(new int[][]{});
    }


    @Test
    public void test(){
        int[][] intervals=new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval={4,8};
        System.out.println(insert(intervals,newInterval));
    }
}
