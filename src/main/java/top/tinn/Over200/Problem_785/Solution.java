package top.tinn.Over200.Problem_785;

import java.util.*;

public class Solution {
    //dfs
    public boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0){
            return false;
        }
        int v = graph.length;
        //0,1,2
        int[] colors = new int[v];
        for (int i = 0; i < graph.length; i++){
            if (!dfs(graph, i, colors, 0))
                return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int i, int[] colors, int lastColor) {
        if (colors[i] != 0){
            return colors[i] != lastColor;
        }
        colors[i] = lastColor == 1 ? 2 : 1;
        for (int j = 0; j < graph[i].length; j++){
            if (!dfs(graph, graph[i][j], colors, colors[i])){
                return false;
            }
        }
        return true;
    }

    //bfs
    public boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for (int i = 0; i < graph.length; i++){
            if (colors[i] == 0){
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                colors[i] = 1;
                while (!queue.isEmpty()){
                    int node = queue.poll();
                    int color = colors[node] == 1 ? 2 : 1;
                    for (int neighbor : graph[node]){
                        if (colors[neighbor] == 0){
                            queue.offer(neighbor);
                            colors[neighbor] = color;
                        }else if (colors[neighbor] != color){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
