package top.tinn.Over200.Problem_933;

import java.util.*;

public class RecentCounter {
    private List<Integer> queue;
    private int cur;
    public RecentCounter() {
        queue = new ArrayList<>();
        cur = 0;
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty() && queue.get(cur) < t - 3000){
            cur++;
        }
        return queue.size() - cur;
    }
}
