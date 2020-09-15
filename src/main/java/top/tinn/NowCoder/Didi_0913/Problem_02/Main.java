package top.tinn.NowCoder.Didi_0913.Problem_02;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 19:37
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        while (groups > 0){
            String[] nmk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nmk[0]); //共n个小岛
            int m = Integer.parseInt(nmk[1]); //m条小岛之间的费用
            int k = Integer.parseInt(nmk[2]); //单座桥的成本上限
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < m; i++){
                String[] temp = scanner.nextLine().split(" ");
                int from = Integer.parseInt(temp[0]);
                int to = Integer.parseInt(temp[1]);
                int fee = Integer.parseInt(temp[2]);
                if (fee <= k){
                    list.add(new Node(from, to));
                }
            }
            if (canVisited(list, n)){
                sb.append("Yes\n");
            }else {
                sb.append("No\n");
            }
            groups--;
        }
        System.out.println(sb.toString());
    }

    private static boolean canVisited(List<Node> list, int n) {
        if (list.size() < n - 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        boolean changed = true;
        boolean[] visited = new boolean[list.size()];
        visited[0] = true;
        Node node = list.get(0);
        set.add(node.from);
        set.add(node.to);
        while (changed){
            changed = false;
            for (int i = 1; i < list.size(); i++){
                if (!visited[i]){
                    Node cur = list.get(i);
                    if (set.contains(cur.from) || set.contains(cur.to)){
                        set.add(cur.from);
                        set.add(cur.to);
                        changed = true;
                        visited[i] = true;
                    }
                }
            }
        }
        return set.size() == n;
    }

    static class Node{
        public int from;
        public int to;
        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
