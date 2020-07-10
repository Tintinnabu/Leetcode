package top.tinn.Contest.Contest_Single_194.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.*;


public class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> registries = new HashMap<>(n);
        int[] next = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            //next[i]为下次次装满rains[i]的日期索引,若不存在,则记为n
            next[i] = registries.getOrDefault(rains[i], n);
            registries.put(rains[i], i);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<Rain> pq = new PriorityQueue<>((a, b)->(a.day -  b.day));
        for (int i = 0; i < n; i++){
            if (rains[i] == 0){
                if (pq.size() == 0){
                    ans[i] = 1;
                }else{
                    ans[i] = pq.remove().index;
                }
            }else{
                Rain rain = new Rain();
                rain.index = rains[i];
                rain.day = next[i];
                pq.add(rain);
            }
            if (!pq.isEmpty() && pq.peek().day <= i){
                return new int[0];
            }
        }
        return ans;
    }

    private class Rain{
        int index;
        int day;
    }

    @Test
    public void test(){
        int[] rains = {1,2,0,0,1,2};
        System.out.println(Arrays.toString(avoidFlood(rains)));
    }
}
