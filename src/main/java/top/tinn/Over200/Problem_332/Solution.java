package top.tinn.Over200.Problem_332;

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/8/27 10:40
 */
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        if (tickets == null || tickets.size() == 0){
            return ans;
        }
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets){
            PriorityQueue<String> neighbor = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            neighbor.add(ticket.get(1));
        }
        visit(graph, "JFK", ans);
        return ans;
    }

    private void visit(Map<String, PriorityQueue<String>> graph, String src, List<String> ans) {
        PriorityQueue<String> neighbor = graph.get(src);
        while (neighbor != null && neighbor.size() > 0){
            String dest = neighbor.poll();
            visit(graph, dest, ans);
        }
        ans.add(0, src);
    }

    @Test
    public void test(){
        List<List<String>> tickets = new ArrayList<>();
        
    }
}
