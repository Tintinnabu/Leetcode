package top.tinn.Contest.Contest_Single_198.Problem_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    int[] res;
    boolean[] visited;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<Integer>[] points = new List[n];
        int[] ls = new int[n];
        for (int i = 0; i < n; i++){
            points[i] = new ArrayList<>();
            ls[i] = labels.charAt(i) - 'a';
        }
        for (int[] edge : edges){
            points[edge[0]].add(edge[1]);
            points[edge[1]].add(edge[0]);
        }
        res = new int[n];
        visited = new boolean[n];
        visited[0] = true;
        dfs(0, points, ls);
        return res;
    }

    private int[] dfs(int i, List<Integer>[] points, int[] ls) {
        int[] curLs = new int[26];
        curLs[ls[i]]++;
        for (int child : points[i]){
            if (visited[child]){
                continue;
            }
            visited[child] = true;
            int[] childLs = dfs(child, points, ls);
            for (int k = 0; k < 26; k++){
                curLs[k] += childLs[k];
            }
        }
        res[i] = curLs[ls[i]];
        return curLs;
    }
}
