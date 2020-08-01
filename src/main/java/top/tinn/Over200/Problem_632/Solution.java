package top.tinn.Over200.Problem_632;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int N = 0;
        for (List<Integer> num : nums){
            N += num.size();
        }
        int[][] ordered = new int[N][2];
        int i =0, j = 0;
        for (List<Integer> group : nums){
            for (Integer num : group){
                ordered[i][0] = num;
                ordered[i][1] = j;
                i++;
            }
            j++;
        }
        Arrays.sort(ordered, (o1, o2) -> (o1[0] - o2[0]));
        int[] ans = new int[2];
        int[] count = new int[nums.size()];
        int k = 0;
        i = 0;
        //向右移动边界，增大右边界
        for (j = 0; j < N; j++){
            if (count[ordered[j][1]]++ == 0){
                k++;
            }
            //找到右边界
            if (k == nums.size()){
                //移动左边界：当左边界count > 1时，向右滑动
                while (count[ordered[i][1]] > 1){
                    count[ordered[i++][1]]--;
                }
                if((ans[0] == 0 && ans[1] == 0 )|| ans[1] - ans[0] > ordered[j][0] - ordered[i][0]){
                    ans = new int[]{ordered[i][0],ordered[j][0]};
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        List<List<Integer>> nums = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>(Arrays.asList(4,10,15,24,26));
        List<Integer> num2 = new ArrayList<>(Arrays.asList(0,9,12,20));
        List<Integer> num3 = new ArrayList<>(Arrays.asList(5,18,22,30));
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        System.out.println(Arrays.toString(smallestRange(nums)));
    }
}
