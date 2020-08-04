package top.tinn.Contest.Contest_Single_197.Problem_03;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.*;

public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++){
            //无向图
            graph.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(new Node(edges[i][1], succProb[i]));
            graph.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(new Node(edges[i][0], succProb[i]));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        queue.offer(new Node(start, 1.0d));
        boolean[] visited = new boolean[n];
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.node == end){
                return cur.prob;
            }
            if (!visited[cur.node]){
                visited[cur.node] = true;
                List<Node> nodes = graph.get(cur.node);
                if (nodes == null){
                    continue;
                }
                for (Node node : nodes){
                    queue.offer(new Node(node.node, cur.prob * node.prob));
                }
            }
        }
        return 0;
    }

    class Node{
        int node;
        double prob;

        public Node(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }
}
