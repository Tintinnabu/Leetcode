package top.tinn.Contest_Double_26.Problem_4;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 23:00
 */
public class Solution {
    private int less(String s,String p){
        if(s.length()<p.length()) return -1;
        if(s.length()==p.length()) return s.compareTo(p);
        return 1;
    }
    public String largestNumber(int[] cost, int target) {
        Map<Integer,Integer> dict=new HashMap<>();
        int n=cost.length;
        for(int i=1;i<=n;i++){
            dict.put(cost[i-1],i);
        }
        Map<Integer,String> dp=new HashMap<>();
        dp.put(target,"");
        Queue<Integer> que=new LinkedList<>();
        que.add(target);
        while(!que.isEmpty()){
            int u=que.poll();
            for(int k:dict.keySet()){
                if(k>u) continue;
                int v=dict.get(k);
                if(!dp.containsKey(u-k)||less(dp.get(u-k),dp.get(u)+v)<0){
                    que.add(u-k);
                    dp.put(u-k,dp.get(u)+v);
                }
            }
        }
        if(!dp.containsKey(0)) return "0";
        return dp.get(0);
    }

    @Test
    public void test(){
        int[] cost = {6,10,15,40,40,40,40,40,40};
        int target = 47;
        System.out.println(largestNumber(cost, target));
    }
}
