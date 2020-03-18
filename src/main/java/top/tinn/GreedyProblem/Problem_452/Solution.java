package top.tinn.GreedyProblem.Problem_452;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int findMinArrowShots(int[][] intervals) {
        int size=intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]!=o2[1])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        double pre=-Double.MAX_VALUE;
        int maxIntervals=0;
        for (int i=0;i<size;i++){
            if (intervals[i][0]>pre){
                maxIntervals++;
                pre=intervals[i][1];
            }
        }
        return maxIntervals;
    }
}
