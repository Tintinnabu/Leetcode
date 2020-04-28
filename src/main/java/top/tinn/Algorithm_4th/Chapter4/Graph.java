package top.tinn.Algorithm_4th.Chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName Graph
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/24 13:40
 */
public class Graph {
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Graph(int v) {
        V = v;
        E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
