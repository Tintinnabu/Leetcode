package top.tinn.NowCoder.Sougou_0925.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Tinn
 * @Date: 2020/9/25 19:43
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 在Interval类中返回结果，其中start表示有效字的个数，end表示全部有效字编号的和除以100000007的余数。
     * @param N int整型 字的总数
     * @param M int整型 连接关系的总数
     * @param conn Interval类一维数组 全部连接关系
     * @return Interval类
     */
    public Interval trim (int N, int M, Interval[] conn) {
        // write code here
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] mark = new boolean[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (Interval interval : conn){
            int from = interval.start;
            int to = interval.end;
            if (!adj.containsKey(from)){
                adj.put(from, new ArrayList<>());
            }
            adj.get(from).add(to);
        }
        //dfs 从0开始，到-1结束
        dfs(adj, mark, 0, new ArrayList<>(), visited);
        int ans = 0;
        int count = 0;
        for (int i = 1; i <= N; i++){
            if (mark[i]){
                ans += i;
                count++;
                ans %= 100000007;
            }
        }
        return new Interval(count, ans);
    }

    private void dfs(Map<Integer, List<Integer>> adj, boolean[] mark, int cur, ArrayList<Integer> path, boolean[] visited) {
        //到达终点
        if (cur == -1){
            for (int p : path){
                mark[p] = true;
            }
            return;
        }
        //无路可走
        if (adj.get(cur) == null || adj.get(cur).size() == 0){
            return;
        }
        //还能继续走
        visited[cur] = true;
        path.add(cur);
        for (int next : adj.get(cur)){
            if (next == -1 || !visited[next]){
                dfs(adj, mark, next, path, visited);
            }
        }
        path.remove(path.size() - 1);
        visited[cur] = false;
    }


    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    @Test
    public void test(){
        int N = 10;
        int M = 14;
        Interval[] intervals = new Interval[M];
        intervals[0] = new Interval(0,1);
        intervals[1] = new Interval(0,2);
        intervals[2] = new Interval(0,3);
        intervals[3] = new Interval(1,4);
        intervals[4] = new Interval(3,4);
        intervals[5] = new Interval(2,6);
        intervals[6] = new Interval(4,5);
        intervals[7] = new Interval(5,6);
        intervals[8] = new Interval(6,7);
        intervals[9] = new Interval(7,8);
        intervals[10] = new Interval(6,9);
        intervals[11] = new Interval(9,10);
        intervals[12] = new Interval(8,-1);
        intervals[13] = new Interval(10,-1);
        Interval ret = trim(N, M, intervals);
        System.out.println(ret);
    }
}
