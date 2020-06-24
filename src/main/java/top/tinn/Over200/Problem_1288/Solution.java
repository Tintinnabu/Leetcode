package top.tinn.Over200.Problem_1288;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0])
                .thenComparing((int[] a) -> a[1]).reversed());
        int pre = 0;
        int remain = intervals.length;
        for (int i = 0 ; i < intervals.length; i++){
            if (i == 0){
                pre = intervals[0][1];
            }else if (intervals[i][1] <= pre ){
                remain--;
            }else {
                pre = intervals[i][1];
            }
        }
        return remain;
    }
}
