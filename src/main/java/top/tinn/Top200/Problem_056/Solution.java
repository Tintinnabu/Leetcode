package top.tinn.Top200.Problem_056;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1])
                    return o1[0]-o2[0];
                return o1[1]-o2[1];
            }
        });
        List<int[]> list= Arrays.stream(intervals).collect(Collectors.toList());
        for (int i=1;i<list.size();i++){
            while (i>0&&list.get(i)[0]<=list.get(i-1)[1]){
                list.get(i)[0]=Math.min(list.get(i-1)[0],list.get(i)[0]);
                list.get(i)[1]= Math.max(list.get(i-1)[1],list.get(i)[1]);
                list.remove(i-1);
                i--;
            }
        }
        return list.toArray(new int[][]{});
    }


    @Test
    public void test(){
        int[][] intervals=new int[4][2];
        intervals[0]=new int[]{2,3};
        intervals[1]=new int[]{4,5};
        intervals[2]=new int[]{6,7};
        intervals[3]=new int[]{1,10};
        System.out.println(Arrays.toString(merge(intervals)));;
    }
}
